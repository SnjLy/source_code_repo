package utils;

import com.google.common.primitives.Bytes;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * com.techwolf.oceanus.search.util
 *
 * @author: SNJly
 * @date: 2019-06-26
 */
@Slf4j
public class ByteUtils {


    public static byte[] getBytes(Object object) throws IOException {
        byte[] bytes = new byte[0];
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(); ObjectOutputStream oout = new ObjectOutputStream(bout)) {
            oout.writeObject(object);
            oout.flush();
            bytes = bout.toByteArray();
        } catch (IOException e) {
            log.error("序列化object to bytes error", e);
        }
        return bytes;
    }


    public static Object getObject(byte[] bytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            // 反序列化
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            log.error("反序列化bytes to object error", e);
        }
        return null;
    }

    public static byte[] list2Byte(List<Byte> list) {
        return Bytes.toArray(list);
    }


    public static List<Byte> byte2List(byte[] bytes) {
        List<Byte> byteList = new ArrayList<>(bytes.length);
        for (byte aByte : bytes) {
            byteList.add(aByte);
        }
        return byteList;
    }



    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("age", 1312);
        map.put("address", "中国大陆还发货");
        map.put("price", 13.2d);
        map.put("set", Arrays.asList("黑色", "白色的"));
        "string".getBytes();
        try {
            byte[] bytes = getBytes(map);
            List<Byte> byteList = byte2List(bytes);
            System.out.println(byteList);
            byte[] bytes1 = list2Byte(byteList);
            System.out.println("list2Bytes" + bytes1);
            assert bytes==bytes1;


            Map<String, Object> nMap = (Map<String, Object>) getObject(bytes);
            for (Map.Entry<String, Object> entry : nMap.entrySet()) {
                System.out.println(entry.getKey() + "==" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,  byte[]> bufferMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                bufferMap.put(entry.getKey(), getBytes(entry.getValue()));
            } catch (IOException e) {
                System.out.println("序列化错误" + e);
            }
        }
        System.out.println("\n反序列化:\n");
        for (Map.Entry<String, byte[]> entry : bufferMap.entrySet()) {
            System.out.println(entry.getKey() + "==>" + getObject(entry.getValue()));
        }
        System.out.println("done");
    }
}
