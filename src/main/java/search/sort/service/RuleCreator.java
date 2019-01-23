package search.sort.service;

import search.sort.model.SortRule;

/**
 * @Package: search.sort.service
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public abstract class RuleCreator {

    /**
     * 根据配置的排序规则生成可执行的规则
     *
     * @param sortRule
     * @return
     */
    public Rule createRule(SortRule sortRule) throws IllegalArgumentException {
        if (sortRule == null) {
            throw new IllegalArgumentException("sortRule is null,please check!");
        }
        return this.factoryMethod(sortRule);
    }

    /**
     * 工厂方法提供抽象的规则转换方法，具体规则转换由插件子类具体实现
     *
     * @param sortRule
     * @return
     */
    protected abstract Rule factoryMethod(SortRule sortRule);
}

