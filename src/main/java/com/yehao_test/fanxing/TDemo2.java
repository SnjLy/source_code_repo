package com.yehao_test.fanxing;

import java.util.Arrays;
import java.util.List;

public class TDemo2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ints = {1,3,4,9,5};
        List list = Arrays.asList(ints);
        System.out.println(list.size()+"--List[0]---"+list.get(0)); 
        //输出 1--List[0]---[I@3929df79  证明8中基本类型不能做为asList的参数
        Integer[] integers = {1,3,4,9,5};
        list = Arrays.asList(integers);
        System.out.println(list.size()+"--List[0]---"+list.get(0)); 
        // 5--List[0]---1 
        /**
         * 结论：使用asList是需要使用基本类型的封装作为参数。
         */
//        list.add(10);
//        System.out.println(list.size()+"--List[size-1]---"+list.get(list.size()-1));
        //list.add() 失败，证明asList返回的列表是固定长度的，不可变长度。不能操作asList返回的列表长度

    }

}
