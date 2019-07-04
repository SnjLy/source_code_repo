package search.listenner.strategy;

/**
 * com.techwolf.oceanus.search.listenner.strategy
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
public interface StrategyService<T> {

    /**
     * 获取此事件的hash值，起分发作用
     * @param type
     * @param event
     * @return
     * @throws Exception
     */
    int hashIdByType(String type, T event)  throws Exception;

    /**
     * 处理此事件
     * @param type
     * @param event
     * @return
     * @throws Exception
     */
    int handleByType(String type, T event) throws Exception;

}
