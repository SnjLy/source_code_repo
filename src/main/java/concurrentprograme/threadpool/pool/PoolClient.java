package concurrentprograme.threadpool.pool;

import java.util.concurrent.*;

/**
 * @Package: concurrentprograme.threadpool.pool
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/11/7.
 */
public class PoolClient {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(10);
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 2,
                TimeUnit.MILLISECONDS, queue);

        for (int i = 0; i < 20; i++) {
            MyTask task = new MyTask("任务" + i);
            try {
                executorService.submit(task);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("队列长度：" + queue.size());
        }
        executorService.shutdown();
        System.out.println("线程执行完成？" + executorService.isTerminated());
        try {
            while (!executorService.awaitTermination(10, TimeUnit.MILLISECONDS)){
                System.out.println("剩余任务：" + queue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("等待线程池错误" + e.getMessage());
        }
        System.out.println("线程池关闭");

    }
}

class MyTask implements Callable<String>{
    private String param;

    public MyTask(String param) {
        this.param = param;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        System.out.println("do " + param);
        Thread.sleep(100);
        return param;
    }
}
