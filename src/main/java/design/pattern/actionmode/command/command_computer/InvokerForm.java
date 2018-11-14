package design.pattern.actionmode.command.command_computer;

/**
 * @Package: design.pattern.actionmode.command.command_computer
 * @Description:  请求发送者
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public class InvokerForm {
    private AbstractComputer computer;

    public InvokerForm(AbstractComputer computer) {
        this.computer = computer;
    }

    /**
     * 调用命令对象的execute()方法执行运算
     * @param value
     */
    public void compute(int value) {
        int i = computer.execute(value);
        System.out.println("执行运算，运算结果为:" + i);
    }

    /**
     *  调用命令对象的undo()方法执行撤销
     */
    public void undo() {
        int i = computer.undo();
        System.out.println("执行撤销，运算结果为:" + i);
    }

}
