package design.pattern.actionmode.command.command_computer;

/**
 * @Package: design.pattern.actionmode.command.command_computer
 * @Description: 抽象命令类，提供抽象计算方法，由实现类实现具体的计算逻辑
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public abstract class AbstractComputer {

    /**
     * 声明命令执行方法，有实现类实现具体逻辑
     * @param value  需要操作的数
     * @return  操作之后的结果
     */
    public abstract int execute(int value);

    /**
     * 声明撤销方法，由子类实现撤销逻辑
     * @return
     */
    public abstract int undo();
}


class ConcreteComputer extends AbstractComputer{

    private AbstractHandler handler;
    /**
     * 若要实现多次撤销需要记录多次操作的数值
     */
    private int value = 0;

    public ConcreteComputer(AbstractHandler handler) {
        this.handler = handler;
    }

    public void setHandler(AbstractHandler handler) {
        this.handler = handler;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 声明命令执行方法，有实现类实现具体逻辑
     *
     * @param value 需要操作的数
     * @return 操作之后的结果
     */
    @Override
    public int execute(int value) {
        this.value = value;
        System.out.println(this.getClass().getSimpleName() + "我收到请求，转发给具体的接受者处理");
        return handler.operate(value);
    }

    /**
     * 声明撤销方法，由子类实现撤销逻辑
     *
     * @return
     */
    @Override
    public int undo() {
        System.out.println(this.getClass().getSimpleName() + "我收到请求，转发给具体的接受者处理");
        return value==0 ? value : handler.undo(value);
    }
}