package search.sort.service;

import search.sort.service.impl.DefaultRuleContext;

import java.util.List;

/**
 * @Package: com.helijia.search.sort.plugin.artisan.service
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/18.
 */
public interface SortContextService<E extends Object> {
    /**
     * 清空资源
     */
    void clear();

    /**
     * 批量获取上下文对象集合
     * @param ens 需要获取上线文的产品list
     * @return  获取的排序使用的上下文
     */
    List<DefaultRuleContext<E>> getSortContextList(List<E> ens);

}
