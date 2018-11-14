package com.test.time;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.model.Book;
import com.springmvc.service.BookService;
import com.springmvc.service.serviceImpl.BookServiceImpl;

/**
 * ScheduledExecutorService是从Java
 * SE5的java.util.concurrent里，做为并发工具类被引进的，这是最理想的定时任务实现方式。 相比于上两个方法，它有以下好处：
 * 1>相比于Timer的单线程，它是通过线程池的方式来执行任务的 2>可以很灵活的去设定第一次执行任务delay时间
 * 3>提供了良好的约定，以便设定执行的时间间隔
 * 下面是实现代码，我们通过ScheduledExecutorService#scheduleAtFixedRate展示这个例子，通过代码里参数的控制，
 * 首次执行加了delay时间。
 * 
 * @author admin 2016年3月1日
 */
public class Task3 {

	
	private static BookService bookService=new BookServiceImpl();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Runnable runnable=new Runnable(){
			int i=0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.print("task3 执行："+ i++);
				Book book=new Book();
				book.setName("西游记");
				book.setPrice(new BigDecimal(15265));
				bookService.insert(book);
				List<Book> lists=bookService.selectAllBook();
				System.out.println(lists.size());
			}
			
		};
		int initDelay=2;
		int period=1;
		ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, initDelay, period, TimeUnit.SECONDS);
	}

}
