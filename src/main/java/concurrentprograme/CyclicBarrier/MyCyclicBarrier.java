package concurrentprograme.CyclicBarrier;import java.util.concurrent.BrokenBarrierException;import java.util.concurrent.CyclicBarrier;import java.util.concurrent.TimeUnit;/** * Created by admin on 2017/4/26. */public class MyCyclicBarrier {    public static void main(String[] args) {        final int PARTICIPANTS = 5;        Group group = new Group("监听者","所有证据齐全，准备抓捕嫌疑人");        //37.  创建 CyclicBarrier 对象，名为 barrier。此对象会等待5个线程。当此线程结束后，它会执行前面创建的 Grouper 对象。        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, group);        Task1 task[] = new Task1[PARTICIPANTS];        System.out.println("main thread start do task");        for(int i =0 ;i< PARTICIPANTS; i++ ){            task[i] = new Task1("task"+i +"收集证据", barrier, i);            new Thread(task[i]).start();        }        System.out.println("main thread end!");    }}class Task1 implements Runnable{    private String name;    private int count;    private CyclicBarrier barrier;    public Task1(String name, CyclicBarrier barrier, Integer count) {        this.name = name;        this.barrier = barrier;        this.count=count;    }    @Override    public void run() {        System.out.printf("%d task is start, %s thread do %s 开始!\n",count, Thread.currentThread().getName(), this.name);        try {            TimeUnit.SECONDS.sleep(2);        } catch ( InterruptedException e ) {            e.printStackTrace();        }        System.out.printf("%d task is end, %s thread do %s 完成!\n",count, Thread.currentThread().getName(), this.name);        try {            this.barrier.await();        } catch ( InterruptedException e ) {            e.printStackTrace();        } catch ( BrokenBarrierException e ) {            e.printStackTrace();        }    }}class Group implements Runnable{    private String name;    private String job;    public Group(String name, String job){        this.name = name;        this.job = job;    }    @Override    public void run() {        System.out.printf("finnal Group thread start, %s do task %s\n", name, job);        try {            TimeUnit.SECONDS.sleep(2);        } catch ( InterruptedException e ) {            e.printStackTrace();        }        System.out.printf("finnal Group thread end, %s do task %s\n", name, job);    }}