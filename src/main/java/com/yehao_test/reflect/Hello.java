/**
 *  java反射,利用对象返回一个类实现的接口与接口方法
 * @author yehao
 *
 */
package com.yehao_test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

interface Student{
    public static String name = "Rollen";
    public static int age=20;
    public void sayStudent();
    public void sayHello(String name, int age);
}

class Person implements Student{

    private String sex;
    
    public Person() {
    }

    public Person(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sayStudent() {
       System.out.println("Hello student!!!");
    }

    public void sayHello(String name, int age) {
        System.out.println("Hello "+name+"--"+age);
    }
    
}

public class Hello{
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.yehao.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> intFace[] = demo.getInterfaces();
        for (int i = 0; i < intFace.length; i++) {
            System.out.println(intFace[i].getDeclaredMethods()[0]
                    .getName()+"--"+intFace[i].getName());
            try {
                //通过反射调用实现接口类的实现方法
               demo.getMethod("sayHello", String.class,int.class)
               .invoke(demo.newInstance(),"haimingwei",20);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
    }
}