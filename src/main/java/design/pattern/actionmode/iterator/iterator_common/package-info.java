/**
 * @Package: design.pattern.actionmode.iterator.iterator_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/14.
 */
package design.pattern.actionmode.iterator.iterator_common;

/**
        在迭代器模式结构图中包含如下几个角色:
        ● Iterator(抽象迭代器):它定义了访问和遍历元素的接口，声明了用于遍历数据元素的方
        法，例如:用于获取第一个元素的first()方法，用于访问下一个元素的next()方法，用于判断是
        否还有下一个元素的hasNext()方法，用于获取当前元素的currentItem()方法等，在具体迭代器 中将实现这些方法。

        ● ConcreteIterator(具体迭代器):它实现了抽象迭代器接口，完成对聚合对象的遍历，同时
        在具体迭代器中通过游标来记录在聚合对象中所处的当前位置，在具体实现时，游标通常是 一个表示位置的非负整数。

        ● Aggregate(抽象聚合类):它用于存储和管理元素对象，声明一个createIterator()方法用于
        创建一个迭代器对象，充当抽象迭代器工厂角色。

        ● ConcreteAggregate(具体聚合类):它实现了在抽象聚合类中声明的createIterator()方法，
        该方法返回一个与该具体聚合类对应的具体迭代器ConcreteIterator实例。

        在迭代器模式中，提供了一个外部的迭代器来对聚合对象进行访问和遍历，迭代器定义了一
        个访问该聚合元素的接口，并且可以跟踪当前遍历的元素，了解哪些元素已经遍历过而哪些
        没有。迭代器的引入，将使得对一个复杂聚合对象的操作变得简单

  */
