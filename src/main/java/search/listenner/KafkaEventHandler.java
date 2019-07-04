package search.listenner;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import search.listenner.strategy.StrategyService;

import java.util.concurrent.ExecutorService;

/**
 * com.techwolf.oceanus.search.listenner
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
@Service
@Slf4j
public class KafkaEventHandler extends AbstractEventHandler<T> {
    public static final String KAFKA_HANDLER = "kafka";


    public KafkaEventHandler(StrategyService<T> strategyHolder, ExecutorService indexExecutor) {
        super(strategyHolder, indexExecutor);
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(T event) {
        Object key = event.getClass().getName();
        String type = "";
        int hash = 0;
        try {
            hash = strategyHolder.hashIdByType(type, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            strategyHolder.handleByType(type, event);
        } catch (Exception e) {
            log.error("thread deal error,id:" + key, e);
        }
    }

}
