package design.pattern.actionmode.strategy.strategy_demo;

/**
 * @Package: design.pattern.actionmode.strategy.strategy_demo
 * @Description:
 * @function:     环境类（环境上下文）
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public class Context {
    private double price;
    private DiscountStrategy strategy;

    /**
     * 调用策略方法
     * @return
     */
    public double getPrice() {
        return strategy.discount(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DiscountStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
}
