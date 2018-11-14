package design.pattern.structuremode.decorator.common_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.common_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();  //实际使用中通过配置文件配置
        Decorator decorator = new ConcreteDecorator(component);

        decorator.operation();

        decorator.display();
    }
}
