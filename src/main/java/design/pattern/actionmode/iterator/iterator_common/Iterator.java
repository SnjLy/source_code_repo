package design.pattern.actionmode.iterator.iterator_common;

/**
 * @Package: design.pattern.actionmode.iterator.iterator_example
 * @Description:   抽象迭代器中声明了用于遍历聚合对象中所存储元素的方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/14.
 */
public interface Iterator {

    /**
     * 将游标指向第一个元素
     */
    public abstract void first();

    /**
     * //将游标指向下一个元素
     */
    public abstract void next();

    /**
     * //判断是否存在下一个元素
     * @return
     */
    public boolean hasNext();

    /**
     * //获取游标指向的当前元素
     * @return
     */
    public Object currentItem();
}

/**
 * 具体迭代器:它实现了抽象迭代器接口，完成对聚合对象的遍历，
 * 同时 在具体迭代器中通过游标来记录在聚合对象中所处的当前位置，
 * 在具体实现时，游标通常是 一个表示位置的非负整数
 */
class ConcreteIterator implements Iterator{

    private ConcreteAggregate aggregate;

    /**
     * 游标，记录当前访问位置
     */
    private int cursor;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * 将游标指向第一个元素
     */
    @Override
    public void first() {
    }

    /**
     * //将游标指向下一个元素
     */
    @Override
    public void next() {
        cursor +=1;
    }

    /**
     * //判断是否存在下一个元素
     *
     * @return
     */
    @Override
    public boolean hasNext() {

        return true;
    }

    /**
     * //获取游标指向的当前元素
     *
     * @return
     */
    @Override
    public Object currentItem() {
        return cursor;
    }
}