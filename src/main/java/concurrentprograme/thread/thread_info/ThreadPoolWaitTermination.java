package concurrentprograme.thread.thread_info;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:   如果是用线程池来管理线程，可以使用线程池 awaitTermination() 方法来让主线程等待线程池中所有任务执行完毕:
 * @function:      使用这个 awaitTermination() 方法的前提需要关闭线程池，如调用了 shutdown() 方法。
 *                 调用了 shutdown() 之后线程池会停止接受新任务，并且会平滑的关闭线程池中现有的任务。
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class ThreadPoolWaitTermination {


    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS, queue);

        for (int i = 1; i < 5; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread" + finalI + "is running....");
                    if (finalI ==2){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (finalI ==3){
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread" + finalI + "is end!!!");
                }
            });

        }

        //使用这个 awaitTermination() 方法的前提需要关闭线程池，如调用了 shutdown() 方法。
        //调用了 shutdown() 之后线程池会停止接受新任务，并且会平滑的关闭线程池中现有的任务。
        if (!executor.isShutdown()) {
            executor.shutdown();
        }
        while(!executor.awaitTermination(1, TimeUnit.MILLISECONDS)){
            System.out.println("线程池还在执行");
        }
        System.out.println("main thread end");

    }
}
