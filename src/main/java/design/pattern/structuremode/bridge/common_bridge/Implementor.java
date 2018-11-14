package design.pattern.structuremode.bridge.common_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.common_bridge
 * @Description: <p>桥接模式: 实现部分，有一些列子类实现接口，实现具体的功能</p>
 * @function: <p>申明一个独立变化的维度，由子类实现接口</p>
 * Created by yehao on 2018/6/8.
 * @Author : LiuYong
 */
public interface Implementor {

    public void operationImpl();
}
