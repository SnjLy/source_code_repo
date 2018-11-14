package test;

/**
 * @Package: test
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/12.
 */
public class ParseAndValue {

    public static void main(String[] args) {
        System.out.println("start");
        long start = System.currentTimeMillis();
        for (int i =0 ;i<1000000;i++) {
            String s = "116470532.692588";
            Double d = Double.parseDouble(s);
            Double d1 = Double.parseDouble(s);
        }
        System.out.println("end, cost time:"+ (System.currentTimeMillis()-start));


        System.out.println("start");
        start = System.currentTimeMillis();
        for (int i =0 ;i<1000000;i++) {
            String s = "116470532.692588";
            Double d= Double.valueOf(s);
            Double d2=Double.valueOf(s);
        }
        System.out.println("end, cost time:"+ (System.currentTimeMillis()-start));

    }
}
