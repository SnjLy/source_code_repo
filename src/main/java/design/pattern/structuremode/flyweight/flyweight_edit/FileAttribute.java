package design.pattern.structuremode.flyweight.flyweight_edit;

import design.pattern.structuremode.flyweight.flyweight_example.Coordinates;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_edit
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class FileAttribute {
    /**
     * 文件大小
     */
    private Integer size;
    /**
     * 文件位置
     */
    private Coordinates coordinates;

    public FileAttribute(Integer size, Coordinates coordinates) {
        this.size = size;
        this.coordinates = coordinates;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
