package com.yehao_test.reflect;

import java.lang.reflect.Method;

public class ReflectForMothod {

    public static void main(String[] args) throws Exception{
       String string = "test reflect get Object's method!";
       Method method = string.getClass().getMethod("toUpperCase");
       Method[] methods = string.getClass().getMethods();
       System.out.println(method.getName()+":"+method.invoke(string));     
       for (int i = 0; i < methods.length; i++) {
        System.out.println(methods[i].getName()+"-return type:"+methods[i].getReturnType()
                +"***"+methods[i].getTypeParameters());
    }

    }

}
