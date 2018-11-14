package com.yehao_test;

import com.springmvc.model.User;

public class Test_main {

        /**
         * 测试Java参数传递操作与对象传值操作
         * @param x
         * @param y
         */
        public static void swap( int x,  int y) {
            int temp = x;
            x = y;
            y = temp;
            System.out.println("x="+x +"--y="+y);
        }
        
       
        public static User change(User u){
            if(u != null){
               u.setAge(20);
               u.setUsername("change user!");
            }
            System.out.println(u.getUsername()+"***"+u.getAge());
            return u;
        }
        /*
         * 测试字符串连接操作
         */
        public static void testString() {
            String s1 = "Programming";
            String s2 = new String("Programming");
            String s3 = "Program" + "ming";
            System.out.println(s1 == s2);        //false
            System.out.println(s1 == s3);        //true
            System.out.println(s1 == s1.intern());          //true
            System.out.println(s2.intern());     //返回常量池中字符串的引用
        }

        public static void main(String[] args) {
            int a = 5, b = 10;
            swap ( a,  b);// a = 10, b = 5;
            
            System.out.println("a="+a +"--b="+b);
            // a = 5, b = 10;
            
            User user = new User();
            user.setAge(18);
            user.setUsername("yehao");
            System.out.println(user.getUsername()+"--"+user.getAge());
            User u = change(user);
            System.out.println(user.getUsername()+"--"+user.getAge());
            System.out.println(u.getUsername()+"***"+u.getAge());
            
            testString();
        }

}
