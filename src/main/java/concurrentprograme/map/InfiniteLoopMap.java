package concurrentprograme.map;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/8/17.
 */
public class InfiniteLoopMap implements Runnable{
    private Map<Object, Object> map = new HashMap();
    private String key ;

    @Override
    public void run() {
        if (map.get(key) != null) {
            System.out.println(Thread.currentThread().getName() + "--" +
                               Thread.currentThread().getId() + " is get:" +
                               map.get(key));
        }
        System.out.println(Thread.currentThread().getName() + "--" +
                             Thread.currentThread().getId() + " is write");
        map.put(key, Thread.currentThread().getId());
    }

    public InfiniteLoopMap() throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put(new Integer(i), Integer.valueOf(i));
                }
                System.out.println("t1 over");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    map.put(new Integer(i),Integer.valueOf(i));
                }
                System.out.println("t2 over");
            }
        };
        Thread.sleep(200);
        t1.start();
        t2.start();
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(final Map<Object, Object> map) {
        this.map = map;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(200);
        InfiniteLoopMap infinite = new InfiniteLoopMap();
        for (int i =0;i<10;i++){
            infinite.setKey(i+"");
            new Thread(infinite).start();
            System.out.println(infinite.getMap().get(""+i));
        }
        Thread.sleep(200);
        System.out.println("write end-----------");
        System.out.println(JSON.toJSON(infinite.getMap()));
        infinite.getMap().get("hello"+1);
    }
}
