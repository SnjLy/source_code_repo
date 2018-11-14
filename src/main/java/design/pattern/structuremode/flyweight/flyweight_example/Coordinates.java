package design.pattern.structuremode.flyweight.flyweight_example;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_example
 * @Description:  具体享元的外部状态类， 描述棋子的坐标
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class Coordinates {

    private int x;
    private int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
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
