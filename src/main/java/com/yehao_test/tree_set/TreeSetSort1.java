package com.yehao_test.tree_set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * treeSet 排序 方法1 ：在TreeSet 构造器中使用自定义比较器，实现Comparator接口，实现compare方法， new
 * TreeSet时指定比较器TreeSet<Foo> set = new TreeSet(new MyComparator());
 * 这样在set.add()元素时就会根据自己定义比较器进行排序了
 * @author yehao
 */
public class TreeSetSort1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeSet<Foo> set = new TreeSet<Foo>(new MyComparator());
        set.add(new Foo(1));
        set.add(new Foo(9));
        set.add(new Foo(7));
        set.add(new Foo(6));
        set.add(new Foo(2));
        set.add(new Foo(5));
        Iterator<Foo> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Foo {
    private int num;
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "Foo [num=" + num + "]";
    }
    public Foo(int num) {
        super();
        this.num = num;
    }
}
class MyComparator implements Comparator<Foo> {
    public int compare(Foo o1, Foo o2) {
        if (o1.getNum() > o2.getNum()) {
            return 1;
        } else if (o1.getNum() == o2.getNum()) {
            return 0;
        } else {
            return -1;
        }
    }
}
