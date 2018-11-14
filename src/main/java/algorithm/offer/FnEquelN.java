package algorithm.offer;

/**
 * Created by yehao on 2018/9/9.
 * 计算 f(n) 函数返回 0-n 之间出现1的个数 ，f(1)=1 f(13)=6  计算 f(n) = n,求最大的 n 是多少
 *
 */
public class FnEquelN {

    public static void main(String[] args) {
        int n=2;
        int res=1;
        int k =0;
        while((k=getOnly(n))+res!=n){
            res += k;
            ++n;
        }
        System.out.printf("max n:" + n);
    }

    private static int getOnly(int n) {
        int num = 0;
        String s =n+"";
        int len =s.length();
        if(len!=0){
            for (int i = 0; i < len; i++) {
                char a=s.charAt(i);
                if (a=='1'){
                    num++;
                }
            }
        }
        return num;
    }


}
