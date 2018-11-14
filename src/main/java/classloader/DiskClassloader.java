package classloader;

import java.io.*;

/**
 * @Package: classloader
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/29.
 */
public class DiskClassloader extends ClassLoader {

    /**
     * 加载类路径
     */
    private String myLibPath;

    /**
     * Creates a new class loader using the <tt>ClassLoader</tt> returned by
     * the method {@link #getSystemClassLoader()
     * <tt>getSystemClassLoader()</tt>} as the parent class loader.
     * <p>
     * <p> If there is a security manager, its {@link
     * SecurityManager#checkCreateClassLoader()
     * <tt>checkCreateClassLoader</tt>} method is invoked.  This may result in
     * a security exception.  </p>
     *
     * @throws SecurityException If a security manager exists and its
     *                           <tt>checkCreateClassLoader</tt> method doesn't allow creation
     *                           of a new class loader.
     */
    public DiskClassloader(String myLibPath) {
        this.myLibPath = myLibPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = getFileName(name);
        File file = new File(myLibPath, fileName);

        try {
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int len = 0;
            try {
                while((len=is.read())!=-1){
                    bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] date = bos.toByteArray();
            is.close();;
            bos.close();
            return defineClass(name, date, 0 , date.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    /**
     * 获取要加载的class文件名
     * @param name  class文件名称
     * @return
     */
    private String getFileName(String name) {
        int index = name.lastIndexOf(".");
        if (index == -1){
            return name.concat(".class");
        }
        return name.substring(index + 1).concat(".class");
    }
}
