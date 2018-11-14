package concurrentprograme.thread.thread_info;

import java.util.concurrent.CountDownLatch;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:   CountDownLatch 可以实现 join 相同的功能，但是更加的灵活 , 使用countDownLatch实现线程同步，等待结果执行完之后执行某一事情
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class CountdownLatchThread {

    public static  void countDownLatch() {
        int num = 5;
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + finalI + "正在运行");
                    try {
                        Thread.sleep(100);
                        countDownLatch.countDown();
                        System.out.println("线程" + finalI + "运行结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long stop = System.currentTimeMillis();
        System.out.println("子线程运行完了，main over total time="+(stop - start));
    }


    public static void main(String[] args) {
        CountdownLatchThread.countDownLatch();
    }
}

  /*  CountDownLatch 也是基于AQS(AbstractQueuedSynchronizer) 实现的，更多实现参考 ReentrantLock 实现原理

        初始化一个 CountDownLatch 时告诉并发的线程，然后在每个线程处理完毕之后调用 countDown()方法。
        该方法会将 AQS 内置的一个 state 状态-1 。
        最终在主线程调用 await()方法，它会阻塞直到 state==0的时候返回。
        */