package design.pattern.createmode.simplefactory1;

/**
 * 定义抽象类形状，
 * Created by yehao on 2018/5/11.
 */
public abstract class AbstractShape {

    private String name;
    private Integer edge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdge() {
        return edge;
    }

    public void setEdge(Integer edge) {
        this.edge = edge;
    }

    public abstract void draw();

    public abstract void erase();
}
