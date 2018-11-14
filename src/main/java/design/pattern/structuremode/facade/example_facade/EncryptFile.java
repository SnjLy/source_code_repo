package design.pattern.structuremode.facade.example_facade;

import java.util.UUID;

/**
 * @Package: design.pattern.structuremode.facade.example_facade
 * @Description:  文件加密具体实现类
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class EncryptFile {

    public void encrypt(String fileName){
        System.out.println("开始加密文件"+ fileName);
        // 加密操作
        System.out.println("加密之后的文件" + UUID.randomUUID().toString());
    }
}
