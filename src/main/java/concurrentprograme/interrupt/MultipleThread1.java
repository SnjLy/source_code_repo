package concurrentprograme.interrupt;

/**
 * 使用synchronized实现临界资源的可见性和互斥性
 * Created by admin on 2017/3/30.
 */
public class MultipleThread1 {

    private Double age;

   /* public synchronized Double getAge() {
        return age;
    }

    public synchronized void setAge(Double age) {
        this.age = age;
    }*/

    //不加锁
    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setM1(new MultipleThread1());
        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();
    }


}

class MyThread implements Runnable{

    private MultipleThread1 m1 ;

    public MultipleThread1 getM1() {
        return m1;
    }

    public void setM1(MultipleThread1 m1) {
        this.m1 = m1;
    }

    @Override
   /* public void run() {
        *//*MultipleThread1 m1 = new MultipleThread1();*//*
        System.out.println("\n\nthread name:"+Thread.currentThread().getName()+"start, age:"+m1.getAge());
        m1.setAge(Math.random()*20);
        System.out.println("change age:"+m1.getAge());
        System.out.println("thrad name:"+Thread.currentThread().getName()+"end,age:"+m1.getAge());
       *//* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*
    }*/

    public synchronized void run() {
        /*MultipleThread1 m1 = new MultipleThread1();*/
        System.out.println("\n\nthread name:"+Thread.currentThread().getName()+"start, age:"+m1.getAge());
        m1.setAge(Math.random()*20);
        System.out.println("change age:"+m1.getAge());
        System.out.println("thrad name:"+Thread.currentThread().getName()+"end,age:"+m1.getAge());
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}

