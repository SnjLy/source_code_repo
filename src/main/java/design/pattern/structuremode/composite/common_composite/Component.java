package design.pattern.structuremode.composite.common_composite;

/**
 * @Package: design.pattern.structuremode.composite.common_composite
 * @Description: 组合模式通用抽象构建， 既可以是接口 也可以是 抽象类 , 用于表示 容器节点或者叶子节点 ， 面对抽象构建编程   包含所有子类共有行为的声明和实现
 * @function:
 * 组合模式的关键是定义了一个抽象构件类，它既可以代表叶子，又可以代表容器，而客户端
 * 针对该抽象构件类进行编程，无须知道它到底表示的是叶子还是容器，可以对其进行统一处
 * 理。同时容器对象与抽象构件类之间还建立一个聚合关联关系，在容器对象中既可以包含叶
 * 子，也可以包含容器，以此实现递归组合，形成一个树形结构。
 *
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public abstract class Component {    //包含所有子类共有行为的声明和实现

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract Component getChile(int i);
    public abstract String operation();  //具体业务方法， 实际场景和业务相关，
}
