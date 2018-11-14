package design.pattern.structuremode.flyweight.flyweight_edit;

import com.alibaba.fastjson.JSON;
import design.pattern.structuremode.composite.common_composite.Component;

/**
 * @Package: design.pattern.structuremode.flyweight.flyweight_edit
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public abstract class AbstractFile {
    public String classify;

    /**
     * 子类继承，必须实现的内部共有方法
     * @return
     */
    public abstract String getClassify();

    /**
     * 由子类实现自己的外部状态
     * @param attribute
     */
    public void show(FileAttribute attribute){
        System.out.println("文件"+this.getClassify() + "的显示特性：" + JSON.toJSONString(attribute));
    }

}


class Picture extends AbstractFile{

    public Picture() {
        this.classify = "picture";
    }

    @Override
    public String getClassify() {
        return this.classify;
    }

}


class Cartoon extends AbstractFile{

    public Cartoon() {
        this.classify = "cartoon";
    }

    @Override
    public String getClassify() {
        return this.classify;
    }
}

class Video extends AbstractFile{

    public Video() {
        this.classify="video";
    }

    @Override
    public String getClassify() {
        return this.classify;
    }
}