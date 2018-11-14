package design.pattern.structuremode.decorator.example_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public abstract class Decorator implements Document {

    private  Document document;

    public Decorator(Document document) {
        this.document = document;
    }

    /**
     * 文档显示方法
     */
    @Override
    public void display() {
        this.document.display();
    }
}
