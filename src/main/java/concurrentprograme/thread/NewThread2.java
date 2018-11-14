package concurrentprograme.thread;

/**
 * 创建多线程方法2，实现Runnable，重写run(), 新建Thread对象，将实现Runnable的类对象作为参数传入
 * Created by yehao on 2017/3/24.
 */
public class NewThread2{
    public static void main(String[] args) {
     /*   new MyThread().start();
        new MyThread().start();
        new MyThread().start();*/
        MyThread1 myThread1 = new MyThread1();
        new Thread(myThread1).start();
        new Thread(myThread1).start();
        new Thread(myThread1).start();

    }


}


class MyThread1 implements Runnable{
    private int tickets = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (tickets > 0) {
                System.out.println("thread name:" + Thread.currentThread().getName() + " current tickes:" + tickets);
                tickets--;
            }
        }
    }
}