package design.pattern.createmode.simplefactory1;

/**
 * Created by yehao on 2018/5/11.
 */
public class RectangleShape extends AbstractShape {

    private Integer bottom;
    private Integer left;
    private Integer right;
    private Integer top;

    public RectangleShape() {
        System.out.println("创建矩形");
        this.setName("矩天阵");
    }

    @Override
    public void draw() {
        setEdge(4);
        setBottom(3);
        setLeft(4);
        setRight(5);
        setTop(5);
        System.out.println("画一个三角形, 周长是:" + perimeter());
    }

    @Override
    public void erase() {
        setEdge(0);
        setRight(0);
        setBottom(0);
        setLeft(0);
        setTop(0);
        System.out.println("擦除三角形, 周长是:" + perimeter());
    }

    private Integer perimeter(){
        return this.bottom + this.left + this.top + this.right;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
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
