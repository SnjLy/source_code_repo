package recommend.platform.spi;

import recommend.platform.model.Context;
import recommend.platform.model.ScopeRequest;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: com.helijia.personalise.spi
 * @Description:
 * @function:
 */
public interface ScopeContextService {

    /**
     * 根据请求参数构建上下文
     *
     * @param request
     * @return
     */
    Context buildContext(ScopeRequest request);
}
