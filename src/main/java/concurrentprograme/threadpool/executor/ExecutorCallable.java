package concurrentprograme.threadpool.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author  yehao
 * @function: demo for executor callable<T>
 */
public class ExecutorCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();

        List<Future<String>> results = new ArrayList<>();
        for (Integer i = 0; i < 50; i++) {
            MyTask task = new MyTask("task:" + i);
            Future<String> future = executorService.submit(task);
            results.add(future);
            //future.get()会将程序变成同步，等到结果返回之后再执行下一个
        }

        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println("是否关闭：" + executorService.isTerminated());
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            System.out.println("程序还在运行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("线程池是否关闭：" + executorService.isShutdown());
        System.out.println("程序结束");
        for (Future<String> future : results) {
            try {
                System.out.println("执行结果：" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}


class MyTask implements Callable<String> {

    private String param;

    public MyTask(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        System.out.println("开始执行任务，param=" + param);
        Thread.sleep(1000);
        return param;
    }
}
