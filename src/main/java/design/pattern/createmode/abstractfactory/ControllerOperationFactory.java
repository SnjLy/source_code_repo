package design.pattern.createmode.abstractfactory;

/**
 * 具体工厂方法，创建某一等级的产品族产品
 * Created by yehao on 2018/5/14.
 */
public class ControllerOperationFactory implements ControllerFactory {

    @Override
    public Symbian initSymbian() {
        System.out.println("init symbian operation");
        return new SymbianOperation();
    }

    @Override
    public Android initAndroid() {
        System.out.println("init android operation");
        return new AndroidOperation();
    }

    @Override
    public Windows initWindows() {
        System.out.println("init windows operation");
        return new WindowsOperation();
    }


}
