package design.pattern.structuremode.decorator.example_decorator2;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator2
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public abstract class Decorator extends Encrypt{

    private Encrypt encrypt;

    public Decorator(Encrypt encrypt) {
        this.encrypt = encrypt;
    }

    /**
     * 定义抽象加密方法
     *
     * @param str
     */
    @Override
    public String encrypt(String str) {
        return encrypt.encrypt(str);
    }
}
