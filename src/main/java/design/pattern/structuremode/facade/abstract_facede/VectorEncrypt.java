package design.pattern.structuremode.facade.abstract_facede;

/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:   移位加密
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class VectorEncrypt {

    public String encrypt(String str){
        StringBuilder es = new StringBuilder("");
        //设置密钥，移位数为10
        int key = 10;
        char[] chars = str.toCharArray();
        for (char ch : chars)
        {

            int temp = ch;
            //小写字母移位
            if (ch >= 'a' && ch <= 'z') {
                temp += key % 26;
                if (temp > 122){
                    temp -= 26;
                }
                if (temp < 97){
                    temp += 26;
                }
            }
            //大写字母移位
            if (ch >= 'A' && ch <= 'Z') {
                temp += key % 26;
                if (temp > 90) {
                    temp -= 26;
                }
                if (temp < 65) {
                    temp += 26;
                }
            }
            es.append(temp);
        }
        System.out.println("加密完成");
        return  es.toString();
    }
}
