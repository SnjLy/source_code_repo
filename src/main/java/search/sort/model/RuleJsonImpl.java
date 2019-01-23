package search.sort.model;

import search.sort.service.Rule;
import search.sort.service.RuleContext;

/**
 * @Package: search.sort.model
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public class RuleJsonImpl implements Rule {

    /**
     * 计算权重
     *
     * @param context 排序上下文
     * @return 权重值
     */
    @Override
    public int calculateWeight(RuleContext<?> context) {
        return 1000;
    }

    /**
     * 规则是否排它
     *
     * @return true or false
     */
    @Override
    public boolean isExclusived() {
        return true;
    }

    /**
     * 规则是否匹配
     *
     * @param context
     * @return
     */
    @Override
    public boolean isMatched(RuleContext<?> context) {
        return true;
    }
}
