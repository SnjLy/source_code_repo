package design.pattern.createmode.simplefactory;

/**
 * 产品抽象类。 具体由子类实现，负责创建具体的产品
 * Created by yehao on 2018/5/11.
 */
public abstract class AbstractProduct implements InterfaceProduct{

    public String name;

    public abstract void productInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setProductDes(String desc){
        System.out.println(this.getClass().getName() + "调用etProductDes("+ desc + ")" );
        this.setName(this.getClass().getName());
    }


}
