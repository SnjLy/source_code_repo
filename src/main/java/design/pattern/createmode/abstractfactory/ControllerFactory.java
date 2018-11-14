package design.pattern.createmode.abstractfactory;

/**
 * 抽象工厂， 创建一列产品族
 * Created by yehao on 2018/5/14.
 */
public interface ControllerFactory {
    Symbian initSymbian();

    Android initAndroid();

    Windows initWindows();
}
