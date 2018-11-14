package design.pattern.structuremode.bridge.example_bridge;

/**
 * @Package: design.pattern.structuremode.bridge.example_bridge
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/8.
 */
public class Client {

    public static void main(String[] args) {
        TransferTools transferTools = new PdfTransfer();
        DBImplementor implementor = new MysqlDB();  //实际使用中用配置配置实例，实现开闭原则
        transferTools.setImplementor(implementor);

        String file = transferTools.convertToFile();
        System.out.println("transfer to file:" + file + " end");
    }
}
