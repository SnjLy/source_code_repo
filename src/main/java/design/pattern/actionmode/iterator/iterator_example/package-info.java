/**
 * @Package: design.pattern.actionmode.iterator.iterator_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/25.
 */
package design.pattern.actionmode.iterator.iterator_example;

/*
 *  重构之后的销售 管理系统数据遍历结构
 *
 *  迭代器模式具体事例
 *
 *  如果需要增加一个新的具体聚合类，如客户数据集合类，并且需要为客户数据集合类提供不
 *  同于商品数据集合类的正向遍历和逆向遍历操作，只需增加一个新的聚合子类和一个新的具
 *  体迭代器类即可，原有类库代码无须修改，符合“开闭原则”;如果需要为ProductList类更换一
 *  个迭代器，只需要增加一个新的具体迭代器类作为抽象迭代器类的子类，重新实现遍历方
 *  法，原有迭代器代码无须修改，也符合“开闭原则”;
 *
 *  但是如果要在迭代器中增加新的方法，则
 *  需要修改抽象迭代器源代码，这将违背“开闭原则”。
 */