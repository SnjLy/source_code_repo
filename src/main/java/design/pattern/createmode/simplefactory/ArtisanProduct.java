package design.pattern.createmode.simplefactory;

/**
 * Created by yehao on 2018/5/11.
 */
public class ArtisanProduct extends AbstractProduct {
    private String code ;

    public ArtisanProduct() {
        System.out.println("创建ArtisanProduct");
    }

    @Override
    public void productInfo() {
        System.out.println("初始化ArtisanProduct");
        this.setName("ArtisanProduct");
        this.code = "artisan";
        this.setProductDes("artisan");
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
