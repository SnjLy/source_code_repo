package design.pattern.createmode.simplefactory1;

/**
 * Created by yehao on 2018/5/11.
 */
public class CircleShape extends AbstractShape {

    private Integer  radius;

    public CircleShape() {
        System.out.println("创建一个圆");
        this.setName("月亮圆");
    }

    @Override
    public void draw() {
        setEdge(1);
        setRadius(2);
        System.out.println("画一个大圆, 面积是:" + Math.PI * radius * radius);
    }

    @Override
    public void erase() {
        setEdge(0);
        setRadius(0);
        System.out.println("擦除圆图案, 面积是:" + 0);
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
