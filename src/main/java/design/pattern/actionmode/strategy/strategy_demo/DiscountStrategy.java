package design.pattern.actionmode.strategy.strategy_demo;

/**
 * @Package: design.pattern.actionmode.strategy.strategy_demo
 * @Description:
 * @function:     抽象策略类
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public interface DiscountStrategy {

    /**
     * 声明抽象策略方法，由子类实现具体策略实现打折
     */
    public double discount(double price);
}


/**
 * 具体策略实现
 */
class StudentDiscount implements DiscountStrategy{

    /**
     * 声明抽象策略方法，由子类实现具体策略实现打折
     *
     * @param price
     */
    @Override
    public double discount(double price) {
        System.out.println("学生票打7折：");
        return price*0.7;
    }
}


/**
 * 具体策略实现
 */
class VIPDiscount implements DiscountStrategy{

    /**
     * 声明抽象策略方法，由子类实现具体策略实现打折
     *
     * @param price
     */
    @Override
    public double discount(double price) {
        System.out.println("VIP6折：");
        System.out.println("VIP增加10积分");
        return price*0.6;
    }
}

