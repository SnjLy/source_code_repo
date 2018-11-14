package design.pattern.actionmode.iterator.iterator_example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: design.pattern.actionmode.iterator.iterator_example
 * @Description:   抽象聚合类,申明聚合方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/25.
 */
public abstract class AbstractObjectList {
    /**
     * 让子类继承
     */
    protected List<Object> objects = new ArrayList<>();

    public AbstractObjectList(List list){
        this.objects = list;
    }

    public void addObjects(Object object){
        this.objects.add(object);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }
    public List getObjects() {
        return this.objects;
    }


    /**
     * 声明创建迭代器对象的抽象工厂方法
     */
    public abstract AbstractIterator createIterator();
}

/**
 * 商品数据类:具体聚合类
 */
class ProductList extends AbstractObjectList{

    public ProductList(List list) {
        super(list);
    }

    /**
     * 声明创建迭代器对象的抽象工厂方法
     */
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}

/**
 * 商家数据类:具体聚合类
 * 新增聚合类实现即可
 */
//class StoreList extends AbstractObjectList{
//
//}