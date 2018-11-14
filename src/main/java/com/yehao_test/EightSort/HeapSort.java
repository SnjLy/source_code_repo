package com.yehao_test.EightSort;

import com.alibaba.fastjson.JSON;
import com.yehao_test.BaseUtils.BaseUtils;

import java.util.Arrays;

/**
 * name: 堆排序
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
 *
 * 堆的定义如下：具有n个元素的序列（h1,h2,…,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1） (i=1,2,…,n/2)时称之为堆。在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶* 元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为 * 一个*堆，这时堆的根节点的数最大。然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。从* 算法描述* 来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 * Created by yehao on 2016/9/14.
 */
public class HeapSort {


	public void heapSort(int[] a){
		System.out.println("开始堆排序："+ JSON.toJSONString(a));
		int len = a.length;
		//循环建堆
		for (int i= 0 ;i< len -1 ;i++){
			buildMaxHeap(a,len-1-i);//建堆

			BaseUtils.swap(a, 0, len - 1 - i);//交换堆顶和最后一个元素
			System.out.println(i+"次建堆过程："+ Arrays.toString(a));
		}
	}

	/**
	 * 数组a 从0dao
	 * @param a
	 * @param lastIndex
	 */
	//对data数组从0到lastIndex建大顶堆
	private void buildMaxHeap(int[] a, int lastIndex) {
		//从lastIndex处节点（最后一个节点）的父节点开始
		for(int i = (lastIndex-1)/2; i>=0; i--){
			int k =i; //k为正在判断的节点(lastIndex的父节点)
			while (k*2+1<=lastIndex){//k节点的左孩子节点index存在

				int biggerIndex = 2*k+1;    //biggerindex 总是记录最大子节点的index   左孩子节点index
				if(biggerIndex<lastIndex){  //左孩子节点的index小于lastIndex，则存在右孩子节点
					if(a[biggerIndex]<a[lastIndex]){
						//右孩子节点index才是最大的index
						biggerIndex++;
					}

				}
				//如果k节点的值小于其较大节点index的值
				if(a[k]<a[biggerIndex]){
					BaseUtils.swap(a,k,biggerIndex);//交换
					k = biggerIndex;
				}else {
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		int a[]={49,38,65,97};
		HeapSort heapSort =new HeapSort();
		System.out.println("长度："+a.length);

		System.out.println("排序前数组："+Arrays.toString(a));
		heapSort.heapSort(a);
		System.out.println("排序后数组："+Arrays.toString(a));
	}

}
