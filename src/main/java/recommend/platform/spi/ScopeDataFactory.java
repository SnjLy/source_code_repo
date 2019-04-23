package recommend.platform.spi;


import recommend.platform.model.Context;
import recommend.platform.model.ScopeModule;
import recommend.platform.model.ScopeResponse;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 * @Package: com.helijia.personalise.spi
 * @Description: 抽象工厂方法
 * @function:
 */
public interface ScopeDataFactory {

    /**
     * 获取数据返回结果
     * @param context 请求及用户上下文
     * @param module  参数和条件
     * @return
     */
     ScopeResponse<?> getDatas(Context context, ScopeModule module);

}
