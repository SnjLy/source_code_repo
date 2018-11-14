package design.pattern.actionmode.iterator.iterator_example;

import java.util.List;

/**
 * @Package: design.pattern.actionmode.iterator.iterator_example
 * @Description:  抽象迭代器，由子类实现具体迭代逻辑
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/25.
 */
public interface AbstractIterator {

    /**
     * 移至下一个元素
     */
    public void next();

    /**
     *  判断是否为最后一个元素
     * @return  是否是最后一个元素
     */
    public boolean isLast();

    /**
     * 移至上一个元素
     */
    public void previous();

    /**
     * 判断是否为第一个元素
     * @return 是否是第一个元素
     */
    public boolean isFirst();

    /**
     * 获取下一个元素
     * @return 迭代到下一个元素
     */
    public Object getNextItem();

    /**
     * 获取上一个元素
     * @return 上一个迭代
     */
    public Object getPreviousItem();
}


class ProductIterator implements AbstractIterator{
    private ProductList productList;
    private List products;
    /**
     *  正向遍历游标
     */
    private int cursor1;
    /**
     * 逆向遍历游标
     */
    private int cursor2;

    public ProductIterator(ProductList productList) {
        this.productList = productList;
        this.products = productList.getObjects();
        this.cursor1 = 0;
        this.cursor2 = products.size() -1;
    }

    /**
     * 移至下一个元素
     */
    @Override
    public void next() {
        if (cursor1<this.products.size()){
            cursor1 ++;
        }
    }

    /**
     * 判断是否为最后一个元素
     *
     * @return 是否是最后一个元素
     */
    @Override
    public boolean isLast() {
        return cursor1 == products.size();
    }

    /**
     * 移至上一个元素
     */
    @Override
    public void previous() {
        if (cursor2 > -1){
            cursor2 --;
        }
    }

    /**
     * 判断是否为第一个元素
     *
     * @return 是否是第一个元素
     */
    @Override
    public boolean isFirst() {
        return cursor2 == -1;
    }

    /**
     * 获取下一个元素
     *
     * @return 迭代到下一个元素
     */
    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    /**
     * 获取上一个元素
     *
     * @return 上一个迭代
     */
    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
