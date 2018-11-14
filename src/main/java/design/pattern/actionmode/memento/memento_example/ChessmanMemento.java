package design.pattern.actionmode.memento.memento_example;

/**
 * @Package: design.pattern.actionmode.memento.memento_example
 * @Description:     ChessmanMemento充当备忘录, 保存棋子的状态
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
class ChessmanMemento {

    /**
     * 棋子标记
     */
    private String label;
    /**
     * x，y坐标
     */
    private int x;
    private int y;

    public ChessmanMemento(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
