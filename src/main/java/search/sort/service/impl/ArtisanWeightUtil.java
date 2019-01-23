package search.sort.service.impl;

import search.sort.model.RuleJsonImpl;
import search.sort.model.RuleSpringElImpl;
import search.sort.model.SortRule;
import search.sort.service.AbstractWeightUtil;
import search.sort.service.Rule;

/**
 * @Package: search.sort.service.impl
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public class ArtisanWeightUtil extends AbstractWeightUtil {


    /**
     * 根据配置的json创建系统的rule
     *
     * @param sortRule 配置的规则
     * @return
     */
    @Override
    public Rule buildJsonRule(SortRule sortRule) {
        System.out.println("sortRule转化成ArtisanJsonRule");
        return new RuleJsonImpl();
    }

    /**
     * 根据配置的json创建系统的rule
     *
     * @param sortRule 配置的El表达式
     * @return
     */
    @Override
    public Rule buildELRule(SortRule sortRule) {
        System.out.println("sortRule转化成ArtisanSpringElRule");
        return new RuleSpringElImpl();
    }
}
