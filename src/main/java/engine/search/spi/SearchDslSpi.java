package engine.search.spi;


import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;

/**
 * @author : LiuYong at 2019-08-26
 * @package: com.techwolf.oecenus.moss.handler
 * @function:
 */
public interface SearchDslSpi<Req, Resp> {

    /**
     * 构建场景特有的dsl
     * @param req   原始请求
     * @param queryBuilder   esBuilder
     */
    void buildDsl(Req req, SearchRequestBuilder queryBuilder);

    /**
     * 场景结果处理
     * @param searchResponse  召回结果
     * @param req  原始请求
     * @param resp   请求返回实体
     */
    void buildResult(SearchResponse searchResponse, Req req, Resp resp);
}
