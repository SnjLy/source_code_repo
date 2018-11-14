package com.yehao_test.tree_set;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * treeSet 排序 方法2 ：使用TreeSet()构造方法，并对需要添加到set集合中的元素(类)实现Comparable接口进行排序； new
 * TreeSet时指定比较器TreeSet<Foo> set = new TreeSet(new MyComparator());
 * 这样在set.add()元素时就会根据自己定义比较器进行排序了
 * @author yehao
 */
public class TreeSetSort2 {
    public static void main(String[] args) {
        TreeSet<Boo> set = new TreeSet<Boo>();
        set.add(new Boo(1));
        set.add(new Boo(9));
        set.add(new Boo(7));
        set.add(new Boo(6));
        set.add(new Boo(2));
        set.add(new Boo(5));
        Iterator<Boo> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }

}
// 构造bean，需要实现Comparable接口，并重写compareTo()方法，compareTo方法中定义排序的方式
class Boo implements Comparable{
    private int num;
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "Boo [num=" + num + "]";
    }
    public Boo(int num) {
        super();
        this.num = num;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Boo) {
            Boo o2 = (Boo) o;
            if (this.getNum() > o2.getNum()) {
                return 1;
            } else if (this.getNum() == o2.getNum()) {
                return 0;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
