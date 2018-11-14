package design.pattern.structuremode.facade.abstract_facede;

/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class Client {

    public static void main(String[] args) {
        String fileName = "index";
        /*
         * 客户端对抽象接口操作， 此处可以通过bean 注入或者xml文件配置的形式获取具体的外观修饰类
         */
        AbstractFacade facade ;
        facade = new VectorFadace();

        facade.operateFile(fileName);

    }
}
