package test;

/**
 * @Package: test
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/7/4.
 */
public class TestAddOne {

    public static void main(String[] args) {
        int a=0,b=0,c=0;

        int x=a++;
        int y=++b;
        int z=c+1;
        System.out.println("a="+a + " b="+b + " c="+c);
        System.out.println("x="+x + " y="+y + " z="+z);


        /* 返回结果
         * a=1 b=1 c=0
         * x=0 y=1 z=1
         *
         */


    }
}
