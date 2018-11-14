package design.pattern.structuremode.composite.example_composite;

/**
 * @Package: design.pattern.structuremode.composite.example_composite
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public class TextFile extends AbstractFile{

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        try {
            throw new IllegalAccessException("暂不支持该方法");
        } catch (IllegalAccessException e) {
            System.out.println(this.getClass().getSimpleName() + "不支持添加子文件");
        }
    }

    @Override
    public void remove(AbstractFile file) {
        try {
            throw new IllegalAccessException("暂不支持该方法");
        } catch (IllegalAccessException e) {
            System.out.println(this.getClass().getSimpleName() + "不支持移除子文件");
        }
    }

    @Override
    public AbstractFile get(int i) {
        try {
            throw new IllegalAccessException("暂不支持该方法");
        } catch (IllegalAccessException e) {
            System.out.println(this.getClass().getSimpleName() + "不支持获取子文件");
        }
        return null;
    }

    @Override
    public void operation() {
        System.out.println("operate file : " + this.getName());
    }
}
