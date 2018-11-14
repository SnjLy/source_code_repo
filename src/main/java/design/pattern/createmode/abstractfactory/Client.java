package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class Client {


    public static void main(String[] args) {
        ControllerFactory factory = new ControllerOperationFactory();
        Android android = factory.initAndroid();
        android.operation();
        Symbian symbian = factory.initSymbian();
        symbian.operation();
        Windows windows = factory.initWindows();
        windows.operation();

        AdditionalControllerFactory additionalFactory = new AdditionalMacControllerInterfaceFactory();
        AdditionalMac mac =additionalFactory.initAdditionalMac();
        mac.operation();
        /*
         *无法调用到ControllerFactory中的方法，对产品等级无法扩展，不符合开闭原则
         */
        // additionalFactory.initAndroid(); //无法调用

    }
}
