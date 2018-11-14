package design.pattern.structuremode.composite.example_composite;

import java.util.ArrayList;

/**
 * @Package: design.pattern.structuremode.composite.example_composite
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public class Folder extends AbstractFile {

    public Folder(String name) {
        this.name = name;
    }

    private ArrayList<AbstractFile> files = new ArrayList<>();

    @Override
    public void add(AbstractFile file) {
        files.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        files.remove(file);
    }

    @Override
    public AbstractFile get(int i) {
        return files.get(i);
    }

    @Override
    public void operation() {
        for (Object file : files){
            ((AbstractFile)file).operation();
        }
    }
}
