package search.listenner.strategy;

/**
 * com.techwolf.oceanus.search.listenner.strategy
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
public interface ScopeStrategy<T> {


    /**
     * 获取事件的hash值
     * @param event
     * @return
     * @throws Exception
     */
    abstract int hashID(T event) throws Exception;

    /**
     * 处理时间的具体策略
     * @param event
     * @throws Exception
     */
    abstract void handle(T event) throws Exception;
}
