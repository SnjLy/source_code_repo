package design.pattern.actionmode.responsibility.responsibility_example;

/**
 * @Package: design.pattern.actionmode.responsibility.responsibility_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/11.
 */
public class Client {

    public static void main(String[] args) {


        AbstractApprover zhwj, yg, gj, meeting;
        zhwj = new Director("张无忌");
        yg = new VicePresident("杨过");
        gj = new President("郭靖");
        meeting = new Congress("华山论剑");
        //创建职责链
        zhwj.setNextApprover(yg);
        yg.setNextApprover(gj);
        gj.setNextApprover(meeting);

        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        zhwj.processRequest(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买《葵花宝典》");
        zhwj.processRequest(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000, 10003, "购买《易筋经》");
        zhwj.processRequest(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000, 10004, "购买九阴真经和乾坤大罗移");
        zhwj.processRequest(pr4);

    }
}
