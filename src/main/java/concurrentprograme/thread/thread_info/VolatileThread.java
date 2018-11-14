package concurrentprograme.thread.thread_info;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:  使用volatile 线程可见性，线程1修改变量，其他线程看到变量变化，通知线程
 * @function:  因为Java 是采用共享内存的方式进行线程通信
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class VolatileThread implements Runnable{

    private volatile boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName() + " thread running .....");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " thread run end!!!");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileThread vo = new VolatileThread();
        Thread thread = new Thread(vo, "ThreadA");
        thread.start();

        System.out.println("main thread 正在运行");

        Thread.sleep(1000);

        vo.flag = false;

    }
}
