package design.pattern.actionmode.mediator.mediator_example;

/**
 * @Package: design.pattern.actionmode.mediator.mediator_example
 * @Description:   抽象中介者，Component充当抽象同事类，Button、List、ComboBox和TextBox充当具体同事类，
 *                 Mediator充当抽象中介者类，ConcreteMediator充当具体中介者类，
 *                 ConcreteMediator维持了对具体同事类的引用
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public abstract class Mediator {

    /**
     * 声明中介者调用抽象方法，封装同事对象之间的交互
     * @param c
     */
    public abstract void componentChanged(Component c);
}

class ConcreteMediator extends Mediator{
    /**
     * 维持对各个具体同事的引用
     */
    public Button button;
    public List list;
    public ComboBox comboBox;
    public TextBox textBox;


    /**
     * 声明中介者调用抽象方法，封装同事对象之间的交互
     *
     * @param c 具体的组件同事
     */
    @Override
    public void componentChanged(Component c) {
        //单击按钮
        if (c == button) {
            System.out.println("------单击按钮操作----");
            list.update();
            comboBox.update();
            textBox.update();
        }
        else if (c == list){
            //从列表选择
            System.out.println("----从列表选择客户名---");
            comboBox.select();
            //触发textBox 的设置
            textBox.setText();
        }else if (c== comboBox){
            System.out.println("----从组合框选择客户----");
            comboBox.select();
            textBox.setText();
        }

    }

}