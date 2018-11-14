package design.pattern.actionmode.command.command_example;

/**
 * @Package: design.pattern.actionmode.command.command_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public class CommandClient {

    public static void main(String[] args) {
        /*
         * 此处通过发射或者依赖注入、配置bean的方式动态配置
         */
        AbstractReceiver receiver = new ConreteReceiver();
        AbstractCommand command = new ConcreteCommand(receiver);

        Invoker invoker =new Invoker(command);
        invoker.call();

    }
}
