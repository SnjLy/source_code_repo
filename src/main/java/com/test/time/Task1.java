package com.test.time;

/**
 * 普通thread 
 * 这是最常见的，创建一个thread，然后让它在while循环里一直运行着， 
 * 通过sleep方法来达到定时任务的效果。这样可以快速简单的实现，代码如下： 
 * @author yehao
 *2016年3月1日
 */
public class Task1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int second=1000;//run in a second
		
		Thread thread=new Thread(new Runnable(){
			int k=0;
			public void run() {
				System.out.println("hello :"+k++);
				try {
					Thread.sleep(second);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		int k=0;
		while(k<10){
			thread.run();
			k++;
		}
	}

}
