package concurrentprograme.async.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * concurrentprograme.async.completable_future
 *
 * @author: SNJly
 * @date: 2019-06-24
 */
public class CompletableFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(getThreadName() + "执行...");
                    completableFuture.complete("success");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();

        //主线程阻塞等待
        String result = completableFuture.get();
        System.out.println(getThreadName() + "执行结果:" + result);


        asyncCallback();
    }


    private static String getThreadName(){
        return Thread.currentThread().getName();
    }


    public static void asyncCallback() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(getThreadName()+"==>supplyAsync");
                return "123";
            }
        });

        CompletableFuture<Integer> result1 = task.thenApply(num -> {
            System.out.println(getThreadName() + "==>thenApply1");
            return Integer.parseInt(num);
        });

        CompletableFuture<Integer> sumNum = result1.thenApply(num ->{
            System.out.println(getThreadName() + "==>thenApply2");
            return num*3;
        });
        System.out.println(getThreadName()+"==>" + sumNum.get());
    }
}
