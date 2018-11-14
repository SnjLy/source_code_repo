package design.pattern.structuremode.facade.abstract_facede;


/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class ModeEncrypt {

    public String encrypt(String str) {
        StringBuilder modeStr = new StringBuilder("");
        char[] charArray = str.toCharArray();
        for (char s : charArray) {
            modeStr.append(s % 7);

        }
        System.out.println("encrypt" + str + "end");
        return modeStr.toString();
    }
}
