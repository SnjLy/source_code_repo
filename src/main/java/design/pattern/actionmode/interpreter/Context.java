package design.pattern.actionmode.interpreter;

import java.util.HashMap;

/**
 * @Package: design.pattern.actionmode.interpreter
 * @Description:   在解释器模式中还提供了一个环境类Context，用于 存储一些全局信息，
 *                  通常在Context中包含了一个HashMap或ArrayList等类型的集合对象(也可
 *                  以直接由HashMap等集合类充当环境类)，存储一系列公共信息
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/14.
 */
public class Context {

    private HashMap map = new HashMap();

    public void assign(String key, String value){
        //往环境中设置值
        map.put(key, value);
    }

    public String lookup(String key){
        return map.get(key).toString();
    }

}
