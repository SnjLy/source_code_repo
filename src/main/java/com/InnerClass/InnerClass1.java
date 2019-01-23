package com.InnerClass;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yehao on 2017/2/22.
 */
public class InnerClass1 {
    private static final Integer age =20 ;
    private String name ;

    public static Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void innerClass(String s){
        System.out.println("这是外部类的普通方法:"+s);
    }

    public static void method(String s){
        System.out.println("这是外部类的静态方法:"+s);
    }

    static class Inner{
        static int age = 30;
        public void show(){
            System.out.println("这是静态内部类的方法:"+ age);
            method("静态内部类调用外部类静态方法");
        }
    }

    class Inner2{
        int age = 10;
        public void show1(){
            name = "hello world"+ age;
            setName(name+" nihao");
            System.out.println("这是第二个内部类的方法"+name);
            innerClass("普通内部类调用外部类普通方法");
            method("普通内部类调用外部静态方法");
        }
    }

    public static void main(String[] args) {
        InnerClass1 class1 = new InnerClass1();
        class1.innerClass("外部类调用普通方法");
        method("外部类调用静态方法");
        new Inner().show();
    }

}
