package recommend.platform.spi.impl;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import recommend.platform.model.Context;
import recommend.platform.model.ScopeRequest;
import recommend.platform.model.ScopeResponse;
import recommend.platform.spi.PersonaliseService;
import recommend.platform.spi.ScopeContextService;
import recommend.platform.spi.ScopeDataFactory;
import recommend.platform.spi.ScopeRuleEngine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Package: com.helijia.search.recommend.service
 * @Description: 1. 接收请求参数 —— 共同点
 * 2. 封装请求参数 —— 共同点   web封装
 * 3. 实现场景对应的推荐逻辑  —— 变化点
 * 4. 从配置中获取配置数据 —— 依赖场景，逻辑相同
 * 5. 过滤逻辑    —— 变化点
 * 6. 补位、排序处理场景推荐结果 —— 各场景不同
 * 7. 返回推荐结果   —— 相同逻辑
 * @function:
 * @author : LiuYong
 * Created by yehao on 2019-04-08.
 */
@Service
public class DefaultPersonaliseServiceImpl implements PersonaliseService {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultPersonaliseServiceImpl.class);


    @Autowired
    private ScopeContextService scopeContextService;
    @Autowired
    @Qualifier("springElScopeEngine")
    private ScopeRuleEngine defaultScopeRuleEngine;

    @Autowired
    private ScopeDataFactory scopeDataFactory;


    /**
     * 实现各个场景推荐和配置的不同策略
     *
     * @param request
     * @return
     */
    @Override
    public ScopeResponse personaliseDatas(ScopeRequest request) {

        return new ScopeResponse();
    }

    private boolean matchConfigWithContext(String expression, Context context) {
        boolean match;
        if ( StringUtils.isBlank(expression)){
            return true;
        }
        try {
            match = defaultScopeRuleEngine.isMatch(expression, context);
            LOGGER.info("条件:{}, context:{}, result:{}", new Object[]{expression, JSON.toJSONString(context), match});
            return match;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
