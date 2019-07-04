package search.listenner.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * com.techwolf.oceanus.search.listenner.strategy
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
@Slf4j
@Service
public class StrategyServiceImpl<T> implements StrategyService<T> {

    Map<String, ScopeStrategy<T>> strategyMap = new HashMap<>();

    @Autowired
    private ListableBeanFactory beanFactory;
    /**
     * 获取此事件的hash值，起分发作用
     *
     * @param type
     * @param event
     * @return
     * @throws Exception
     */
    @Override
    public int hashIdByType(String type, T event) throws Exception {
        int hashID = strategyMap.get(type).hashID(event);
        return hashID;
    }

    /**
     * 处理此事件
     *
     * @param type
     * @param event
     * @return
     * @throws Exception
     */
    @Override
    public int handleByType(String type, T event) throws Exception {
//        final ScopeStrategy<T> tScopeStrategy = strategyMap.get(type);
//        if (null == tScopeStrategy){
//            return -1;
//        }
//        tScopeStrategy.handle(event);
        CompletableFuture.supplyAsync(()-> strategyMap.get(type)).thenAccept((strategy)-> {
            try {
                strategy.handle(event);
            } catch (Exception e) {
                log.error("strategy handle event error", e);
            }
        }).exceptionally(throwable -> {
            log.error("strategy handleByType event error", throwable);
            return null;
        });
        return 1;
    }


    public void registerStrategy(String type, ScopeStrategy scopeStrategy) {
        strategyMap.put(type, scopeStrategy);
    }

    public ScopeStrategy getStrategy(String type) {
        return strategyMap.get(type);
    }

    @PostConstruct
    public void registry(){
        registerStrategy(JobCanalIndexStrategy.STRATEGY_TYPE, beanFactory.getBean(JobCanalIndexStrategy.class));
        registerStrategy(JobKafkaIndexStrategy.STRATEGY_TYPE, beanFactory.getBean(JobKafkaIndexStrategy.class));
    }

}
