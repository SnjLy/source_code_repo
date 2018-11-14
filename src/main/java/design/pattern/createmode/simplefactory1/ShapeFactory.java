package design.pattern.createmode.simplefactory1;

/**
 * 调用工厂方法，创建具体的几何形状
 * Created by yehao on 2018/5/11.
 */
public class ShapeFactory {

    public static AbstractShape createShape(String type) {
        AbstractShape shape = null;
        if (type.equals("circle")) {
            shape = new CircleShape();
        } else if ("triangle".equals(type)) {
            shape = new TriangleShape();
        } else if ("rectangle".equals(type)) {
            shape = new RectangleShape();
        } else {
            throw new UnsupportedOperationException();
        }
        return shape;
    }

    public static void main(String[] args) {
        String type = "triangle";
        AbstractShape shape = ShapeFactory.createShape(type);
        shape.draw();
        shape.erase();
    }


}
