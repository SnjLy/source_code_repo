package design.pattern.actionmode.mediator.mediator_demo;

/**
 * @Package: design.pattern.actionmode.mediator.mediator_demo
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public abstract class Colleague {

    /**
     * 维持一个抽象中介者的引用
     */
    protected Mediator mediator;


    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 声明自身方法，处理自己的行为
     */
    public abstract void method1();

    /**
     * 定义依赖方法，与中介者通信
     */
    public void method2(){
        mediator.operation();
        System.out.println(this.getClass().getSimpleName() + "调用依赖方法，与中介者通信");
    }
}


/**
 * 在具体同事类ConcreteColleague中实现了在抽象同事类中声明的方法，其中方法method1()是同
 * 事类的自身方法(Self-Method)，用于处理自己的行为，而方法method2()是依赖方法(Depend- Method)，
 * 用于调用在中介者中定义的方法，依赖中介者来完成相应的行为，例如调用另一个 同事类的相关方法。
 */
class ConcreteColleague extends Colleague{

    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    /**
     * 声明自身方法，处理自己的行为
     */
    @Override
    public void method1() {
        System.out.println(this.getClass().getSimpleName() + "实现自己的自身方法，处理自己的行为");
    }
}