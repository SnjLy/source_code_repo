package design.pattern.actionmode.command.command_computer;

/**
 * @Package: design.pattern.actionmode.command.command_computer
 * @Description: 请求接受者抽象类，声明接受者实现方法，由具体的子类实现接受者业务逻辑
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public abstract class AbstractHandler {
    protected int result = 0;

    /**
     * 由子类实现接收者处理逻辑
     *
     * @param value 接收者处理的参数
     * @return 返回接收者处理之后的结果
     */
    public abstract int operate(int value);

    /**
     * 由子类实现接收者处理逻辑
     *
     * @param value 接收者处理的参数
     * @return 返回接收者处理之后的结果
     */
    public abstract int undo(int value);

}


class AddHandler extends AbstractHandler {


    public AddHandler() {
        result = 0;
    }

    /**
     * 由子类实现接收者处理逻辑
     *
     * @param value 接收者处理的参数
     * @return 返回接收者处理之后的结果
     */
    @Override
    public int operate(int value) {
        this.result += value;
        System.out.println(this.getClass().getSimpleName() + "进行add操作:" + value + "  result=" + this.result);
        return this.result;
    }

    /**
     * 由子类实现接收者处理逻辑
     *
     * @param value 接收者处理的参数
     * @return 返回接收者处理之后的结果
     */
    @Override
    public int undo(int value) {
        this.result -= value;
        System.out.println(this.getClass().getSimpleName() + "进行undo操作:" + value + "  result=" + this.result);
        return result;
    }
}


class MultipleHandler extends AbstractHandler {

    public MultipleHandler() {
        result=1;
    }

    /**
     * 由子类实现接收者处理逻辑
     *
     * @param value 接收者处理的参数
     * @return 返回接收者处理之后的结果
     */
    @Override
    public int operate(int value) {
        this.result = result * value;
        System.out.println(this.getClass().getSimpleName() + "进行multi操作:" + value + "  result=" + this.result);
        return this.result;
    }

    /**
     * 由子类实现接收者处理逻辑
     *
     * @param value 接收者处理的参数
     * @return 返回接收者处理之后的结果
     */
    @Override
    public int undo(int value) {
        this.result = result / value;
        System.out.println(this.getClass().getSimpleName() + "进行divide操作:" + value + "  result=" + this.result);
        return result;
    }
}

