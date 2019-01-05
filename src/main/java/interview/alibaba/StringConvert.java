package interview.alibaba;


/**
 *
 * 给一个字符串 alibaba, 给一个 index = 2 ， 实现 字符串 index 前后交换
 *  如： str = alibaba， index =2 , 交换后：babaali
 *
 * Created by yehao on 2018/12/28.
 */
public class StringConvert {

    public static void main(String[] args) {
        String str = "alibaba";
        int index =5;
        System.out.println(str +"\n" + convert(str, index));
    }

    /**
     *  数组成环   0，1，2，3，4，5，...,n, 0,1,2
     *
     * @param str   字符串
     * @param index   index
     * @return
     */
    private static String convert(String str, int index ) {
        if (null == str || str.length() <=0 || index > str.length()){
            return str;
        }
        char tmp ;
        int len = str.length();
        char[] arr = str.toCharArray();
        for (int i = 0; i <= index; i++) {
            tmp = arr[0];
            for (int j = 0; j < len-1; j++) {
                char t = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = t;
            }
            arr[len-1] = tmp;
        }
        System.out.println(arr);
        return String.valueOf(arr);

    }
}
