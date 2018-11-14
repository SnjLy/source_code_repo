package design.pattern.createmode.factorymethod;

/**
 * Created by yehao on 2018/5/14.
 */
public abstract class AbstractImage {
    private String type;

    public abstract void read();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
