package engine.search.service;

import engine.search.spi.SearchDslSpi;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search.service
 */
public class JobSearchDslService implements SearchDslSpi {

    /**
     * 构建场景特有的dsl
     *
     * @param object       原始请求
     * @param queryBuilder esBuilder
     */
    @Override
    public void buildDsl(Object object, SearchRequestBuilder queryBuilder) {

    }

    /**
     * 场景结果处理
     *
     * @param searchResponse 召回结果
     * @param object         原始请求
     * @param object2        请求返回实体
     */
    @Override
    public void buildResult(SearchResponse searchResponse, Object object, Object object2) {

    }
}
