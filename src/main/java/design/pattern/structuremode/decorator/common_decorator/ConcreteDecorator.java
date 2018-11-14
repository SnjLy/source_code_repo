package design.pattern.structuremode.decorator.common_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.common_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }


    /**
     * *组件操作功能
     */
    @Override
    public void operation() {
        this.addBehavior();
        super.operation();
    }

    /**
     * *组件展示功能
     */
    @Override
    public void display() {
        this.addBehavior();
        super.display();
        this.addBehaviorAfter();
    }


    public void addBehavior(){
        // 新增业务方法，对组件方法进行装饰
        System.out.println(this.getClass().getSimpleName() + " add method to deal Behavior");
    }

    public void addBehaviorAfter(){
        // 新增业务方法，对组件方法进行装饰
        System.out.println(this.getClass().getSimpleName() + " add method to deal BehaviorAfter");
    }
}
