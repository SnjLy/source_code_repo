package com.yehao_test.fanxing;
/**
 * 如果try语句里有return，那么代码的行为如下：
 *  1.如果有返回值，就把返回值保存到局部变量中
 *  2.执行jsr指令跳到finally语句里执行
 *  3.执行完finally语句后，返回之前保存在局部变量表里的值
 * @author YEHAO
 *
 */
public class TryFinallyDemo {
    
    public int getNum() {
        int x = 1;
        
        try {
            System.out.println("try return...");
//            return ++x;              
            ++x;                    //1、先执行++x,将结果保存在本地局部变量,在执return 之前将控制权转交到finally,
            return x;               //3、执行return，返回本地局部变量保存的结果。效果与return ++x;相同
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ++x;                    //2、在执行finally中的 ++x,执行finally中的代码
            System.out.println("fianlly return..."+x);
        }
        return x;
    }

    public static void main(String[] args) {
        /**执行结果如下：
         * try return...
         * fianlly return...3
         * 2
         * */
        TryFinallyDemo demo = new TryFinallyDemo();
        int x = demo.getNum();
        System.out.println(x);//输出2
        
    }

}
