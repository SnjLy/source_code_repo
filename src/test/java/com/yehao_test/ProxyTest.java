package com.yehao_test;

import org.junit.Test;

import com.yehao_test.proxy.MyInvocationHandler;
import com.yehao_test.proxy.UserService;
import com.yehao_test.proxy.UserServiceImpl;

/** 
 *动态代理测试类 
 * 
 */  
public class ProxyTest {  
  
    @Test
    public void testProxy() throws Throwable {  
        // 实例化目标对象  
        UserService userService = new UserServiceImpl();  
          
        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);  
          
        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();  
          
        // 调用代理对象的方法  
        proxy.add();  
        
    }  
}