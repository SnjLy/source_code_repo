package design.pattern.structuremode.decorator.example_decorator2;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator2
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class ConcreteShiftEncrypt extends Encrypt{

    /**
     * 定义抽象加密方法
     *
     * @param str
     */
    @Override
    public String encrypt(String str) {
        System.out.println("字符串移位加密");
        return str + " shift ";
    }
}
