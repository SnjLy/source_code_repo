package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class ControllerInterfaceFactory implements ControllerFactory {

    @Override
    public Symbian initSymbian() {
        System.out.println("init symbian interface");
        return new SymbianInterface();
    }

    @Override
    public Android initAndroid() {
        System.out.println("init android interface");
        return new AndroidInterface();
    }

    @Override
    public Windows initWindows() {
        System.out.println("init windows interface");
        return new WindowsInterface();
    }
}
