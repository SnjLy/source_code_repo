package design.pattern.structuremode.bridge.common_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.common_bridge
 * @Description:
 * @function: Created by yehao on 2018/6/8.
 * @Author : LiuYong
 */
public class FindAbstraction extends Abstraction {

    @Override
    public void operationMethod() {
        System.out.println("Find beginning....");
        implementor.operationImpl();
        System.out.println("Find end");
    }
}
