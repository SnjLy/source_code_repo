package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Package: classloader
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/29.
 */
public class ClassloaderTest {

    public static void main(String[] args) {
        String myLibpath = "/Users/yehao/Workspace/codespace/yehao_java_code_repo/src/main/java/";
        //创建自定义的classloader对象
        DiskClassloader diskClassloader = new DiskClassloader(myLibpath);

        //加载Class文件
        try {
            Class c = diskClassloader.loadClass("classloader.TestClass");

            if (c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say", null);
                    method.invoke(obj, null);

                } catch ( IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
