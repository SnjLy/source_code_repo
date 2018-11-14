package design.pattern.structuremode.adapter.common_adapter;

/**
 * 目标抽象类
 *
 * 可以是具体类也可是抽象类
 * Created by yehao on 2018/6/7.
 */
public abstract class Target {

    public void request(){
        System.out.println(this.getClass().getName() + " request doing");
    }

    public abstract String request(int type);

}
