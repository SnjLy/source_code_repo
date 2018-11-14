package design.pattern.actionmode.memento.memento_demo;

/**
 * @Package: design.pattern.actionmode.memento.memento_demo
 * @Description:   一般将需要保存内部状态的类设计为原发器, 原发器类Originator，
 *                  在真实业务中，原发器类是一 个具体的业务类，它包含一些用于存储成员数据的属性
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public class Originator {

    private String state;

    /**
     * 创建一个备忘录
     * @return  基于此原发器创建的备忘录
     */
    public Memento  createMemento(){
        return new Memento(this);
    }

    public void restoreMemento(Memento m){
        state = m.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}

