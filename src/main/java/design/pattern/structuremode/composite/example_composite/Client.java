package design.pattern.structuremode.composite.example_composite;

/**
 * @Package: design.pattern.structuremode.composite.example_composite
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public class Client {

    public static void main(String args[]) {
        //针对抽象构件编程
        AbstractFile file1,file2,file3,file4,file5,folder1, folder3, folder4;
        folder1 = new Folder("Sunny的资料");  folder3 = new Folder("文本文件"); folder4 = new Folder("视频文件");
        file3 = new TextFile("九阴真经.txt"); file4 = new TextFile("葵花宝典.doc"); file5 = new VideoFile("笑傲江湖.rmvb");

        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        folder1.add(folder3);
        folder1.add(folder4);
        //从“Sunny的资料”节点开始进行业务操作
        folder1.operation();
    }
}
