package concurrentprograme.thread.thread_info;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:  CyclicBarrier可以实现 CountDownLatch 同样的功能，但是要更加灵活。
 * @function:
 * CyclicBarrier 中文名叫做屏障或者是栅栏，也可以用于线程间通信。
        它可以等待 N 个线程都达到某个状态后继续运行的效果。
            首先初始化线程参与者。
            调用 await() 将会在所有参与者线程都调用之前等待。
            直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class CyclicBarrierThread {

    public static void main(String[] args) {
        int num = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num);

        for (int i = 0; i <3; i++) {

            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + finalI + "正在运行");
                    if (finalI == 1){
                        try {
                            //其余两个线程也要等待这个线程休眠1秒之后调用await()方法之后才会执行其他逻辑
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        //调用 await() 将会在所有参与者线程都调用之前等待。
                        //直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
                        //等待 N 个线程都达到某个状态后继续运行的效果。
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().isAlive());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread "+ finalI +" end do something");
                }
            }).start();
        }

        System.out.println("所有线程完成运行，等待状态，main thread end!!");
    }



}

  /*  CyclicBarrier 中文名叫做屏障或者是栅栏，也可以用于线程间通信。

        它可以等待 N 个线程都达到某个状态后继续运行的效果。

        首先初始化线程参与者。
        调用 await() 将会在所有参与者线程都调用之前等待。
        直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
   */