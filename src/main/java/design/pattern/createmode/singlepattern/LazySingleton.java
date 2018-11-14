package design.pattern.createmode.singlepattern;

/**
 * 懒汉模式2
 * 使用同步锁解决多线程下的并发问题，但是每个线程进入是都需要synchronized，效率不高
 * 不推荐
 *
 * Created by yehao on 2018/5/16.
 */
public class LazySingleton {

    private  String name;
    private static LazySingleton instance = null;
    private LazySingleton() {setName(""+System.currentTimeMillis());}

    /**
     * 同步1 改进1
     * 使用synchronized 关键字保证线程并发安全，但是每个都进入同步快，比较耗时，效率不高
     * 不推荐
     */
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    /**
     * 同步2 改进2
     * 使用synchronized 关键字保证线程并发安全，但是只在初始化对象时进入同步快，
     * 存在的问题是前一个线程已经执行了，系统中instance != null 但是后面的线程直接进入同步块，会再次初始化一个对象
     * 不使用
     *
     */
    public static LazySingleton getInstance2() {
        if (instance == null) {    //多线程都到这里，但是只有一个进入同步块
            synchronized (LazySingleton.class) {    //前一个线程已经执行了，instance != null 但是没判断
                instance = new LazySingleton();
            } }
        return instance;
    }

    /**
     * 同步3 改进3   double-check
     * 使用synchronized 关键字保证线程并发安全，但是只在初始化对象时进入同步快，
     * 存在的问题是前一个线程已经执行了，系统中instance != null 但是后面的线程直接进入同步块，会再次初始化一个对象
     * 需要注意的是，如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之 前增加修饰符volatile，
     * 被volatile修饰的成员变量可以确保多个线程都能够正确处理，
     * 且该代 码只能在JDK 1.5及以上版本中才能正确执行。由于volatile关键字会屏蔽Java虚拟机所做的一 些代码优化，
     * 可能会导致系统运行效率降低，因此即使使用双重检查锁定来实现单例模式也 不是一种完美的实现方式。
     *
     * 需要使用volatile 关键字来保证多线程下操作 instance时，对其他线程可见性
     *
     * 不推荐
     */
    public static LazySingleton getInstance3() {
       // private static volatile LazySingleton instance = null;
        if (instance == null) {    //多线程都到这里，但是只有一个进入同步块
            synchronized (LazySingleton.class) {    //前一个线程已经执行了，系统此时instance != null
                if (null == instance) {  // double-check
                    instance = new LazySingleton();
                }
            } }
        return instance;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * 执行结果：
     * Thread-6 lazy1 name:1526456144920
        Thread-6 lazy2 name:1526456144920
        Thread-6 lazy3 name:1526456144920
        Thread-7 lazy1 name:1526456144920
        Thread-7 lazy2 name:1526456144920
        Thread-7 lazy3 name:1526456144920
        Thread-8 lazy1 name:1526456144920
        Thread-8 lazy2 name:1526456144920
        Thread-8 lazy3 name:1526456144920
        Thread-9 lazy1 name:1526456144920
        Thread-9 lazy2 name:1526456144920
        耗时：17
     */
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
            LazySingleton lazy1 = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " lazy1 name:" + lazy1.getName());
            LazySingleton lazy2 = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " lazy2 name:" + lazy2.getName());
            LazySingleton lazy3 = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " lazy3 name:" + lazy3.getName());
        }
    }
}
