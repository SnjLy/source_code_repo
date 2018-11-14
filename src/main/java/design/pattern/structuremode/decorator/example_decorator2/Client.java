package design.pattern.structuremode.decorator.example_decorator2;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator2
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class Client {

    public static void main(String[] args) {
        Encrypt en1, en2, en3;
        String str = "hello world";
        en1 = new ConcreteShiftEncrypt();
        str = en1.encrypt(str);
        en2 = new ConcreteDecorator(new ConcreteBackwardEncrypt());
        str = en2.encrypt(str);
        en3 = new ConcreteDecorator(new ConcreteModuleEncrypt());
        str = en3.encrypt(str);

        System.out.println(str);
    }
}
