package com.yehao_test.BaseUtils;

import com.alibaba.fastjson.JSON;
import sun.applet.Main;

/**
 * Created by admin on 2016/9/14.
 */
public class BaseUtils {

	public static void swap(int[] data , int i , int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = {32,56,12,-45,75,56,25};
		System.out.println("初始数组："+ JSON.toJSONString(a));
		swap(a,0,1);
		swap(a,3,5);
		System.out.println("交换之后的数组："+JSON.toJSONString(a));
	}


}
