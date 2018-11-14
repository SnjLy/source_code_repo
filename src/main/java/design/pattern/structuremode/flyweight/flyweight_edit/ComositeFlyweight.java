package design.pattern.structuremode.flyweight.flyweight_edit;


import java.util.ArrayList;
import java.util.List;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_edit
 * @Description:    复合享元模式的使用实例  类本身是一个享元， 其属性中中包含有多个其他享元
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class ComositeFlyweight extends AbstractFile{

    private List<AbstractFile> files = new ArrayList<>();

    public List<AbstractFile> getFiles() {
        return files;
    }


    public void addFlyweight(AbstractFile flyweigth)
    {
        files.add(flyweigth);
    }

    public boolean removeFlyweight(AbstractFile flyweigth) {
        return files.contains(flyweigth) && files.remove(flyweigth);
    }

    public void operate(FileAttribute attribute){
        for (AbstractFile file : files){
            file.show(attribute);
        }
    }


    public ComositeFlyweight() {
        this.classify = "edit";
    }

    /**
     * 子类继承，必须实现的内部共有方法
     *
     * @return
     */
    @Override
    public String getClassify() {
        return this.classify;
    }
}
