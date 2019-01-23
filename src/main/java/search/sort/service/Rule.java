package search.sort.service;

import java.util.Map;

/**
 * @Package: search.sort.sort
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019/1/23.
 */
public interface Rule {

    /**
     * 计算权重
     * @param context 排序上下文
     * @return 权重值
     */
    int calculateWeight(RuleContext<?> context);

    /**
     * 规则是否排它
     * @return true or false
     */
    boolean isExclusived();

    /**
     * 规则是否匹配
     * @param context
     * @return
     */
    boolean isMatched(RuleContext<?> context);

}
