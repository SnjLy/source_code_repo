package com.yehao_test.EightSort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * name:冒泡排序
 *
 *基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 *
 * Created by yehao on 2016/9/14.
 */
public class BubbleSort {

	public BubbleSort(){
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53};
		int temp = 0 ;
		for (int i = 0;i<a.length-1;i++){
			for (int j =0 ; j<a.length-1-i; j++){
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(JSON.toJSON(a));
	}

	public static void main(String[] args) {
		new BubbleSort();
	}


}
