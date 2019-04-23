package recommend.platform.spi.impl;
import org.apache.commons.lang3.StringUtils;
import recommend.platform.model.Context;
import recommend.platform.model.ScopeModule;
import recommend.platform.model.ScopeResponse;
import recommend.platform.spi.ScopeDataFactory;
import recommend.platform.spi.ScopeDataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: com.helijia.personalise.spi
 * @Description: 抽象工厂方法
 * @function:
 */
public class DefaultScopeDataFactory implements ScopeDataFactory {

    private Map<String, ScopeDataService> scopeDataServiceMap ;

    /**
     * 获取数据返回结果
     *
     * @param module
     * @return
     */
    @Override
    public ScopeResponse<?> getDatas(Context context, ScopeModule module) {
        Integer sourceFrom = module.getSourceFrom();
        //路由到实现
        ScopeDataService scopeDataService = scopeDataServiceMap.get("" + sourceFrom);

        return new  ScopeResponse();
    }


    public void setScopeDataServiceMap(Map<String, ScopeDataService> scopeDataServiceMap) {
        this.scopeDataServiceMap = scopeDataServiceMap;
    }
}
