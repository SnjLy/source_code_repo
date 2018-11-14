package concurrentprograme.thread;

/**
 * 创建多线程方法1，继承thread类，实现run()
 * Created by yehao on 2017/3/24.
 */
public class NewThread1{
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }


}


class MyThread extends Thread {
    private int tickets = 5;
    public void run(){
        for (int i=0 ;i<10; i++) {
            if (tickets > 0) {
                System.out.println("thread name:" + Thread.currentThread().getName() + " current tickes:" + tickets);
                tickets--;
            }
        }
    }
}