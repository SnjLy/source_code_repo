package concurrentprograme.interrupt;

/**
 * *********************挂起和恢复线程**************************
 * Thread 的API中包含两个被淘汰的方法，（suspend和resume）它们用于临时挂起和重启某个线程，这些方法已经被淘汰，因为它们是不安全的，
 * 不稳定的。如果在不合适的时候挂起线程（比如，锁定共享资源时），此时便可能会发生死锁条件——其他线程在等待该线程释放锁，
 * 但该线程却被挂起了，便会发生死锁。另外，在长时间计算期间挂起线程也可能导致问题。
 *
 * *********************终止线程*********************
 *当调用Thread的start（）方法，执行完run（）方法后，或在run（）方法中return，线程便会自然消亡。另外Thread API中包含了一个stop（）方法，
 *可以突然终止线程。但它在JDK1.2后便被淘汰了，因为它可能导致数据对象的崩溃。一个问题是，当线程终止时，很少有机会执行清理工作；另一个问题是，
 *当在某个线程上调用stop（）方法时，线程释放它当前持有的所有锁，持有这些锁必定有某种合适的理由——也许是阻止其他线程访问尚未处于一致性状态的数据，
 *突然释放锁可能使某些对象中的数据处于不一致状态，而且不会出现数据可能崩溃的任何警告。
 *终止线程的替代方法：同样是使用标志位，通过控制标志位来终止线程。
 *
 * 以下方法是用过设置标志位来实现线程挂起和恢复的策略——设置标志位。通过该方法实现线程的挂起和恢复有一个很好的地方，就是可以在线程的指定位置实现线程的挂起和恢复，而不用担心其不确定性。
 * Created by yehao on 2017/3/24.
 */
public class AlternateSuspendResume implements Runnable {

    private volatile int firstVal;
    private volatile int secondVal;

    //增加标志位，用来实现线程的挂起和恢复
    private volatile boolean suspended;   //保证每次读都是从主存中读取，避免缓存导致值不是最新状态

    @Override
    public void run() {
        try {
            suspended = false;
            firstVal = 0;
            secondVal = 0;
            workMethod();
        } catch ( InterruptedException x ) {
            System.out.println("interrupted while in workMethod()");
        }
    }

    public boolean areValuesEqual() {
        return ( firstVal == secondVal );
    }

    private void workMethod() throws InterruptedException {
        int val = 1;

        while ( true ) {
            //仅当线程挂起时，才运行这行代码
            waitWhileSuspended();

            stepOne(val);
            stepTwo(val);
            val++;

            //仅当线程挂起时，才运行这行代码
            waitWhileSuspended2();

            Thread.sleep(200);
        }
    }

    private void stepOne(int newVal)
            throws InterruptedException {

        firstVal = newVal;
        Thread.sleep(300);
    }

    private void stepTwo(int newVal) {
        secondVal = newVal;
    }

    public void suspendRequest() {
        suspended = true;
    }

    public void resumeRequest() {
        suspended = false;
    }

    private void waitWhileSuspended() throws InterruptedException {

        //这是一个“繁忙等待”技术的示例。
        //它是非等待条件改变的最佳途径，因为它会不断请求处理器周期地执行检查，
        //更佳的技术是：使用Java的内置“通知-等待”机制
        while (suspended) {
            Thread.sleep(200);
            System.out.println("终于等到你，正在执行秘密任务。suspended="+ suspended);
        }
    }

    private void waitWhileSuspended2() throws InterruptedException {

        //这是一个“繁忙等待”技术的示例。
        //它是非等待条件改变的最佳途径，因为它会不断请求处理器周期地执行检查，
        //更佳的技术是：使用Java的内置“通知-等待”机制
        while (suspended) {
            Thread.sleep(200);
            System.out.println("hello, girl! maybe you should like me。suspended="+ suspended);
        }
    }

    public static void main(String[] args) {
        AlternateSuspendResume asr = new AlternateSuspendResume();

        Thread t = new Thread(asr);
        t.start();

        //休眠1秒，让其他线程有机会获得执行
        try {
            Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        for ( int i = 0; i < 10; i++ ) {
            asr.suspendRequest();   //改变标志位，线程挂起

            //让线程有机会注意到挂起请求
            //注意：这里休眠时间一定要大于
            //stepOne操作对firstVal赋值后的休眠时间，即300ms，
            //目的是为了防止在执行asr.areValuesEqual（）进行比较时,
            //恰逢stepOne操作执行完，而stepTwo操作还没执行
            try {
                Thread.sleep(350);
            }
            catch ( InterruptedException x ) { }

            System.out.println("dsr.areValuesEqual()=" +  asr.areValuesEqual());

            asr.resumeRequest(); //改变标志位，恢复线程

            try {
                //线程随机休眠0~2秒
                Thread.sleep(( long ) (Math.random() * 2000.0) );
            } catch ( InterruptedException x ) {
                //略
            }
        }

        System.exit(0); //退出应用程序
    }
}
