package test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Package: test
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/12/27.
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 10);
        map.put("2", 30);
        map.put("3", 40);
        map.put("4", 10);

        System.out.println(JSON.toJSONString(map.values()));
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Integer t = iterator.next();
            if (t == 10) {
                iterator.remove();
            }
        }

        System.out.println(JSON.toJSONString(map.values()));
    }

    public void test(){

    }
}
