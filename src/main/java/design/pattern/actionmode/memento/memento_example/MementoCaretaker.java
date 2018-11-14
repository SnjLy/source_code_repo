package design.pattern.actionmode.memento.memento_example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: design.pattern.actionmode.memento.memento_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
class MementoCaretaker {

    /***
     * 只能存储一个状态
     */
    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }
    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }


    /**
     * 定义一个集合来存储多个备忘录，实现多次撤销
     */
    private List<ChessmanMemento> mementos = new ArrayList<>();

    public ChessmanMemento getMemento(int i){
        return mementos.get(i);
    }

    public void addMemento(ChessmanMemento memento){
        mementos.add(memento);
    }
}
