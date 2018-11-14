package design.pattern.structuremode.decorator.example_decorator;

import javax.print.Doc;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class PurchaseRequest implements Document{

    /**
     * 文档显示方法
     */
    @Override
    public void display() {
        System.out.println(this.getClass().getSimpleName() + " display");
    }
}
