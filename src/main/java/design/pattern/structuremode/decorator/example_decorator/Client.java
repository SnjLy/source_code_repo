package design.pattern.structuremode.decorator.example_decorator;

/**
 * @Package: design.pattern.structuremode.decorator.example_decorator
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/19.
 */
public class Client {

    public static void main(String[] args) {
        Document doc, app, del;
        doc = new PurchaseRequest();
        // 透明装饰类
        app = new Approver(doc);  //装饰类
        del = new Deleterr(app);   //二次装饰

        /* 非透明装饰类
         * Approver app = new Approver(doc);  //装饰类
         * Deleterr del = new Deleterr(app);
         */

        doc.display();

        app.display();
        del.display();

        // 透明装饰类 不能调用装饰器类自定义的新方法， 以下app.approver() 和 del.delete() 不能调用
        //app.approver();
        //del.delete();
    }
}
