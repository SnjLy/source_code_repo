package rpc.thrift.bytes;

import com.springmvc.model.User;
import org.apache.avro.util.ByteBufferInputStream;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * rpc.thrift.bytes
 *
 * @author: SNJly
 * @date: 2019-06-26
 */
public class ByteUtils {


    public static byte[] getBytes(Serializable object) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.writeObject(object);
        oout.flush();
        byte[] bytes = bout.toByteArray();
        bout.close();
        oout.close();
        return bytes;
    }

    public static int sizeof(Serializable obj) throws IOException {
        return getBytes(obj).length;
    }


    public static Object getObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object object = ois.readObject();
        bis.close();
        ois.close();
        return object;
    }


    public static Object getObject(ByteBuffer byteBuffer)throws IOException, ClassNotFoundException{
        InputStream is = new ByteArrayInputStream(byteBuffer.array());
        ObjectInputStream ois = new ObjectInputStream(is);
        Object object = ois.readObject();
        is.close();
        ois.close();
        byteBuffer.clear();
        return object;
    }


    public static ByteBuffer getByteBuffer(Serializable obj) throws IOException {
        byte[] bytes = getBytes(obj);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return buffer;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        User user = new User(10, "yehao", "sdfsfsdfds", 12);
        System.out.println(user);
        byte[] bytes = getBytes(user);
        System.out.println("bytes:" + bytes);
        User u = (User) getObject(bytes);
        System.out.println("from byte[]:" + u);
        ByteBuffer byteBuffer = getByteBuffer(user);
        System.out.println("byteBuffer:" + byteBuffer);

        User u2 = (User) getObject(byteBuffer);
        System.out.println("from buffer:" + u2);
        byteBuffer.clear();

        ByteBuffer bf1 = getByteBuffer(123);
        System.out.println("num byteBuffer:" + bf1);

        Integer num = (Integer)getObject(bf1);
        System.out.println("num from buffer:" + num);


    }




}
