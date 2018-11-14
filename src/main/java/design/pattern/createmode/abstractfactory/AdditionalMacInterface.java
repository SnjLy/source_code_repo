package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class AdditionalMacInterface implements AdditionalMac {

    @Override
    public void operation() {
        System.out.println("使用 additional mac interface 界面控制");
    }
}
