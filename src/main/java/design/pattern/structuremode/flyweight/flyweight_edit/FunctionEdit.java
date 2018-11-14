package design.pattern.structuremode.flyweight.flyweight_edit;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_edit
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class FunctionEdit {

    private static final FunctionEdit edit = new FunctionEdit();

    public static FunctionEdit getEdit() {
        return edit;
    }

    private static Hashtable ht ;

    private FunctionEdit() {
        ht = new Hashtable<>();
        AbstractFile file ;
        file = new Video();
        ht.put(file.getClassify(), file);
        file = new Cartoon();
        ht.put(file.getClassify(), file);
        file = new Picture();
        ht.put(file.getClassify(), file);
    }

    public AbstractFile getCompnont(String classify){
        return (AbstractFile) ht.get(classify);
    }
}
