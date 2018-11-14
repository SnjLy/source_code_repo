package algorithm.offer.heap;

import java.util.Random;


/**
 * @Package: algorithm.offer
 * @Description:   实现最大堆（用数组来存放完全二叉树中的节点,从上到下,从左到右排序,按序存在数组,子节点的值小于等于父节点的值）
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/25.
 */
public class Heap {
    private int[] data;
    private int count; //当前节点数
    private int capacity; //容量

    public Heap(int capacity) {
        //因为索引0不存节点，所以长度加一
        this.data = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     *  将一个无序数组构造成一个最大堆
     *  相当于堆排序
     */
    public Heap(int[] arr, int n) {
        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        //i=count/2:i是最后一个叶子节点的父节点(最后一个非叶子节点)
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    private void shiftUp(int i) {
        //data[i/2]为当前节点的父节点
        while ((i > 1) && (data[i / 2] < data[i])) {
            swap(data, i, i / 2);
            //更新索引
            i = i / 2;
        }
    }

    private void shiftDown(int k) {
        while ((2 * k) <= count) {     //有左子节点
            int j = 2 * k;      //这轮循环,data[k]和data[j]交换位置
            if ((j + 1) <= count && (data[j + 1] > data[j])) { //有右子节点且右边的更大
                j += 1;
            }
            //如果父节点大于等于子节点,则停止循环
            if (data[k] >= data[j]) {
                break;
            }
            swap(data, k, j);
            k = j;       //k被赋为当前位置,为下次循环做初始化
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int a) {
        assert ((count + 1) <= capacity);   //防止数组越界
        data[count + 1] = a;     //从索引1开始存
        count++;
        shiftUp(count);  //由于可能新添加的数违背最大堆的定义，所以要重排序
    }

    public int extractMax() {      //弹出最大值，即根节点
        assert (count > 0);
        int ret = data[1];
        swap(data, 1, count);    //将最后数放到第一位置,保持完全二叉树的结构
        count--;
        shiftDown(1);         //将第一个数移至合适位置,保持最大堆性质
        return ret;
    }


    public static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    /**
     * //原地堆排序(就是堆排序),从0开始存
     * @param arr
     * @param n
     */
    public static void situheapsort(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {       //i=(n-1)/2:i是最后一个叶子节点的父节点(最后一个非叶子节点)
            __shiftDown(arr, n, i);      //将一个完全无序的数组arr构造成最大堆
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);          //第一个即最大值与最后一个值交换
            __shiftDown(arr, i, 0);   //把第一个较小的值放在合适位置,此时的数组长度为n-1
        }
    }

    public static void __shiftDown(int[] arr, int n, int k) {
        //有左子节点
        while ((2 * k + 1) < n) {
            //这轮循环,arr[k]和arr[j]交换位置
            int j = 2 * k + 1;
            if ((j + 1) < n && (arr[j + 1] > arr[j])) { //有右子节点且右边的更大
                j += 1;
            }
            //如果父节点大于等于子节点,则停止循环
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);

            //k被赋为当前位置,为下次循环做初始化
            k = j;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        System.out.print("插入的数为:");
        for (int i = 0; i < 30; i++) {
            int rand = new Random().nextInt(100) + 1;
            System.out.print(rand + " ");
            heap.insert(rand);
        }
        System.out.println();
        System.out.print("heap.extractMax():");
        while (!heap.isEmpty()) {
            //从大到小输出
            System.out.print(heap.extractMax() + " ");
        }
        System.out.println();
        System.out.println("*********************堆排序*********************************");
        int[] arr = randomCommon(0, 100, 21);
        situheapsort(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }


    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }


}
