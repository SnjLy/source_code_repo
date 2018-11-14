package design.pattern.structuremode.adapter.common_adapter;

/**
 * 适配着类，具有特殊方法， 需要调用，包含用户需要的具体方法
 *
 * Created by yehao on 2018/6/7.
 */
public class Adaptee {

    public String specialMethod(){
        System.out.println("调用别人封装的具体方法");
        return this.getClass().getName();
    }
}
