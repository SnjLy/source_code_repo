package design.pattern.structuremode.flyweight.flyweight_example;

import java.util.Hashtable;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_example
 * @Description:  享元工厂类，单例模式实现，简单工厂模式
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class FlyweightFactory {

    /**
     * 单例模式实现享元工厂类
     */
    private static FlyweightFactory factory = new FlyweightFactory();

    /**
     * 简单工厂模式
     * @return
     */
    public static FlyweightFactory getFactory() {
        return factory;
    }

    /**
     *   使用Hashtable来存储享元对象，充当享元池
     */
    private static Hashtable ht;

    private FlyweightFactory() {
        ht = new Hashtable();
        AbstractFlyweight black, white;
        black = new BlackChessman();
        ht.put("black", black);
        white = new WhiteChessman();
        ht.put("white", white);
    }


    public AbstractFlyweight getFlyweight(String color){
        return (AbstractFlyweight) ht.get(color);
    }



}
