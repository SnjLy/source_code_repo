package design.pattern.createmode.abstractfactory;

/**
 * 抽象工厂模式，对增加产品族符合开闭原则, 对增加产品等级不符合开闭原则，（开闭原则的倾斜）
 * Created by yehao on 2018/5/14.
 */
public interface AdditionalControllerFactory{
    AdditionalMac initAdditionalMac();
}
