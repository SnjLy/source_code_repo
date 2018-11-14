package design.pattern.structuremode.bridge.example_bridge;

import design.pattern.structuremode.bridge.example_bridge.model.DBEntity;

/**
 * @Package: design.pattern.structuremode.bridge.example_bridge
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/8.
 */
public interface DBImplementor {

    public DBEntity readFromDB();
}
