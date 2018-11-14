package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class WindowsOperation implements Windows{

    @Override
    public void operation() {
        System.out.println("使用windows operation 操作控制");
    }
}
