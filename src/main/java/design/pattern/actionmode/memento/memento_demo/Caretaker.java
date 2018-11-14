package design.pattern.actionmode.memento.memento_demo;

/**
 * @Package: design.pattern.actionmode.memento.memento_demo
 * @Description:   操作者（负责人），保存备忘录
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
