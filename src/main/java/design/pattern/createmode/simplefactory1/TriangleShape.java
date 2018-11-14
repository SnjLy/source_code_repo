package design.pattern.createmode.simplefactory1;

/**
 * Created by yehao on 2018/5/11.
 */
public class TriangleShape extends AbstractShape {

    private Integer bottom;
    private Integer left;
    private Integer right;

    public TriangleShape() {
        System.out.println("创建三角形");
        this.setName("三刀流");
    }

    @Override
    public void draw() {
        setEdge(3);
        setBottom(3);
        setLeft(4);
        setRight(5);
        System.out.println("画一个三角形, 周长是:" + left + right + bottom);
    }

    @Override
    public void erase() {
        setEdge(0);
        setRight(0);
        setBottom(0);
        setLeft(0);
        System.out.println("擦除三角形, 周长是:" + 0);
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }
}
