package concurrentprograme.interrupt;

/**
 * join方法用线程对象调用，如果在一个线程A中调用另一个线程B的join方法，线程A将会等待线程B执行完毕后再执行。
 * yield可以直接用Thread类调用，yield让出CPU执行权给同等级的线程，如果没有相同级别的线程在等待CPU的执行权，则该线程继续执行。
 * Created by yehao on 2017/3/24.
 */
public class ThreadInterruprJoin implements Runnable{

    public static void main(String[] args) {
        ThreadInterruprJoin t1 = new ThreadInterruprJoin();
        Thread thread = new Thread(t1);
        thread.start();

        System.out.println("thread name:"+ Thread.currentThread().getName()+" is running");
        Thread mainThread = Thread.currentThread();
        try {
            long start = System.currentTimeMillis();
            System.out.println("thread name:"+ mainThread.getName()+" is running "+start);
            //thread.join(2000);
            // join方法用线程对象调用，如果在一个线程A中调用另一个线程B的join方法，线程A将会等待线程B执行完毕后再执行。

            Thread.yield();
            //yield可以直接用Thread类调用，yield让出CPU执行权给同等级的线程，如果没有相同级别的线程在等待CPU的执行权，则该线程继续执行
            System.out.println("thread name:"+ mainThread.getName()+" is running "+(System.currentTimeMillis()-start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        public void run(){
            System.out.println("thread name:"+ Thread.currentThread().getName() +" is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name:"+ Thread.currentThread().getName() +" is ending");
        }
}
