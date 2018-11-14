package design.pattern.createmode.singlepattern;

import javax.xml.crypto.Data;

/**
 * 恶汉式单例模式，既在静态类在类加载时既初始化静态属性，确保只有一个对象
 * 但是类加载就初始化对象，浪费资源， 不推荐使用
 * Created by yehao on 2018/5/16.
 */
public class EagerSingleton {
    private String name;
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        this.name = "" + System.currentTimeMillis();
    }

    public static EagerSingleton getInstance(){
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /*
    *  执行结果：
    Thread-5 eager3 name:1526455543292
    Thread-6 eager1 name:1526455543292
    Thread-6 eager2 name:1526455543292
    Thread-6 eager3 name:1526455543292
    Thread-7 eager1 name:1526455543292
    Thread-7 eager2 name:1526455543292
    Thread-7 eager3 name:1526455543292
    Thread-8 eager1 name:1526455543292
    Thread-8 eager2 name:1526455543292
    Thread-8 eager3 name:1526455543292
    Thread-9 eager1 name:1526455543292
    Thread-9 eager2 name:1526455543292
    耗时：3
     */
    //模拟客户端， 调用单例模式，实际上是同一个对象
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[10];

        for (int i= 0; i< 10; i++){
            Thread thread = new MyThread();
            threads[i] = thread;
        }
        for (Thread thread : threads) {
            thread.start();
        }
        System.out.println("耗时："+ (System.currentTimeMillis() - start));
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            EagerSingleton eager1 = EagerSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " eager1 name:" + eager1.getName());
            EagerSingleton eager2 = EagerSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " eager2 name:" + eager2.getName());
            EagerSingleton eager3 = EagerSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " eager3 name:" + eager3.getName());
        }
    }

}
