package design.pattern.actionmode.observer.observer_demo;

/**
 * @Package: design.pattern.actionmode.observer.observer_demo
 * @Description:  抽象观察者角色一般定义为一个接口，通常只声明一个update()方法，为不同观察者的更新 (响应)行为定义相同的接口，
 * 这个方法在其子类中实现，不同的观察者具有不同的响应方法。抽象观察者Observer典型代码如下所示:
 * @function:   抽象观察者
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public interface Observer {

    /**
     * 声明响应方法，观察者观察到目标状态变化之后调用方法修改状态
     */
    public void update();
}


class ConcreteObserver implements Observer{

    /**
     * 声明响应方法，观察者观察到目标状态变化之后调用方法修改状态
     */
    @Override
    public void update() {
        System.out.println("具体观察者修改状态");
    }
}