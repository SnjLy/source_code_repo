package cache;

import org.glassfish.jersey.internal.guava.CacheBuilder;
import org.glassfish.jersey.internal.guava.CacheLoader;
import org.glassfish.jersey.internal.guava.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: cache
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/9.
 */
public class GuavaCache{

    public static LoadingCache<String, Map<String, AtomicInteger>> cache = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Map<String, AtomicInteger>>() {
                @Override
                public Map<String, AtomicInteger> load(String key) throws Exception {
                    return buildAtomic(key);
                }

                private Map<String, AtomicInteger> buildAtomic(String key) {
                    Map<String, AtomicInteger> map = new HashMap<>(10);
                    map.put(key, new AtomicInteger(0));
                    return map;
                }
            });

    public static void main(String[] args) {
        try {
            Map<String, AtomicInteger> mm = GuavaCache.cache.get("1");
            System.out.println(mm.get("1"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
