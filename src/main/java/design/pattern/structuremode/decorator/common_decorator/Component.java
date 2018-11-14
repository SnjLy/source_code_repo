package design.pattern.structuremode.decorator.common_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.common_decorator
 * @Description:  定义抽象组件类，由子类实现组件具体功能
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public interface Component {

    /**
     * *组件操作功能
     */
    public void operation();

    /**
     * *组件展示功能
     */
    public void display();
}
