package com.PattenSingle;

/**
 * 懒汉模式双重检索 与静态内部类 推荐使用
 * Created by admin on 2017/2/23.
 */
public class PattenSingle {

    //**********************************************************************************
    //懒汉模式 双重检索
    private static PattenSingle instance;

    private PattenSingle(){};

    public static PattenSingle getInstance(){
        if (instance == null){
            synchronized (PattenSingle.class) {
                if (instance ==null) {
                    instance = new PattenSingle();
                }
            }
        }
        return instance;
    }
    //*************************************************************************************
    //静态内部类
    static class InnerClass{
       private static final PattenSingle instance1 = new PattenSingle();
    }

    public static PattenSingle getInstance1() {
       return InnerClass.instance1;
    }

}
