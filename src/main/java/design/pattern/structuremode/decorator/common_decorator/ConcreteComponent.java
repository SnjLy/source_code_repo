package design.pattern.structuremode.decorator.common_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.common_decorator
 * @Description:  具体组件类，实现抽象组件类接口的组件方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class ConcreteComponent implements Component{

    /**
     * *组件操作功能
     */
    @Override
    public void operation() {
        System.out.println(this.getClass().getSimpleName() + " operation doing");
    }

    /**
     * *组件展示功能
     */
    @Override
    public void display() {
        System.out.println(this.getClass().getSimpleName() + " display doing");
    }
}
