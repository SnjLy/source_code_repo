package design.pattern.actionmode.mediator.mediator_example;

/**
 * @Package: design.pattern.actionmode.mediator.mediator_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public class MediatorClient {

    public static void main(String[] args) {
        //定义中介者对象
        ConcreteMediator mediator;
        mediator = new ConcreteMediator();

        //定义具体同事对下那个
        Button button = new Button();
        List list = new List();
        ComboBox comboBox = new ComboBox();
        TextBox textBox = new TextBox();


        //同事对象维持中介者引用
        button.setMediator(mediator);
        list.setMediator(mediator);
        textBox.setMediator(mediator);
        comboBox.setMediator(mediator);

        mediator.button = button;
        mediator.list = list;
        mediator.textBox= textBox;
        mediator.comboBox = comboBox;

        button.changed();
        System.out.println("--------------------------");
        list.changed();
    }
}
