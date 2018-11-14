package design.pattern.structuremode.composite.example_composite;

/**
 * @Package: design.pattern.structuremode.composite.example_composite
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public abstract class AbstractFile {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile get(int i);
    public abstract void operation();
}
