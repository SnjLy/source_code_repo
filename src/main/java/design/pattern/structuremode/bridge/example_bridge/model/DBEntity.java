package design.pattern.structuremode.bridge.example_bridge.model;

/**
 * @Package: design.pattern.structuremode.bridge.example_bridge.model
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/8.
 */
public class DBEntity {

    private Integer type;
    private String kind;

    //... other attributes


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
