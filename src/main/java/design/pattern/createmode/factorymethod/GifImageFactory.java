package design.pattern.createmode.factorymethod;

/**
 * Created by yehao on 2018/5/14.
 */
public class GifImageFactory implements ImageFactory {

    /**
     * 工厂方法不能是static修饰的。
     * 1. 工厂类可以是接口，由子类实现工厂方法，那么工厂方法不能是static 的。
     * 2. 工厂类可以是抽象类，由子类实现工厂方法，那么工厂方法应该是abstract方法，那么工厂方法不能是static 的。
     *
     * @return
     */
    @Override
    public AbstractImage readImage() {
        System.out.println("start : read gif image begin");
        AbstractImage image = new GifImage();
        image.read();
        System.out.println("end : read gif file end, type:" + image.getType());
        return image ;
    }
}
