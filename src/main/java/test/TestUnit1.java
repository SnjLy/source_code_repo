package test;

/**
 * Created by yehao on 2018/4/11.
 */
public class TestUnit1 {

    /**
     * 执行结果：
     *
     b:ABC
     a:XYZ
     b:ABC
     * @param args
     */
    public static void main(String[] args) {
        String a = "ABC";
        String b= a;
        System.out.println(b);
        a="XYZ";
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }

    /**
     * python 的执行情况
     >>> a='ABC'
     >>> b=a
     >>> print b
     ABC
     >>> a='XYZ'
     >>> print b
     ABC
     >>> print a
     XYZ
     */
}
