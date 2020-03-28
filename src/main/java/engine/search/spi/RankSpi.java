package engine.search.spi;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search.spi
 */
public interface RankSpi<Req, Resp> {

    /**
     * 进行重排序
     * @param req
     * @param resp
     */
    void rankRecall(Req req, Resp resp);

}
