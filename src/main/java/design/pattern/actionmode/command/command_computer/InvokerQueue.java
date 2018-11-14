package design.pattern.actionmode.command.command_computer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: design.pattern.actionmode.command.command_computer
 * @Description:  命令队列的实现方法有多种形式，其中最常用、灵活性最好的一种方式是增加一个 Queue类，
 *                  由该类来负责存储多个命令对象，而不同的命令对象可以对应不同的请求 接收者
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public class InvokerQueue {

    private ArrayList<AbstractComputer> computers = new ArrayList<>();

    public void add(AbstractComputer command) {
        computers.add(command);
    }
    public void remove(AbstractComputer command) {
        computers.remove(command);
    }

    /**
     * 循环调用每一个命令对象的execute()方法
     */
    public void execute(int val) {
        for (AbstractComputer command : computers) {
            val = command.execute(val);
        }
    }
}
