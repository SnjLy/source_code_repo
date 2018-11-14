package design.pattern.structuremode.facade.abstract_facede;

/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
class ReadFile {

    public String readFile(String fileName){
        System.out.println("read file form "+ fileName);
        return fileName.concat(".log");
    }
}
