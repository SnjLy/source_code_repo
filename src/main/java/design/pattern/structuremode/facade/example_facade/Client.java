package design.pattern.structuremode.facade.example_facade;

/**
 * @Package: design.pattern.structuremode.facade.example_facade
 * @Description: 具体调用方法的客户端
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class Client {

    public static void main(String[] args) {

        /*
        * 只需要调用facade的operateFile方法即可，不需要再与ReadeFile、WriteFile、EncryptFile交互了，减少客户端与后端子系统的调用
         */
        Facede facede = new Facede();
        facede.operateFile("sys.log");
    }
}
