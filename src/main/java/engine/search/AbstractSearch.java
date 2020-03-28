package engine.search;

import engine.search.spi.*;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search
 */
public abstract class AbstractSearch<Req, Resp> implements SearchRecallSpi<Req, Resp> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSearch.class);

    protected SearchDslSpi searchDslSpi;

    @Autowired
    private SearchProperties searchProperties;

    /**
     * 参数校验
     *
     * @param req 原始参数
     * @return true 参数合法  false 参数不合法直接返回
     */
    public abstract boolean checkParams(Req req);


    /**
     * @param req 原始参数
     * @return 根据参数生成的preference
     */
    public abstract String buildPreference(Req req);

    /**
     * 构建自己场景的searchBuilder
     *
     * @param req 原始请求
     * @return elasticsearch查询的builder
     */
    public abstract SearchRequestBuilder searchRequest(Req req);

    /**
     * 实现接口，实现具体的召回逻辑
     *
     * @param req     原始请求
     * @param resp    返回结果
     * @param context
     */
    @Override
    public void executeRecall(Req req, Resp resp, Context context) {
        boolean checkParams = this.checkParams(req);
        if (!checkParams) {
            return;
        }
        SearchRequestBuilder sr = this.searchRequest(req);
        searchDslSpi.buildDsl(req, sr);
        sr.setPreference(this.buildPreference(req));

        try {
            SearchResponse esResponse = sr.get(TimeValue.timeValueMillis(searchProperties.getTimeOut()));
            searchDslSpi.buildResult(esResponse, req, resp);
        } catch (Exception e) {
            LOGGER.warn("req:{} recall dsl:{} error:{}", req, sr.request(), e.getMessage());
        }

        //后续策略， todo 策略路由

    }
}
