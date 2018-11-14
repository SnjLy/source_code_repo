package concurrentprograme.interrupt;

/**
 * 线程中断：
 *      使用interrupt（）中断线程
 *          当一个线程运行时，另一个线程可以调用对应的Thread对象的interrupt（）方法来中断它，该方法只是在目标线程中设置一个标志，
 *          表示它已经被中断，并立即返回。这里需要注意的是，如果只是单纯的调用interrupt（）方法,如果没有return，线程并没有实际被中断，会继续往下执行。
 *          如果线程在调用sleep（）方法前被中断，那么该中断称为 待决中断 ，它会在刚调用sleep（）方法时，立即抛出InterruptedException异常。
 *
 *      使用isInterrupted（）方法判断中断状态
 *          可以在Thread对象上调用isInterrupted（）方法来检查任何线程的中断状态。这里需要注意：线程一旦被中断，isInterrupted（）方法
 *          便会返回true，而一旦sleep（）方法抛出异常，它将清空中断标志，此时isInterrupted（）方法将返回false。
 *
 *     使用Thread.interrupted（）方法判断中断状态
            可以使用Thread.interrupted（）方法来检查当前线程的中断状态（并隐式重置为false）。又由于它是静态方法，因此不能在特定的线程上使用，而
            只能报告调用它的线程的中断状态，如果线程被中断，而且中断状态尚不清楚，那么，这个方法返回true。与isInterrupted（）不同，
            它将自动重置中断状态为false，第二次调用Thread.interrupted（）方法，总是返回false，除非中断了线程。
 * Created by admin on 2016/12/23.
 */
public class ThreadInterrupt implements Runnable {

    public void run(){
        try{
            System.out.println("Thread name:"+ Thread.currentThread().getName()+"in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("Thread name:"+ Thread.currentThread().getName()+"in run() - woke up");
        }catch(InterruptedException e){
            System.out.println("Thread name:"+ Thread.currentThread().getName()+ "in run() - interrupted while sleeping");
            //处理完中断异常后，返回到run（）方法人口，
            //如果没有return，线程不会实际被中断，它会继续打印下面的信息
            return;
        }
        System.out.println("in run() - leaving normally");
    }


    //使用thread.interrupt()中断其他线程
    /*public static void main(String[] args) {
        ThreadInterrupt si = new ThreadInterrupt();
        Thread t = new Thread(si);
        t.start();
        System.out.println("Thread name:"+ Thread.currentThread().getName()+" running");
        //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread name:"+ Thread.currentThread().getName()+" in main() - interrupting other thread");
        //中断线程t
        t.interrupt();
        System.out.println("Thread name:"+ Thread.currentThread().getName()+" in main() - leaving");
    }*/


    //判断中断状态
    public static void main(String[] args){
        Thread t = Thread.currentThread();
        System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());
        //待决中断，中断自身
        t.interrupt();
        System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());
        System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());

        try{
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        }catch( InterruptedException x){
            System.out.println("was interrupted");
            //抛出异常后，在异常中清除异常标志
            x.printStackTrace();
        }
        //抛出异常后，会清除中断标志，这里会返回false
        System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());


        System.out.println("Point X: Thread.interrupted()=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("Point Y: Thread.interrupted()=" + Thread.interrupted());
        System.out.println("Point Z: Thread.interrupted()=" + Thread.interrupted());
    }
}
