package algorithm.offer;

import com.yehao_test.BaseUtils.StringSpilt;

import java.util.*;

/**
 * 题目描述：
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 输入：
 输入可能包含多个测试样例。
 对于每个测试案例，输入的第一行为一个整数m (1<=m <=100)代表输入的正整数的个数。
 输入的第二行包括m个正整数，其中每个正整数不超过10000000。
 输出：
 对应每个测试案例，
 输出m个数字能排成的最小数字。
 样例输入：
 3
 23 13 6
 2
 23456 56
 样例输出：
 13236
 2345656
 这道
 * Created by admin on 2016/12/21.
 */
public class ArrayToMinNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        while(sc.hasNext())
        {
            int[] nums = new int[100];
            m = sc.nextInt();
            int i;
            for(i=0;i<m;i++)
               nums[i] = sc.nextInt();

            PrintMinNum(nums, m);
        }
    }

    private static void PrintMinNum(int[] nums, int m) {
        if (nums.length <=0 || m <=0){
            return;
        }
        List<String> strs = new ArrayList<String>(m);
        for (int i=0;i<m;i++){
            strs.add(nums[i]+"");
        }
        Collections.sort(strs, new MyComparate());
        for (int i =0;i<m;i++){
            System.out.print(strs.get(i));
        }
        System.out.println();
    }

}

class MyComparate implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
