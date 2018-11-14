package design.pattern.actionmode.command.command_example;

/**
 * @Package: design.pattern.actionmode.command.command_example
 * @Description: (抽象命令类):抽象命令类一般是一个抽象类或接口，在其中声明了用于执行 请求的execute()等方法，
 *                  通过这些方法可以调用请求接收者的相关操作
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public abstract class AbstractCommand {
    /**
     * 抽象命令类的抽象执行方法，由实现类实现具体的命令执行逻辑，调用不同的接受者逻辑处理
     */
    public abstract void execute();
}


class ConcreteCommand extends AbstractCommand{
    private AbstractReceiver receiver;

    public ConcreteCommand(AbstractReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 抽象命令类的抽象执行方法，由实现类实现具体的命令执行逻辑，调用不同的接受者逻辑处理
     */
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName() +"发送请求给我，我来安排接受者来处理这个请求");
        receiver.action();
    }
}