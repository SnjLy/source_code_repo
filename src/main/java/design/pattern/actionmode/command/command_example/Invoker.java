package design.pattern.actionmode.command.command_example;

/**
 * @Package: design.pattern.actionmode.command.command_example
 * @Description:  调用者即请求发送者，它通过命令对象来执行请求。一个调用者并不 需要在设计时确定其接收者，
 *                  因此它只与抽象命令类之间存在关联关系。在程序运行时可以 将一个具体命令对象注入其中，
 *                  再调用具体命令对象的execute()方法，从而实现间接调用请求 接收者的相关操作。
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public class Invoker {

    private AbstractCommand command;

    /**
     * 构造注入
     * @param command
     */
    public Invoker(AbstractCommand command) {
        this.command = command;
    }

    /**
     * set设值注入
     * @param command
     */
    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    /**
     * 请求发送者的调用方法
     */
    public void call(){
        System.out.println(this.getClass().getSimpleName() + " 发送请求");
        command.execute();
    }
}
