package design.pattern.createmode.simplefactory;

/**
 * Created by yehao on 2018/5/11.
 */
public class DefaultProduct extends AbstractProduct {
    private String code ;


    public DefaultProduct() {
        System.out.println("创建DefaultProduct");
    }

    @Override
    public void productInfo() {
        System.out.println("初始化DefaultProduct");
        this.setName("DefaultProduct");
        this.code = "default";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
