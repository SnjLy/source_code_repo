package design.pattern.structuremode.bridge.common_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.common_bridge
 * @Description:  桥接模式：抽象部分的，定义一系列抽象方法有子类实现， 同时依赖 Implementor ，通过组合方式替继承功能
 * @function: Created by yehao on 2018/6/8.
 * @Author : LiuYong
 */
public abstract class Abstraction {

    protected Implementor implementor;  //组合实现部分


    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public Implementor getImplementor() {
        return implementor;
    }

    public abstract void operationMethod();

}
