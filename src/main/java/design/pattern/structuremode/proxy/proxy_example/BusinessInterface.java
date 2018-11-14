package design.pattern.structuremode.proxy.proxy_example;

/**
 * @Package: design.pattern.structuremode.proxy.proxy_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/11.
 */
public abstract class BusinessInterface {

    /**
     * 业务接口，由实现类实现具体业务逻辑
     * @return
     */
    public abstract  String operate();

    public void display(){
        System.out.println("调用BusinessInterface的display()");
    }
}

class RealBusinessImpl extends BusinessInterface {
    /**
     * 业务接口，由实现类实现具体业务逻辑
     *
     * @return
     */
    @Override
    public String operate() {
        System.out.println(this.getClass() + "由我来具体实现业务逻辑");
        //do something
        return this.getClass().getName();
    }
}
