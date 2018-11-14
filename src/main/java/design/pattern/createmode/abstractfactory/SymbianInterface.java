package design.pattern.createmode.abstractfactory;

/**
 * Created by yehao on 2018/5/14.
 */
public class SymbianInterface implements Symbian{

    @Override
    public void operation() {
        System.out.println("使用Symbian interface 操作控制");
    }
}
