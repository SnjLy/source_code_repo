package recommend.platform.spi;

import java.util.Map;

/**
 * @author : LiuYong
 * Created by yehao on 2019-04-11.
 */
public interface ScopeDataService {

    /**
     * 获取加载 数据信息
     * @param dataType   数据类型 ${DataTypeEnum}
     * @param params  获取数据的参数
     */
    ScopeDataResult<?> loadData(Integer dataType, Map<String, Object> params);
}
