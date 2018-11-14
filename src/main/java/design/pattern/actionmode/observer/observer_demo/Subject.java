package design.pattern.actionmode.observer.observer_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: design.pattern.actionmode.observer.observer_demo
 * @Description:   目标又称为主题，它是指被观察的对象。在目标中定义了一个观察者集 合，一个观察目标可以接受任意数量的观察者来观察，
 *                  它提供一系列方法来增加和删除观察 者对象，同时它定义了通知方法notify()。目标类可以是接口，也可以是抽象类或具体类
 * @function:   观察者目标（又称主题）
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public abstract class Subject {
    /**
     * 定义观察者集合，存储搜索观察者对象
     */
    protected ArrayList<Observer> observers = new ArrayList<>();

    /**
     * 实现注册方法，向目标观察者集合中注入观察者
     * @param observer
     */
    public void register(Observer observer){
        observers.add(observer);
    }

    /**
     * 实现注销方法，用于向目标观察者集合中注销一个观察者对象
     * @param observer
     */
    public void unRegister(Observer observer){
        observers.remove(observer);
    }

    /**
     *  声明抽象通知方法
     */
    public abstract void bussinessNotify();

}

/**
 * 具体目标类。
 */
class ConcreteSubject extends Subject{
    /**
     * 声明抽象通知方法
     * 遍历观察者集合，调用每一个观察者的响应方法
     */
    @Override
    public void bussinessNotify() {
        for (Observer observer : observers){
            observer.update();
        }
    }
}
