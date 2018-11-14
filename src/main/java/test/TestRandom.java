package test;

import java.util.Random;

/**
 * @Package: test
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/22.
 */
public class TestRandom {

    public static void main(String[] args) {
        float t=0f, s=0f;
        Random random = new Random();
        for (int i =0; i< 10000000; i++){
            int num = random.nextInt(5);
            if (num <3){
                t++;
            }else {
                s++;
            }
        }
        System.out.println("t:s模拟3：2==" + t +":" + s +"="+ (float)t/s);
    }
}
