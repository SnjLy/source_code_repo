package design.pattern.structuremode.decorator.example_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class Approver extends Decorator{

    public Approver(Document document) {
        super(document);
    }


    /**
     * 文档显示方法
     */
    public void display() {
        super.display();
        System.out.println("增加文件审批功能");
    }

    public void approver(){
        System.out.println("审批文件");
    }
}
