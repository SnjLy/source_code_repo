package design.pattern.structuremode.bridge.common_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.common_bridge
 * @Description:
 * @function: Created by yehao on 2018/6/8.
 * @Author : LiuYong
 */
public class Client {

    public static void main(String[] args) {
        Abstraction abstraction = new FindAbstraction(); //实际运用改成从配置获取
        //Implementor implementor = new RedImplementor();//实际运用改成从配置获取
        Implementor implementor = new BlueImplementor();

        abstraction.setImplementor(implementor);
        abstraction.operationMethod();
    }
}
