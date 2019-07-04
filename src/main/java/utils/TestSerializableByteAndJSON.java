package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

/**
 * utils
 *
 * @author: SNJly
 * @date: 2019-06-28
 */
public class TestSerializableByteAndJSON {

    public static final int TOTAL = 1000;
    public static final int PER = 100;

    private Thread[] threads = new Thread[]{};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL; i++) {
                String origin = "测试转化" + i;
                byteConvert(origin);
        }
        System.out.println("byteConvert:" + (System.currentTimeMillis()- start));



        long newStart = System.currentTimeMillis();
        for (int  j= 0; j < TOTAL; j++) {
            String origin = "测试转化" + j;
            byteConvert(origin);
        }
        System.out.println("jsonConvert:" + (System.currentTimeMillis()- newStart));
    }


    public static void byteConvert(Object obj) {
        for (int i = 0; i < PER; i++) {
             new Thread(() -> {
                try {
                    byte[] bytes = ByteUtils.getBytes(obj);
                    List<Byte> byteList = ByteUtils.byte2List(bytes);
                    byte[] bytes1 = ByteUtils.list2Byte(byteList);
                    Object object = ByteUtils.getObject(bytes1);
                    Assert.assertEquals(obj, object);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }


    public static void jsonConvert(Object obj){
        for (int i = 0; i < PER; i++) {
            new Thread(()->{
                String jsonString = JSON.toJSONString(obj);
                JSONObject object = JSON.parseObject(jsonString);
                Assert.assertEquals(obj, object);
            }).start();
        }
    }


}
