package design.pattern.structuremode.decorator.example_decorator2;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator2
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Encrypt encrypt) {
        super(encrypt);
    }


    public String encrypt(String str) {
        return super.encrypt(str);
    }

}
