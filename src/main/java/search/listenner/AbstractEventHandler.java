package search.listenner;


import search.listenner.strategy.StrategyService;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

/**
 * com.techwolf.oceanus.search.listenner
 *
 * @author: SNJly
 * @date: 2019-06-27
 */
public abstract class AbstractEventHandler<T> implements Consumer<T> {

    protected StrategyService<T> strategyHolder;

    protected ExecutorService indexExecutor;


    public AbstractEventHandler(StrategyService<T> strategyHolder, ExecutorService indexExecutor) {
        this.strategyHolder = strategyHolder;
        this.indexExecutor = indexExecutor;
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    @Override
    public void accept(T t) {
        try {
            handle(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public abstract void handle(T data) throws Exception;
}
