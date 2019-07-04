package search.listenner.strategy;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

/**
 * com.techwolf.oceanus.search.listenner.strategy
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
@Service
public class JobCanalIndexStrategy implements ScopeStrategy<T> {


    public static String STRATEGY_TYPE = "canal-job-job";

    /**
     * 获取事件的hash值
     *
     * @param event
     * @return
     * @throws Exception
     */
    @Override
    public int hashID(T event) throws Exception {
        return 0;
    }

    /**
     * 处理时间的具体策略
     *
     * @param event
     * @throws Exception
     */
    @Override
    public void handle(T event) throws Exception {

    }
}
