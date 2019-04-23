package recommend.platform.spi.impl;

import org.springframework.stereotype.Service;
import recommend.platform.model.Context;
import recommend.platform.spi.ScopeRuleEngine;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-12.
 * @Package: com.helijia.personalise.spi.impl
 * @Description:
 * @function:
 */
@Service(value = "defaultScopeRuleEngine")
public class DefaultScopeRuleEngineImpl implements ScopeRuleEngine {

    /**
     * 返回用户当前上下文 是否匹配当前recConfig配置的条件
     *
     * @param expression
     * @param context
     * @return
     */
    @Override
    public boolean isMatch(String expression, Context context) {
        return true;
    }
}
