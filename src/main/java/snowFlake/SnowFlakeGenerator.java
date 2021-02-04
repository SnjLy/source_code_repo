package snowFlake;

/**
 * @author: Perkins
 * @date: 2019-08-26
 * @description: todo
 */

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SnowFlakeGenerator {
    /**
     * 长度15
     */
    private static final int TOTAL_BITS = 53;
    /**
     * 毫秒级时间戳，可以用(2^41-1)/(1000*60*60*24*365)=69.7年，即2015+69.7=2084年
     */
    private static final int EPOCH_BITS = 41;
    /**
     * 最大31台，0-31一共32台
     */
    private static final int NODE_ID_BITS = 5;
    /**
     * 每毫秒自增最大127，0-127，一共128个
     */
    private static final int SEQUENCE_BITS = 7;

    /**
     * 最大节点
     * 移位算法可以很快的计算出几位二进制数所能表示的最大十进制数
     */
    private static final int maxNodeId = (int) (~(-1L << NODE_ID_BITS));
    /**
     * 最大自增数
     */
    private static final int maxSequence = (int) (~(-1L << SEQUENCE_BITS));

    /**
     * 偏移量，增大可用时间大概2015-1970=45年
     * 开始时间，2015-01-01T00:00:00Z
     */
    private static final long CUSTOM_EPOCH = 1420070400000L;

    /**
     * 当前节点
     */
    private volatile int nodeId;

    /**
     * 最后时间戳
     */
    private volatile long lastTimestamp = -1L;
    /**
     * 当前id，每次均+1
     */
    private volatile int sequence = 0;

    /**
     * 时间戳左移，空出节点和序列号位
     */
    private int EPOCH_SHIFT = TOTAL_BITS - EPOCH_BITS;
    /**
     * 节点位左移，空出序列号位
     */
    private int NODE_ID_SHIFT = TOTAL_BITS - EPOCH_BITS - NODE_ID_BITS;

    /**
     * 主动设置节点
     *
     * @param nodeId
     */
    public SnowFlakeGenerator(int nodeId) {
        if (nodeId < 0 || nodeId > maxNodeId) {
            throw new IllegalArgumentException(String.format("NodeId must be between %d and %d", 0, maxNodeId));
        }
        this.nodeId = nodeId;
    }

    /**
     * 生成节点默认id
     */
    public SnowFlakeGenerator() {
        this.nodeId = createNodeId();
    }

    /**
     * 获取下一个id
     *
     * @return
     */
    public synchronized long nextId() {
        //当前时间戳
        long currentTimestamp = timestamp();

        //出现时间回拨
        if (currentTimestamp < lastTimestamp) {
            //换个节点
            nodeId = createNodeId(true);
        }

        //当前轮
        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) {
                //id用完，等下一毫秒
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            //每轮开始
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        //时间戳左移8位，即乘以2的8次方
        long id = currentTimestamp << EPOCH_SHIFT;
        //节点id左移3位，或运算拼id到一起
        id |= nodeId << NODE_ID_SHIFT;
        //或运算拼id到一起
        id |= sequence;
        //41bits|5bits|7bits
        return id;
    }


    /**
     * 获取秒
     *
     * @return
     */
    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    private int createNodeId() {
        return createNodeId(false);
    }

    /**
     * 根据设备地址生成节点
     *
     * @return
     */
    private int createNodeId(boolean random) {
        int nodeId;
        try {
            if (random) {
                nodeId = (new SecureRandom().nextInt());
            } else {
                StringBuilder sb = new StringBuilder();
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();
                    byte[] mac = networkInterface.getHardwareAddress();
                    if (mac != null) {
                        for (int i = 0; i < mac.length; i++) {
                            sb.append(String.format("%02X", mac[i]));
                        }
                    }
                }

                //hash
                nodeId = sb.toString().hashCode();
                //取正数
                nodeId = Math.abs(nodeId);
            }
        } catch (Exception ex) {
            nodeId = (new SecureRandom().nextInt());
        }
        //取余
        nodeId = nodeId & maxNodeId;

        //随机不能重复
        if (random && nodeId == this.nodeId) {
            //重新随机
            nodeId = createNodeId(true);
        }
        return nodeId;
    }

    /**
     * 等一毫秒
     *
     * @param currentTimestamp
     * @return
     */
    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }

    public static void main(String[] args) {
        int maxNodeId = (int) (~(-1L << 5));
        String mac1 = "FA163E2359CC";
        String mac2 = "FA163E6FEF52";
        int i1 = mac1.hashCode() & maxNodeId;
        int i2 = mac2.hashCode() & maxNodeId;

        log.info((int) (~(-1L << NODE_ID_BITS)) + "");
        log.info((int) (~(-1L << SEQUENCE_BITS)) + "");


        SnowFlakeGenerator snowFlakeGenerator = new SnowFlakeGenerator();

        int a = 100;
        while (a > 0) {
            log.info(snowFlakeGenerator.nextId() + "");
            a--;
        }

        log.info(("" + snowFlakeGenerator.nextId()).length() + "");

        Stopwatch stopwatch = new Stopwatch().start();
        int count = 1000000;
        AtomicInteger num = new AtomicInteger(0);

        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {
                snowFlakeGenerator.nextId();
                num.incrementAndGet();

                if ((num.get() == (count - 1))) {
                    stopwatch.stop();
                    BigDecimal time = (new BigDecimal(stopwatch.elapsed(TimeUnit.MILLISECONDS))).divide(new BigDecimal(count));
                    log.info("elapsed:" + time);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            log.error("error", e);
        }
        //一千万,elapsed:0.0002621
        //一百万,elapsed:0.000277
        //十万,elapsed:0.00044
    }
}
