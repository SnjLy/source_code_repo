package recommend.platform.spi;


import recommend.platform.model.ScopeRequest;
import recommend.platform.model.ScopeResponse;

/**
 * @Package: com.helijia.search.recommend.service
 * @Description: 声明个性化接口，由不同的策略实现不同的推荐逻辑
 * @function:
 * @author : LiuYong
 * Created by yehao on 2019-04-04.
 */
public interface PersonaliseService {

    /**
     * 实现各个场景推荐和配置的不同策略
     *
     * @param request
     * @return
     */
    ScopeResponse personaliseDatas(ScopeRequest request);

}
