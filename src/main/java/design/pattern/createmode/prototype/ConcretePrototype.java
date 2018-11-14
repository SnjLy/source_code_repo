package design.pattern.createmode.prototype;

import org.springframework.util.Assert;

import java.util.Objects;

/**
 * 浅克隆，通过实现clone()方法
 * 深克隆，通过序列化serialization, 将对象输入到流中，然后在从流读出
 * Created by yehao on 2018/5/17.
 */
public class ConcretePrototype implements Cloneable {
    private String attr;
    private  String name;
    private  String date;
    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(this.getClass() + "not support cloneable" + e);
        }
        return  object;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype concret1 = new ConcretePrototype();
        concret1.setAttr("concretPrototype1");
        concret1.setDate("第12周");
        concret1.setName("张无忌");

        ConcretePrototype concret2 = (ConcretePrototype) concret1.clone();
        concret2.setDate("第13周");
        Assert.isTrue(concret1.getAttr().equals(concret2.getAttr()));
        System.out.println("mode1.getAttr() == mode2.getAttr() :" + concret1.getAttr().equals(concret2.getAttr()));
        System.out.println(concret1 == concret2);
        System.out.println(Objects.equals(concret1.getDate(), concret2.getDate()));
        System.out.println(Objects.equals(concret1.getName(), concret2.getName()));
        Assert.isTrue(concret1 != concret2);
        
    }
}
