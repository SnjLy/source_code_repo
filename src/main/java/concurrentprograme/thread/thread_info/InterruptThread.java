package concurrentprograme.thread.thread_info;

import java.util.concurrent.TimeUnit;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:      使用线程中断控制线程运行
 * @function:       采用中断线程的方式来通信，调用了 thread.interrupt() 方法其实就是将 thread 中的一个标志属性置为了 true。中断线程
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class InterruptThread implements Runnable{

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " is running....");
        }
        System.out.println(Thread.currentThread().getName() + " end, stop running.");

    }

    public static void main(String[] args) {

        Thread thread = new Thread(new InterruptThread(), "threadA");
        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("main thread stop running!!!");
    }
}
