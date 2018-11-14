package design.pattern.createmode.simplefactory;

/**
 * Created by yehao on 2018/5/11.
 */
public class CustomerProduct extends AbstractProduct {
    private String code ;

    public CustomerProduct() {
        System.out.println("创建CustomerProduct");
    }

    @Override
    public void productInfo() {
        System.out.println("初始化CustomerProduct");
        this.setName("CustomerProduct");
        this.code = "customer";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
