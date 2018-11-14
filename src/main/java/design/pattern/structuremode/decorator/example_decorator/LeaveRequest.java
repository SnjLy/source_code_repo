package design.pattern.structuremode.decorator.example_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class LeaveRequest implements Document{

    /**
     * 文档显示方法
     */
    @Override
    public void display() {
        System.out.println(this.getClass().getSimpleName() + " display");
    }
}
