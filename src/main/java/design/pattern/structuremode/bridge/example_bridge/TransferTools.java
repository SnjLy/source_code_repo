package design.pattern.structuremode.bridge.example_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.example_bridge
 * @Description:  装换工具抽象类，提供抽象方法，子类具体实现转换
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/8.
 */
public abstract class TransferTools {

    protected DBImplementor implementor;


    public void setImplementor(DBImplementor implementor) {
        this.implementor = implementor;
    }

    public abstract String convertToFile();
}
