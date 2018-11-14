package design.pattern.structuremode.bridge.common_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.common_bridge
 * @Description:  具体实现Implementor的方法，实现某一维度的功能
 * @function: Created by yehao on 2018/6/8.
 * @Author : LiuYong
 */
public class RedImplementor implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("我实现红色的功能");
    }
}
