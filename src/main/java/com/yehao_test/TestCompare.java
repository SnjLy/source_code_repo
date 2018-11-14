package com.yehao_test;

/**
 * @Return 运行结果：
 *  t1=t2:false
 *  t1<=t2:true
 *
 *  使用javac TestCompare.java
 *      javap -c TestCompare.class   查看java编译器为我们生成的字节码，Java 字节码的指令。
 *      分析发现  42 行和 82行 比较的指令不同
         37: aload_1
         38: invokevirtual #9                  // Method java/lang/Integer.intValue:()I
         41: iconst_2
         42: if_icmpne     49
         45: iconst_1
         46: goto          50
         49: iconst_0
         50: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
         53: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
         56: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         59: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
         62: new           #5                  // class java/lang/StringBuilder
         65: dup
         66: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
         69: ldc           #13                 // String t1<=t2:
         71: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/
         lder;
         74: aload_1
         75: invokevirtual #9                  // Method java/lang/Integer.intValue:()I
         78: aload_2
         79: invokevirtual #9                  // Method java/lang/Integer.intValue:()I
         82: if_icmpgt     89
         85: iconst_1
         86: goto          90
 *
 * Created by admin on 2017/3/8.
 */
public class TestCompare {

    public static void main(String[] args) {
        Integer t1 = new Integer(1000);
        Integer t2 = new Integer(1000);

        System.out.println("t1=t2:"+ (t1 == 2));
        System.out.println("t1<=t2:"+ (t1<= t2));
    }
}
