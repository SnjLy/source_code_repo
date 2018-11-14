package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class AdditionalMacOperation implements AdditionalMac {

    @Override
    public void operation() {
        System.out.println("使用 additional mac operation 操作控制");
    }
}
