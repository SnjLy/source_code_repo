package design.pattern.actionmode.command.command_example;

/**
 * @Package: design.pattern.actionmode.command.command_example
 * @Description: 请求接收者Receiver类, 一般是具体的实现类，执行请求相关的操作
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public abstract class AbstractReceiver {

    /**
     * 请求接受者，提供具体的请求处理方法，由实现类实现具体的请求处理逻辑
     * @return
     */
    public abstract String action();
}


class ConreteReceiver extends AbstractReceiver{
    /**
     * 请求接受者，提供具体的请求处理方法，由实现类实现具体的请求处理逻辑
     *
     * @return
     */
    @Override
    public String action() {
        System.out.println(this.getClass().getSimpleName() +"我是请求接受者，来处理具体的请求逻辑实现");
        //do receiver action
        return this.getClass().getSimpleName();
    }
}