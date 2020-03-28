package engine.search.service;

import engine.search.AbstractSearch;
import org.elasticsearch.action.search.SearchRequestBuilder;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search.service
 */
public class JobSearchRecallService extends AbstractSearch<Object, Object> {

    /**
     * 参数校验
     *
     * @param object 原始参数
     * @return true 参数合法  false 参数不合法直接返回
     */
    @Override
    public boolean checkParams(Object object) {
        return false;
    }

    /**
     * @param object 原始参数
     * @return 根据参数生成的preference
     */
    @Override
    public String buildPreference(Object object) {
        return null;
    }

    /**
     * 构建自己场景的searchBuilder
     *
     * @param object 原始请求
     * @return elasticsearch查询的builder
     */
    @Override
    public SearchRequestBuilder searchRequest(Object object) {
        return null;
    }
}
