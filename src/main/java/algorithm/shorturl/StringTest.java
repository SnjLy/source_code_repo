package algorithm.shorturl;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/1/10.
 */
public class StringTest {

    public static void main(String[] args) {
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program";
//        String s4 = "ming";
//        String s5 = "Program" + "ming";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
//        System.out.println("s1:"+s1.intern() +"s2:"+s2.intern()+ "s3:"+s3.intern()+
//              "s4:"+s4.intern() +"s5:"+s5.intern() +"s6:"+s6.intern());


        try {
            String name = "zhagg,12354,zhenge,hello,74.954,13037106830";
            List<String> list = StringTest.method1(name);
            StringTest.method1(list);
            throw new Exception("error!") ;
        } catch (Exception e) {
            System.out.println(e);
        }

    }



    public static List<String> method1(String name){
        List<String> list = new ArrayList<>();
        try {
            String[] s = name.trim().split(",");
            list = Arrays.asList(s);
            throw new Exception("string spilt error!");
        } catch (Exception e) {
            System.out.println("name spit:"+ JSON.toJSONString(list)+"----"+e.getMessage());
        }

        return list;
    }


    public static void method1(List<String> names){
        try {
            for (int i=0;i<= names.size();i++){
                System.out.println(names.get(i));
            }
        } catch (Exception e) {
            System.out.println("names print:"+ JSON.toJSONString(names)+"----"+e);
        }
    }
}
