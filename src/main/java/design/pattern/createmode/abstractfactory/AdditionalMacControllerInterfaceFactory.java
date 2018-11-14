package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class AdditionalMacControllerInterfaceFactory extends  ControllerInterfaceFactory implements AdditionalControllerFactory{

    @Override
    public AdditionalMac initAdditionalMac() {
        System.out.println("init additional mac interface");
        return new AdditionalMacInterface();
    }
}
