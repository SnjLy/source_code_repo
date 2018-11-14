package algorithm.offer;

/**
 * @Package: algorithm.offer
 * @Description:  实现一个长度为k的最近最少使用队列，
 *                最近最少使用页面置换算法，是为虚拟页式存储管理服务的，是根据页面调入内存后的使用情况进行决策了。
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/27.
 */
public class LRUKQuene<T> {
    /**
     * 内存块的个数
     */
    private static final int CAPACITY = 10;
    /**
     * 内存数组，用于存储， 0是底， size是顶
     */
    private T[] array = (T[]) new Object[CAPACITY];


    private int size = 0;

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断队列是否已满
     *
     * @return 内存区是否达到最大值
     */
    public boolean isOutOfBoundary() {
        if (size >= CAPACITY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取对象o的索引位置
     *
     * @param o 需要查找的对象
     * @return 返回索引位置， -1表示不存在
     */
    public int indexOfElement(T o) {
        for (int i = 0; i < CAPACITY; i++) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有新的收据进入，分配空间， 如果空间不够需要移除
     * @param o
     * @return
     */
    public T push(T o){
        int t = -1;
        //当前内存没满且不存在
        if (!isOutOfBoundary() && indexOfElement(o) == -1){
            array[size] = o;
            size++;
        }else if(isOutOfBoundary() && indexOfElement(o) == -1){
            //已满，不存在，数组前移
            for (int i = 0; i < size-1; i++) {
                array[i] = array[i+1];
            }
            array[size-1] = o;
        }else{
            //元素存在，此位置的数据需要移除
            t = indexOfElement(o);
            for (int i = t; i < size-1; i++) {
                /*
                 *  若已存在，将当前位置后面的往前移，最后把当前值放到最后位置。
                 */
                array[i] = array[i+1];
            }
            array[size-1] = o;
        }
        //t 标记是有此次有数据移除，t及移除数据的index
        if (-1 == t){
            return null;
        }else{
            return array[t];
        }
    }

    /**
     * 输出内存区中的各数据
     */
    public void showMemoryBlock() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }


    public static void main(String[] args) {
        Integer[] iter = {4,7,0,7,1,0,1,2,1,2,6};
        LRUKQuene<Integer> lrukQuene = new LRUKQuene<>();
        for (int i = 0; i < iter.length; i++) {
            lrukQuene.push(iter[i]);
            System.out.println("访问:"+ iter[i] );
            lrukQuene.showMemoryBlock();
            System.out.println();
        }
    }

}
