package com.springmvc.service;

import com.springmvc.model.User;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.UUID;


public class TestUserService extends TestCase{
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyTestSpringTimer  myTestSpringTimer;
	
	@SuppressWarnings("resource")
    @Override
	protected void setUp() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService) ac.getBean("userService");
		bookService=(BookService) ac.getBean("bookService");
		myTestSpringTimer = (MyTestSpringTimer) ac.getBean("myTestSpringTimer");
	}
	
	public void testSelectById(){
		User u=userService.selectByPrimaryKey(1);
		System.out.println(u.getUsername()+"-"+u.getPassword()+"-"+u.getAge());
	}
	

	public void testInsert(){
		User u=new  User();
		u.setUsername("xiaomi");
		u.setPassword("123456");
		u.setAge(18);
		int result=userService.insert(u);
		System.out.println(result);
		userService.deleteByPrimaryKey(u.getId());
	}
	
	
	public void testInsertUUID(){
	    UUID uuid = UUID.randomUUID();
	    
	}
	
	
	public void testInsertMore(){
	    DecimalFormat df1 = new DecimalFormat("00");
        User u = new User();
        for (int i = 0; i < 50; i++) {
            int dfString = Integer.parseInt(df1.format(i));
            u.setUsername("yehao"+dfString);
            u.setAge((10+dfString));
            u.setPassword("123456"+dfString);
            userService.insert(u);
            System.out.println(df1.format(i)+"----"+(10+dfString));
	        userService.deleteByPrimaryKey(u.getId());
        }
    }
	
	/*public void testInsertBook()
	{
		Book book=new Book();
		book.setName("西游记1");
		book.setPrice(new BigDecimal(15265));
		try {
			bookService.insert(book);
		}catch (Exception e){
			System.out.println(e.getMessage()+"book"+book);
		}

		List<Book> lists=bookService.selectAllBook();
		bookService.deleteByPrimaryKey(book.getId());
		assertNotNull(lists);
		System.out.println(lists.size());
	}*/
	
	
}