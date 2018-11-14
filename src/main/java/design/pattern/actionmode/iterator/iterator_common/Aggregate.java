package design.pattern.actionmode.iterator.iterator_common;

/**
 * @Package: design.pattern.actionmode.iterator.iterator_example
 * @Description:  抽象聚合类：聚合类用于存储数据并负责创建迭代器对象，最简单的抽象聚合类代码如下所示:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/14.
 */
public interface Aggregate {

    /**
     * 抽象方法，创建迭代器对象
     * @return
     */
    Iterator createIterator();
}

/**
 * 具体聚合类：抽象工厂方法
 * 具体聚合类作为抽象聚合类的子类，一方面负责存储数据，另一方面实现了在抽象聚合类中 声明的工厂方法createIterator()
 */
class ConcreteAggregate implements Aggregate{

    /**
     * 抽象方法，创建迭代器对象
     *
     * @return
     */
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}