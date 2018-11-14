package design.pattern.structuremode.flyweight.flyweight_example;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_example
 * @Description:  享元模式客户端实例
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class FlyweightClient {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory ;
        AbstractFlyweight black1,black2,black3,white1,white2;

        //享元模式工厂  --单例模式实现
        flyweightFactory = FlyweightFactory.getFactory();
        black1=flyweightFactory.getFlyweight("black");
        black2=flyweightFactory.getFlyweight("black");
        black3=flyweightFactory.getFlyweight("black");

        //返回true
        System.out.println("判断两颗黑子是否相同:" + (black1==black2));

        /*
         * 享元模式是把基本相同的对象用同一个内存存储，实例化一次。   对其中的不同部分，实现外部状态变化
         *
         * 实现棋子相同，但是各个棋子的位置不同
         */
        white1=flyweightFactory.getFlyweight("white");
        white2=flyweightFactory.getFlyweight("white");
        System.out.println("判断两颗白子是否相同:" + (white1==white2));


        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(10,22));

        white1.display(new Coordinates(2,4));
        white2.display(new Coordinates(2,8));
    }
}
