package design.pattern.structuremode.facade.abstract_facede;


import java.io.Console;

/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
class WriteFile {


    public void Write(String encryptStr,String fileNameDes)
    {
        System.out.println("write{"+encryptStr+"}to file"+ fileNameDes );
    }
}
