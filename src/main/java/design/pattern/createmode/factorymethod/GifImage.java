package design.pattern.createmode.factorymethod;

/**
 * Created by yehao on 2018/5/14.
 */
public class GifImage extends  AbstractImage {

    @Override
    public void read() {
        setType("GIF");
    }
}
