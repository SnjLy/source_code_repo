package concurrentprograme.thread.thread_info;

import java.io.*;

/**
 * @Package: concurrentprograme.thread.thread_info
 * @Description:   使用管道实现线程通信， 虽然java基于内存实现线程通信，通过管道也可以实现线程通信
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/10.
 */
public class PipeThreadInfo {

    public static void main(String[] args) {
        // 面向字节流
        //PipedInputStream pipedInputStream = new PipedInputStream();
        //PipedOutputStream pipedOutputStream = new PipedOutputStream();

        //面向字符
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();

        //输入输出流建立连接
        try {
            pipedWriter.connect(pipedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始写数据");
                for (int i = 0; i < 10; i++) {
                    try {
                        pipedWriter.write(i+"");
                        System.out.println("写入："+ i);
                        Thread.sleep(10);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    pipedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("读数据");
                int msg = 0;
                try {
                    while ((msg = pipedReader.read()) != -1) {
                        System.out.println("msg=" + (char) msg);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    pipedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        t1.start();
        t2.start();

        System.out.println("main end");

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                pipedWriter.close();
//                pipedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
