package concurrentprograme.interrupt;

/**
 * Created by admin on 2017/2/23.
 */
public class Thread1 {
    private int age ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable run!");
            }
        })
        {
            public void run() {
                Thread1 t1 = new Thread1();
                t1.setAge(20);
                System.out.println("subthread run! thread name:" +Thread.currentThread().getName());
                System.out.println("thread name:" +Thread.currentThread().getName()+ " age:"+ t1.getAge());
            }
        }.start();


        try {
            Thread1 t = new Thread1();
            t.setAge(100);
            System.out.println("main thread:"+t.getAge());
            System.out.println("main thread run start, thread name :"+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("main thread sleep end, age:"+t.getAge());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
