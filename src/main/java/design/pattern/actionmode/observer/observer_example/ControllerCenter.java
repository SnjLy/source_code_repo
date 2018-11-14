package design.pattern.actionmode.observer.observer_example;

import java.util.ArrayList;

/**
 * @Package: design.pattern.actionmode.observer.observer_example
 * @Description:   观察者目标类
 * @function:   游戏控制中心
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public abstract class ControllerCenter {
    /**
     * 战队名称
     */
    protected String allyName;

    /**
     * 战队成员： 目标类声明观察者集合存储观察者对象
     */
    protected ArrayList<GameObserver> observers = new ArrayList<>();

    /**
     * 注册方法，观察者对象加入目标观察者集合
     *
     * @param observer
     */
    public void register(GameObserver observer) {
        System.out.println(observer.getName() + "加入" + this.allyName + "成功");
        observers.add(observer);
    }

    /**
     * 注销方法，观察者对象从目标观察者集合中注销
     *
     * @param observer
     */
    public void unRegister(GameObserver observer) {
        boolean res = observers.remove(observer);
        if (res) {
            System.out.println(observer.getName() + "退出" + this.allyName + "成功");
        }
    }

    /**
     * 声明抽象通知方法，控制中心调度， 目标联动观察者处理逻辑
     * @param currentObserver   当前那个观察者出发了变化
     */
    public abstract void notifyObserver(GameObserver currentObserver);

}


class ConcreteControllerCenter extends ControllerCenter{

    public ConcreteControllerCenter(String name) {
        this.allyName = name;
        System.out.println(allyName + "战队组建成功!");
        System.out.println("----------------------------");

    }

    /**
     * 声明抽象通知方法，控制中心调度， 目标联动观察者处理逻辑
     *
     * @param currentObserver 当前那个观察者出发了变化
     */
    @Override
    public void notifyObserver(GameObserver currentObserver) {
        System.out.println(this.allyName + "紧急通知各位，盟友"+ currentObserver.getName() + "正在遭受攻击，请救援！！！");
        for (GameObserver observer : observers){
            if (!observer.getName().equals(currentObserver.getName())){
                observer.help();
            }
        }
        System.out.println(this.allyName + "救援成功");
    }
}