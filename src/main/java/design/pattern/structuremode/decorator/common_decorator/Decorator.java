package design.pattern.structuremode.decorator.common_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.common_decorator
 * @Description: 定义装饰器类，依赖抽象组件类，对组件方法进行装饰
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public abstract class Decorator implements Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    /**
     * *组件操作功能
     */
    @Override
    public void operation() {
        this.component.operation();
    }

    /**
     * *组件展示功能
     */
    @Override
    public void display() {
        this.component.display();
    }
}
