package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class WindowsInterface implements Windows{

    @Override
    public void operation() {
        System.out.println("使用windows interface 操作控制");
    }
}
