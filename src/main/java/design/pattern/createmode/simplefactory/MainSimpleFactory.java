package design.pattern.createmode.simplefactory;

import com.alibaba.fastjson.JSON;

/**
 * Created by yehao on 2018/5/11.
 */
public class MainSimpleFactory {

    /*
     *  静态方法传参数，调用，需要修改调用参数，不符合开闭原则; main2()使用配置文件配置参数，修改是只需要修改配置文件即可，不需要再修改代码调用的type参数
     *
     */
    public static void main(String[] args) {
        AbstractProduct product = SimpleFactoryMode.createProduct("artisan");
        product.productInfo();
        System.out.println(JSON.toJSONString(product));
        product = SimpleFactoryMode.createProduct("customer");
        product.productInfo();
        System.out.println(JSON.toJSONString(product));
        product = SimpleFactoryMode.createProduct("default");
        product.productInfo();
        System.out.println(JSON.toJSONString(product));

        InterfaceProduct interPro = null;
        interPro = SimpleFactoryMode.createProduct("artisan");
        interPro.setProductDes("");
        System.out.println(JSON.toJSONString(interPro));
        interPro = SimpleFactoryMode.createProduct("default");
        interPro.setProductDes("");
        System.out.println(JSON.toJSONString(interPro));
    }

    public static void main2(String[] args) {

        /*
         * type参数从配置文件读取，避免修改调用传参，符合开闭原则
         * @Value(${type})
         * private String type;
         */
        String type = "XXX";
        AbstractProduct product = SimpleFactoryMode.createProduct(type);
        product.productInfo();
        System.out.println(JSON.toJSONString(product));

    }
}
