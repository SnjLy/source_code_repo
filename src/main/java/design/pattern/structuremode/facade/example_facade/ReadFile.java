package design.pattern.structuremode.facade.example_facade;

/**
 * @Package: design.pattern.structuremode.facade.example_facade
 * @Description:   读文件具体类实现
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class ReadFile {

    public void readFile(String fileName){
        System.out.println("正在读取文件"+ fileName);
        //readFile  something

        System.out.println("读取文件完成......");
    }
}
