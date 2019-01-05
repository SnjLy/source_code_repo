package interview.alibaba;

/**
 * 阿里面试题笔试题
 * Created by yehao on 2018/12/28.
 */
public class IntegerConvert {

    public static void main(String[] args) {
        IntegerConvert convert = new IntegerConvert();
        //String a = "1234", b = "12";
        String a = "99999", b = "88888";
        convert.add(a, b);

    }

    /**
     * 假设a = 1234, b = 21
     */
    public String add(String a, String b){
        //结果存储
        String result = "";
        int la = a.length();
        int lb = b.length();
        //比较 la与 lb 的大小
        int maxL = la > lb? la:lb;
        int minL = la > lb? lb:la;
        //用 StringBuffer 记录结果
        StringBuffer sb = new StringBuffer();

        //长度不一样，只需要按照 minL 的长度计算， 34 + 21 ， 12现记录
        for (int i = 0; i <maxL - minL; i++) {
            sb.append(0);
        }
        //sb : 00
        if (minL ==la){
            sb.append(a);
            a = sb.toString();
        }else {
            sb.append(b);
            b = sb.toString();
        }

        //sb: 0021
        //实现成 0021 + 1234 如果相同：   333 + 999 = 1332

        System.out.println(a);
        System.out.println(b);
        int ta, tb, tmp;
        int c = 0; //进位
        sb = new StringBuffer();
        for (int i = maxL-1; i >=0 ; i--) {
            int r = 0; // 记录个位相加的值
            //额， 字符是 ascll码， 需要-'0'的值
            ta = Integer.valueOf(a.charAt(i)) -48;
            tb = Integer.valueOf(b.charAt(i)) -48;
            tmp = ta + tb + c;
            c = tmp /10;
            r = tmp % 10;
            sb.append(r);
        }
        //最后一位相加超过了还需要进位
        if (c>0){
            sb.append(c);
        }

        result = sb.reverse().toString();
        System.out.println(result);
        return result;

    }


}
