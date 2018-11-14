package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class AndroidInterface implements Android {

    @Override
    public void operation() {
        System.out.println("使用android interface 操作控制");
    }
}
