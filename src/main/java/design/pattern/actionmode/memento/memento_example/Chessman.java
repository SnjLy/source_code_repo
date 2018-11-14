package design.pattern.actionmode.memento.memento_example;

/**
 * @Package: design.pattern.actionmode.memento.memento_example
 * @Description: 象棋棋子类:原发器   普通类
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/26.
 */
public class Chessman {

    /**
     * 棋子标记
     */
    private String label;
    /**
     * x，y坐标
     */
    private int x;
    private int y;


    public Chessman(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    /**
     * 保存棋子状态
     *
     * @return
     */
    public ChessmanMemento save() {
        return new ChessmanMemento(this.label, this.x, this.y);
    }

    /**
     * 恢复状态
     *
     * @param memento
     */
    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
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


class MementoClient {
    private static int index = -1; //定义一个索引来记录当前状态所在位置
    private static MementoCaretaker mc = new MementoCaretaker();

    public static void main(String[] args) {
        Chessman chess = new Chessman("车", 1, 1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess, index);
        undo(chess, index);
        redo(chess, index);
        redo(chess, index);
    }

    //下棋
    public static void play(Chessman chess) {
        //保存备忘录
        mc.addMemento(chess.save());
        index ++;
        System.out.println("棋子" + chess.getLabel() + "当前位置为:" +chess.getX() + "," + chess.getY());
    }
    //悔棋
    public static void undo(Chessman chess,int i) {
        System.out.println("******悔棋******");
        index --;
        //撤销到上一个备忘录
        chess.restore(mc.getMemento(i-1));
        System.out.println("棋子" + chess.getLabel() + "当前位置为:" + chess.getX() + "," + chess.getY());
    }

    //撤销悔棋
    public static void redo(Chessman chess,int i) {
        System.out.println("******撤销悔棋******");
        index ++;
        //恢复到下一个备忘录
        chess.restore(mc.getMemento(i+1));
        System.out.println("棋子" + chess.getLabel() + "当前位置为:" + chess.getX() + "," + chess.getY());
    }


}
