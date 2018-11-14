package design.pattern.createmode.factorymethod;

/**
 * Created by yehao on 2018/5/14.
 */
public class Client {

    /**
     * 通过工厂方法模式，配置文件配置要使用的类名，通过反射生成实例对象，工厂不关心具体的类和类实例实现。
     * @param args
     */
    public static void main(String[] args) {
        String str  = "design.pattern.createmode.factorymethod.GifImageFactory";   //类名通过配置文件获取即可实现符合开闭原则
        ImageFactory factory ;
        AbstractImage image = null;
        try {
            factory = (ImageFactory) Class.forName(str).newInstance();  //通过反射获取类名对应的类对象
            /*
             * 可以在ImageFactory中定义方法，该方法调用readImage(), 实现对工厂方法的隐藏，不用再调用factory.readImage();
             */
            image = factory.readImage();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (null != image) {
            System.out.println("read image file type:" + image.getType());
        }

    }
}
