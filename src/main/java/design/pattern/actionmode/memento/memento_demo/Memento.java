package design.pattern.actionmode.memento.memento_demo;

/**
 * @Package: design.pattern.actionmode.memento.memento_demo
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
/**
 * 备忘录类，默认可见性，包内可见
 * 除了Originator类，不允许其他类来调用备忘录类 Memento的构造函数与相关方法，
 * 如果不考虑封装性，允许其他类调用setState()等方法，将导 致在备忘录中保存的历史状态发生改变
 */
class Memento{
    private String state;

    public Memento(Originator originator) {
        this.state = originator.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
