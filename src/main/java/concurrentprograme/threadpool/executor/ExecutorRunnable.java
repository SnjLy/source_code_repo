package concurrentprograme.threadpool.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Package: concurrentprograme.threadpool.executor
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/11/7.
 */
public class ExecutorRunnable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            MyTack tack = new MyTack("task-" + i);
            executorService.submit(tack);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println("是否关闭：" + executorService.isTerminated());

        executorService.shutdown();
        while (!executorService.isTerminated()){
            System.out.println("程序还在运行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束");

    }
}

class MyTack implements Runnable{
    private String  name;

    public MyTack(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + "我来执行任务了");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "执行完成！！！");
    }
}