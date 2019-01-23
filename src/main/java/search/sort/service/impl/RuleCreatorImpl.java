package search.sort.service.impl;


import search.sort.common.SortTypeEnum;
import search.sort.model.SortRule;
import search.sort.service.AbstractWeightUtil;
import search.sort.service.Rule;
import search.sort.service.RuleCreator;

/**
 * @Package: com.helijia.search.sort.plugin.artisan.service.impl
 * @Description:   手艺人规则转化，根据配置的规则，转换成程序识别的规则
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/17.
 */
public class RuleCreatorImpl extends RuleCreator {

    private AbstractWeightUtil weightUtil;


    public RuleCreatorImpl(AbstractWeightUtil weightUtil) {
        this.weightUtil = weightUtil;
    }

    /**
     * 工厂方法提供抽象的规则转换方法，具体规则转换由插件子类具体实现
     *
     * @param sortRule
     * @return
     */
    @Override
    protected Rule factoryMethod(SortRule sortRule) {
        String ruleCondition = sortRule.getRuleCondition();
        // 产品规则
        if (sortRule.getType() == SortTypeEnum.PRODUCT_RULE.getValue()) {
            Rule jsonRule = weightUtil.buildJsonRule(sortRule);
            /*JsonRule jsonRule = new JsonRule();
            jsonRule.setRule(productWeightRule);*/
            return jsonRule;
        }
        // 条件规则
        if (sortRule.getType() == SortTypeEnum.CONDITION_RULE.getValue()) {
            Rule rule = weightUtil.buildELRule(sortRule);
           /* SpringElRule rule = new SpringElRule();
            rule.setSortRule(sortRule);*/
            return rule;
        }
        return null;
    }
}
