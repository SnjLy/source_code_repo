package recommend.platform.spi;


import recommend.platform.model.Context;

/**
 * @Package: com.helijia.personalise.spi
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2019-04-04.
 */
public interface ScopeRuleEngine {

    /**
     * 返回用户当前上下文 是否匹配当前recConfig配置的条件
     * @param expression
     * @param context
     * @return
     */
    boolean isMatch(String expression, Context context);
}
