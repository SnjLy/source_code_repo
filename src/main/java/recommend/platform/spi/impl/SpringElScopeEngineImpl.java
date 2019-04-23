package recommend.platform.spi.impl;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
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
@Service(value = "springElScopeEngine")
public class SpringElScopeEngineImpl implements ScopeRuleEngine {

    public static Object execute(String expression, Context<?> context) {
        Expression expr = new SpelExpressionParser().parseRaw(expression);
        if (context == null) {
            return expr.getValue();
        }
        // 初始化root变量
        StandardEvaluationContext exprContext = new StandardEvaluationContext(context);
        exprContext.setVariables(context.getVariables());
        return expr.getValue(exprContext);
    }

    /**
     * 返回用户当前上下文 是否匹配当前recConfig配置的条件
     *
     * @param expression
     * @param context
     * @return
     */
    @Override
    public boolean isMatch(String expression, Context context) {
        Object result = execute(expression, context);
        return (Boolean) result;
    }



}
