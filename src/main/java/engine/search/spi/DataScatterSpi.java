package engine.search.spi;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search.spi
 */
public interface DataScatterSpi<Req, Resp> {


    /**
     * 进行数据打散
     * @param req
     * @param resp
     */
    void dataScatter(Req req, Resp resp);
}
