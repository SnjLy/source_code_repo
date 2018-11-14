package design.pattern.structuremode.bridge.example_bridge;

import design.pattern.structuremode.bridge.example_bridge.model.DBEntity;

/**
 * @Package: design.pattern.structuremode.bridge.example_bridge
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/8.
 */
public class SQLServerDB implements DBImplementor{

    @Override
    public DBEntity readFromDB() {
        DBEntity server = new DBEntity();
        server.setType(2);
        server.setKind("SqlServer");  //模拟从数据库读取数据
        System.out.println("read data from sqlServer db");
        return server;
    }
}
