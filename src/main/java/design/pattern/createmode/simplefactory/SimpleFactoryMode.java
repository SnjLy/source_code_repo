package design.pattern.createmode.simplefactory;

/**
 * 简单工厂模式
 *  1. 抽象产品类：abstractProduct
 *  2. 具体实现产品类：artisanProduct / customerProduct / defaultProduct
 *  3. 静态工厂类： simpleFactoryMode
 *
 * Created by yehao on 2018/5/11.
 */
public class SimpleFactoryMode {

    public static AbstractProduct createProduct(String type){
        AbstractProduct product = null;
        if("artisan".equals(type)){
            product = new ArtisanProduct();
        }else if ("customer".equals(type)){
            product = new CustomerProduct();
        }else {
            product = new DefaultProduct();
        }
        return product;
    }
}
