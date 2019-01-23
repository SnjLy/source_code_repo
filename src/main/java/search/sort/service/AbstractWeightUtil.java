package search.sort.service;

import search.sort.model.SortRule;

/**
 * @Package: search.sort.service
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public abstract class AbstractWeightUtil {

    /**
     * 根据配置的json创建系统的rule
     * @param sortRule 配置的规则
     * @return
     */
    public abstract Rule buildJsonRule(SortRule sortRule);

    /**
     * 根据配置的json创建系统的rule
     * @param sortRule  配置的El表达式
     * @return
     */
    public abstract Rule buildELRule(SortRule sortRule);
}

