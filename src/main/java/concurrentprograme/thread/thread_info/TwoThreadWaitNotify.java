package concurrentprograme.thread.thread_info;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description: 采用线程等待通知模式 的线程通信方式 实现交替打印奇偶数
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class TwoThreadWaitNotify {

    private int start = 1;

    private boolean flag = false;

    public static void main(String[] args) {
        TwoThreadWaitNotify two = new TwoThreadWaitNotify();
        Thread t1 = new Thread(new OddNum(two));
        t1.setName("t1");
        Thread t2 = new EvenNum(two);
        t2.setName("t2");

        t1.start();
        t2.start();

    }


    /**
     * 奇数线程类
     */
    static class OddNum implements Runnable {

        private TwoThreadWaitNotify number;

        public OddNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start < 100) {
                // synchronized (TwoThreadWaitNotify.class) {   //利用了 TwoThreadWaitNotify.class 对象完成了通信
                synchronized (number) {
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "--奇数--：" + number.start);
                        number.start++;
                        number.flag = true;

                        // TwoThreadWaitNotify.class.notify();
                        number.notify();
                    } else {
                        try {
                            //TwoThreadWaitNotify.class.wait();
                            number.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }


    /**
     * 偶数线程类
     */
    static class EvenNum extends Thread {

        private TwoThreadWaitNotify number;

        public EvenNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start < 100) {
                //synchronized (TwoThreadWaitNotify.class) {
                synchronized (number) {
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "--偶数-：" + number.start);
                        number.start++;
                        number.flag = false;

                        //TwoThreadWaitNotify.class.notify();
                        number.notify();
                    } else {
                        try {
                            //TwoThreadWaitNotify.class.wait();
                            number.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }
}

/*
等待通知有着一个经典范式：

        线程 A 作为消费者：

        获取对象的锁。
        进入 while(判断条件)，并调用 wait() 方法。
        当条件满足跳出循环执行具体处理逻辑。
        线程 B 作为生产者:

        获取对象锁。
        更改与线程 A 共用的判断条件。
        调用 notify() 方法。
        伪代码如下:


    //Thread A
    synchronized(Object){
        while(条件){
        Object.wait();
        }
        //do something
    }
    //Thread B
    synchronized(Object){
        条件=false;//改变条件
        Object.notify();
    }
*/
