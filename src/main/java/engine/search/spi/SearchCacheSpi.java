package engine.search.spi;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search.spi
 */
public interface SearchCacheSpi<Req, Resp>  {

    void saveCache(Req req, Resp resp);


    void fromCache(Req req, Resp resp);

}
