package design.pattern.structuremode.bridge.example_bridge;

import com.alibaba.fastjson.JSON;
import design.pattern.structuremode.bridge.example_bridge.model.DBEntity;

/**
 * @Package: design.pattern.structuremode.bridge.example_bridge
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/8.
 */
public class TxtTransfer extends TransferTools{

    @Override
    public String convertToFile() {
        DBEntity entity = implementor.readFromDB();
        System.out.println("convert sql to txt, file:" + JSON.toJSONString(entity));
        return "txt";
    }
}
