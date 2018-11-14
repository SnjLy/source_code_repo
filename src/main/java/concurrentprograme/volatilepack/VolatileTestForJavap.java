package concurrentprograme.volatilepack;

/**
 * <p>根据java内存模型中的happen-before法则，对volatile的规则定义为：</p>
 * Volatile variable rule. A write to a volatile field happens-before every subsequent read of that same field.
 * 也即是说，只要按照顺序写入Volatile变量，读取的时候也是可以保证确定性的。
 * 但是很多人把可见性和一致性混淆在了一起，我们来看一段代码反编译后的结果：</p>
 * Created by yehao on 2017/10/13.
 */
public class VolatileTestForJavap {
    private static volatile int i = 0;


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 20; j++) {
                    System.out.println(Thread.currentThread().getName() + "---" +i++);
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        t1.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 20; k++) {
                    System.out.println(Thread.currentThread().getName() + "---" +i++);
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        thread.start();
    }
}


/**
 * $ javap -c VolatileTestForJavap
 Compiled from "VolatileTestForJavap.java"
 public class concurrentprograme.volatilepack.VolatileTestForJavap {
 public concurrentprograme.volatilepack.VolatileTestForJavap();
 Code:
 0: aload_0
 1: invokespecial #2                  // Method java/lang/Object."<init>":()V
 4: return

 public static void main(java.lang.String[]);
 Code:
 0: new           #3                  // class java/lang/Thread
 3: dup
 4: new           #4                  // class concurrentprograme/volatilepack/VolatileTestForJavap$1
 7: dup
 8: invokespecial #5                  // Method concurrentprograme/volatilepack/VolatileTestForJavap$1."<init>":()V
 11: invokespecial #6                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
 14: astore_1
 15: aload_1
 16: invokevirtual #7                  // Method java/lang/Thread.start:()V
 19: new           #3                  // class java/lang/Thread
 22: dup
 23: new           #8                  // class concurrentprograme/volatilepack/VolatileTestForJavap$2
 26: dup
 27: invokespecial #9                  // Method concurrentprograme/volatilepack/VolatileTestForJavap$2."<init>":()V
 30: invokespecial #6                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
 33: astore_2
 34: aload_2
 35: invokevirtual #7                  // Method java/lang/Thread.start:()V
 38: return

 static int access$008();
 Code:
 0: getstatic     #1                  // Field i:I
 3: dup
 4: iconst_1
 5: iadd
 6: putstatic     #1                  // Field i:I
 9: ireturn

 static {};
 Code:
 0: iconst_0
 1: putstatic     #1                  // Field i:I
 4: return
 }
 */
