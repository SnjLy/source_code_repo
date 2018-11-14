package design.pattern.actionmode.command.command_computer;

/**
 * @Package: design.pattern.actionmode.command.command_computer
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public class ComputerClient {

    public static void main(String[] args) {
        AbstractHandler handler = new AddHandler();
        AbstractComputer computer = new ConcreteComputer(handler);
        InvokerForm invokerForm = new InvokerForm(computer);
        invokerForm.compute(10);
        invokerForm.undo();

        //命令队列
        System.out.println("命令队列");
        InvokerQueue queue = new InvokerQueue();
        queue.add(new ConcreteComputer(new AddHandler()));
        queue.add(new ConcreteComputer(new MultipleHandler()));
        queue.execute(20);

    }
}
