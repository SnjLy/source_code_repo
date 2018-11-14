package com.yehao_test.EightSort;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * name：选择排序
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * Created by yehao on 2016/9/14.
 */
public class SelectSort<T> {

	public static int[] selectSort(int[] list){
		int position = 0;
		for (int i = 0 ;i<list.length;i++){
			int j = i+1;
			position = i;
			int temp = list[i];
			for (;j<list.length;j++){
				if(list[j]<temp){
					temp = list[j];
					position = j;
				}
			}
			list[position] = list[i];
			list[i] = temp;
		}

		System.out.println("排序后的的数组："+ JSON.toJSONString(list));
		return list;
	}

	public static void main(String[] args) {
		int a[]={1,54,6,3,78,34,12,45};
		System.out.println("排序之前的数组："+JSON.toJSONString(a));
		selectSort(a);

	}


}
