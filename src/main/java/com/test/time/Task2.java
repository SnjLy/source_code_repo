package com.test.time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * * 于第一种方式相比，优势 1>当启动和去取消任务时可以控制 2>第一次执行任务时可以指定你想要的delay时间
 * 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。
 * 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。 下面是代码：
 * @author yehao 2016年3月1日
 */
public class Task2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimerTask task=new TimerTask() {
			int k=0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("task 执行："+k++);
			}
		};
		
		Timer timer=new Timer();
		int delay=2000;//开始后两秒执行
		int parse=1000;//每隔1秒执行一次
		timer.scheduleAtFixedRate(task, delay, parse);
	}

}
