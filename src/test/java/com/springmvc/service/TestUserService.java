package com.springmvc.service;

import com.springmvc.model.Book;
import com.springmvc.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
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
		UUID uuid = UUID.randomUUID();
		User u=userService.selectByPrimaryKey(Integer.valueOf(uuid.toString()));
		Assert.assertTrue(null == u);
		Mockito.when(userService.selectByPrimaryKey(-1)).thenReturn(null);
		u = userService.selectByPrimaryKey(-1);
		Mockito.verify(userService.selectByPrimaryKey(-1), Mockito.times(1));
		Assert.assertNull(u);
	}


	@Rollback
	public void testInsert(){
		User u=new  User();
		u.setUsername("xiaomi");
		u.setPassword("123456");
		u.setAge(18);
		int result=userService.insert(u);
		Assert.assertTrue("插入成功", 1==result);
		Assert.assertNotNull(u.getId());
		//System.out.println(result);
		int i = userService.deleteByPrimaryKey(u.getId());
		Assert.assertTrue(1==i);

		u = userService.selectByPrimaryKey(u.getId());
		Assert.assertTrue(null ==u);

	}
	

	
	@Rollback
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
	
	public void testInsertBook()
	{
		Book book=new Book();
		book.setName("西游记1");
		book.setPrice(new BigDecimal(15265));
		try {
			bookService.insert(book);
		}catch (Exception e){
			Assert.fail("构建书本信息插入数据库错误");
		}

		List<Book> lists=bookService.selectAllBook();
		assertNotNull(lists);
		bookService.deleteByPrimaryKey(book.getId());
		System.out.println(lists.size());
	}
	
	
}