package design.pattern.structuremode.facade.example_facade;

/**
 * @Package: design.pattern.structuremode.facade.example_facade
 * @Description:   外观模式：实现读取源文件、加密、保存加密之后的文件的统一入口，客户端和此类交互，客户端不需要再调用具体的readFile / WriteFile / EncryptFile的操作
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class Facede {

    private ReadFile readFile;
    private WriteFile writeFile;
    private EncryptFile encryptFile;

    public Facede() {
        this.readFile = new ReadFile();
        this.writeFile = new WriteFile();
        this.encryptFile = new EncryptFile();
    }

    /**
     * 封装实现读取源文件、加密、保存加密之后的文件
     * 客户端只需要调用此方法即可
     * @param fileName
     */
    public void operateFile(String fileName){
        readFile.readFile(fileName);
        encryptFile.encrypt(fileName);
        writeFile.writeFile(fileName);
    }
}
