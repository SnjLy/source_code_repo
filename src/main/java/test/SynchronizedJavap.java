package test;

/**
 * @Package: test
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/29.
 */
public class SynchronizedJavap {


    public static void main(String[] args) {
        synchronized (SynchronizedJavap.class){
            System.out.println("Synchronized");
        }
    }
}
