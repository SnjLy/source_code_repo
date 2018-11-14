package design.pattern.actionmode.mediator.mediator_demo;

import java.util.ArrayList;

/**
 * @Package: design.pattern.actionmode.mediator.mediator_demo
 * @Description:    抽象中介者类 ,在抽象中介者中可以定义一个同事类的集合，用于存储同事对象并提供注册方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public abstract class Mediator {


    /**
     * 用于存储同事对象
     */
    protected ArrayList<Colleague> colleagues;

    /**
     *  注册方法，用于增加同事对象
     */
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    /**
     * 声明抽象的业务方法
     */
    public abstract void operation();

}

/**
 * 具体中介者类中将调用同事类的方法，调用时可以增加一些自己的业务代码对调用进行控制。
 */
class ConcreteMediator extends  Mediator{

    /**
     * 声明抽象的业务方法
     */
    @Override
    public void operation() {
        //通过中介者调用同事方法
        ((Colleague)(this.colleagues.get(0))).method1();
    }
}