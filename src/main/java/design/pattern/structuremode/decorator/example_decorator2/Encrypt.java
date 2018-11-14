package design.pattern.structuremode.decorator.example_decorator2;

/**
 * @Package: design.pattern.structuremode.decorator
 * @Description:  抽象类，定义加密方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public abstract class Encrypt {

    /**
     * 定义抽象加密方法
     */
    public abstract String encrypt(String str);
}

