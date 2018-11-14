package design.pattern.structuremode.decorator.example_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class Deleterr extends Decorator{

    public Deleterr(Document document) {
        super(document);
    }


    /**
     * 文档显示方法
     */
    public void display() {
        super.display();
        System.out.println("增加删除文件功能");
    }

    public void delete(){
        System.out.println("删除文件");
    }
}
