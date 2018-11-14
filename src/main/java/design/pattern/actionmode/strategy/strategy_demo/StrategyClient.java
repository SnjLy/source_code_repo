package design.pattern.actionmode.strategy.strategy_demo;

/**
 * @Package: design.pattern.actionmode.strategy.strategy_demo
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public class StrategyClient {

    public static void main(String[] args) {
        Context context;
        context = new Context();
        double originPrice = 60.0d;
        double salePrice = 0.0d;
        context.setPrice(originPrice);
        System.out.println("原价：" + originPrice);

        DiscountStrategy strategy ;
        //通过配置文件配置即可实现开闭原则
        strategy = new VIPDiscount();
        context.setStrategy(strategy);

        salePrice = context.getPrice();
        System.out.println("售价：" + salePrice);
    }
}
