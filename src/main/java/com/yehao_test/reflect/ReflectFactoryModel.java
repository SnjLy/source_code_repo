package com.yehao_test.reflect;
/**
 * 将反射用于工厂模式,添加任意多个子类的时候，工厂类就不需要修改。
 * @author yehao
 *
 */

interface fruit{
    public abstract void eat();
}
 
class Apple implements fruit{
    public void eat(){
        System.out.println("Apple");
    }
}
 
class Orange implements fruit{
    public void eat(){
        System.out.println("Orange");
    }
}
class Banana implements fruit{
    public void eat() {
        System.out.println("eat factory "+this.getClass().getName());
    }
    
}
 
class Factory{
    public static fruit getInstance(String ClassName){
        fruit f=null;
        try{
            f=(fruit)Class.forName(ClassName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
public class ReflectFactoryModel{
    public static void main(String[] a){
        fruit f=Factory.getInstance("com.yehao.reflect.Apple");
        if(f!=null){
            f.eat();
        }
        f = Factory.getInstance("com.yehao.reflect.Banana");
        if(f!=null){
            f.eat();
        }
    }
}