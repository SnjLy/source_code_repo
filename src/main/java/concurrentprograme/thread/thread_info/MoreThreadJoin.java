package concurrentprograme.thread.thread_info;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:  使用线程join 方法让子线程全部完成之后，其他线程才执行
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class MoreThreadJoin {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setName("t2");

        t1.start();
        t2.start();

        //等待线程1终止
        try {
            System.out.println("等待t1终止");
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1终止");
        //等待线程2终止
        try {
            System.out.println("等待t2终止");
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t2终止");

        System.out.println("main end");
    }
}
