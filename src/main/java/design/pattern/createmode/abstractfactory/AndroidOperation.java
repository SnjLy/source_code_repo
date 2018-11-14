package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class AndroidOperation implements Android {

    @Override
    public void operation() {
        System.out.println("使用android operation 操作控制");
    }
}
