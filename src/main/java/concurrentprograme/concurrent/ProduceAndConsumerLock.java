package concurrentprograme.concurrent;import com.alibaba.fastjson.JSON;import java.util.concurrent.locks.Condition;import java.util.concurrent.locks.Lock;import java.util.concurrent.locks.ReentrantLock;/** * ava 5之后，我们可以用Reentrantlock锁配合Condition对象上的await（）和signal（）或signalAll（）方法来实现线程间协作。 * 在ReentrantLock对象上newCondition（）可以得到一个Condition对象，可以通过在Condition上调用await（）方法来挂起一个任务（线程）， * 通过在Condition上调用signal（）来通知任务，从而唤醒一个任务，或者调用signalAll（）来唤醒所有在这个Condition上被其自身挂起的任务。 * 另外，如果使用了公平锁，signalAll（）的与Condition关联的所有任务将以FIFO队列的形式获取锁，如果没有使用公平锁，则获取锁的任务是随机的， * 这样我们便可以更好地控制处在await状态的任务获取锁的顺序。与notifyAll（）相比，signalAll（）是更安全的方式。 * 另外，它可以指定唤醒与自身Condition对象绑定在一起的任务。 * Created by yehao on 2017/4/7. */public class ProduceAndConsumerLock {    public static void main(String[] args) {        Info info = new Info(); // 实例化Info对象        Producer1 pro = new Producer1(info); // 生产者        Thread thread = new Thread(pro);        thread.start();        //启动了生产者线程后，再启动消费者线程        try {            Thread.sleep(500);        } catch ( InterruptedException e ) {            e.printStackTrace();        }        Consumer1 con = new Consumer1(info);       /* con.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {            @Override            public void uncaughtException(Thread t, Throwable e) {                System.out.println(t.getName() + "---"+ e.getMessage());            }        });*///设置一个未捕捉异常的处理者        con.start();// 消费者    }}class Info {    private String name = "name";    private String content = "content";    private boolean flag = true; // 设置标志位    private Lock lock = new ReentrantLock();    private Condition condition = lock.newCondition(); //产生一个条件变量    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public String getContent() {        return content;    }    public void setContent(String content) {        this.content = content;    }    public String set(String name, String content){        lock.lock();        try {            while (!flag){                condition.await();  //等待            }            this.setName(name);            Thread.sleep(300);            this.setContent(content);            System.out.println("producer:"+name+"---"+content);            flag = false;            condition.signal();        } catch ( InterruptedException e ) {            e.printStackTrace();        }finally {            System.out.println("producer-释放锁"+Thread.currentThread().getName()+",condition"+ JSON.toJSONString(condition));            lock.unlock();        }        return JSON.toJSONString(this);    }    public String get(){        lock.lock();        try {            while (flag) {                condition.await();            }            Thread.sleep(300);            System.out.println("name:"+this.getName()+"***content:"+this.getContent());            flag=true;            condition.signal();        } catch ( InterruptedException e ) {            e.printStackTrace();        }finally {            System.out.println("consumer-释放锁"+Thread.currentThread().getName()+",condition"+ JSON.toJSONString(condition));            lock.unlock();        }        return JSON.toJSONString(this);    }}class Producer1 implements Runnable{    private Info info = null;    public Producer1(Info info){        this.info = info;    }    @Override    public void run() {        for (int i =0; i<10;i++){            this.info.set("姓名"+i,"内容"+i);        }    }}class Consumer1 extends Thread{    private Info info = null;    public Consumer1(Info info){        this.info = info;    }    @Override    public void run(){        for(int i=0;i<10;i++){            this.info.get() ;        }    }}