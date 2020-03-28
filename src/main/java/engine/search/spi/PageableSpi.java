package engine.search.spi;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search.spi
 */
public interface PageableSpi<Req, Resp> {

    /**
     * 数据分页
     * @param req
     * @param resp
     */
    void dealPageable(Req req, Resp resp);

}
