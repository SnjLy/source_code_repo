package design.pattern.createmode.factorymethod;

/**
 * Created by yehao on 2018/5/14.
 */
public class JpgImage extends  AbstractImage {

    @Override
    public void read() {
        setType("JPG");
    }
}
