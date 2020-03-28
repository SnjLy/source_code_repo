package engine.search.spi;

public interface SearchRecallSpi<Q, R> {

    /**
     * 实现接口，实现具体的召回逻辑
     * @param req   原始请求
     * @param resp  返回结果
     */
    void executeRecall(Q req, R resp, Context context);
}
