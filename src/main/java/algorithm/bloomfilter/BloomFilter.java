package algorithm.bloomfilter;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * bloomFilter
 * 算法里经常有时空权衡的问题，可以用空间换时间保存子问题结果，比如动态规划；可以用时间换空间，比如用泰勒展开计算三角函数。
 * 当时间和空间都不能牺牲的时候，就只能牺牲正确率了。Bloom Filter之所以称为概率数据结构，就是因为它的操作结果有一定概率是错误的。
 * 布隆过滤器只有FP，没有FN，即不会漏报，但是会有误报。当可以承受一些误报时，布隆过滤器比其它表示集合的数据结构有着很大的空间优势
 * 在计算机这个领域里，我们常常碰到时间换空间或空间换时间的情况，为了达到某一方面的性能，牺牲另外一方面。BloomFilter在时间和空间着两者之间引入了另外一个概念——错误率
 * 适用于一些黑名单
 * m bitSet K hash数
 */
public class BloomFilter {
    private final int[] seeds;
    private final int size;
    private final BitSet notebook;
    private final MisjudgmentRate rate;
    private final AtomicInteger useCount = new AtomicInteger(0);
    private final Double autoClearRate;

    /**
     * 默认中等程序的误判率：MisjudgmentRate.MIDDLE 以及不自动清空数据（性能会有少许提升）
     *
     * @param dataCount
     *            预期处理的数据规模，如预期用于处理1百万数据的查重，这里则填写1000000
     */
    public BloomFilter(int dataCount) {
        this(MisjudgmentRate.MIDDLE, dataCount, null);
    }

    /**
     *
     * @param rate
     *            一个枚举类型的误判率
     * @param dataCount
     *            预期处理的数据规模，如预期用于处理1百万数据的查重，这里则填写1000000
     * @param autoClearRate
     *            自动清空过滤器内部信息的使用比率，传null则表示不会自动清理，
     *            当过滤器使用率达到100%时，则无论传入什么数据，都会认为在数据已经存在了
     *            当希望过滤器使用率达到80%时自动清空重新使用，则传入0.8
     */
    public BloomFilter(MisjudgmentRate rate, int dataCount, Double autoClearRate) {
        long bitSize = rate.seeds.length * dataCount;
        if (bitSize < 0 || bitSize > Integer.MAX_VALUE) {
            throw new RuntimeException("位数太大溢出了，请降低误判率或者降低数据大小");
        }
        this.rate = rate;
        seeds = rate.seeds;
        size = (int) bitSize;
        notebook = new BitSet(size);
        this.autoClearRate = autoClearRate;
    }

    public void add(String data) {
        checkNeedClear();

        for (int i = 0; i < seeds.length; i++) {
            int index = hash(data, seeds[i]);
            setTrue(index);
        }
    }

    public boolean check(String data) {
        for (int i = 0; i < seeds.length; i++) {
            int index = hash(data, seeds[i]);
            if (!notebook.get(index)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 如果不存在就进行记录并返回false，如果存在了就返回true
     *
     * @param data
     * @return
     */
    public boolean addIfNotExist(String data) {
        checkNeedClear();

        int[] indexs = new int[seeds.length];
        // 先假定存在
        boolean exist = true;
        int index;

        for (int i = 0; i < seeds.length; i++) {
            indexs[i] = index = hash(data, seeds[i]);

            if (exist) {
                if (!notebook.get(index)) {
                    // 只要有一个不存在，就可以认为整个字符串都是第一次出现的
                    exist = false;
                    // 补充之前的信息
                    for (int j = 0; j <= i; j++) {
                        setTrue(indexs[j]);
                    }
                }
            } else {
                setTrue(index);
            }
        }

        return exist;

    }

    private void checkNeedClear() {
        if (autoClearRate != null) {
            if (getUseRate() >= autoClearRate) {
                synchronized (this) {
                    if (getUseRate() >= autoClearRate) {
                        notebook.clear();
                        useCount.set(0);
                    }
                }
            }
        }
    }

    public void setTrue(int index) {
        useCount.incrementAndGet();
        notebook.set(index, true);
    }

    private int hash(String data, int seeds) {
        char[] value = data.toCharArray();
        int hash = 0;
        if (value.length > 0) {

            for (int i = 0; i < value.length; i++) {
                hash = i * hash + value[i];
            }
        }

        hash = hash * seeds % size;
        // 防止溢出变成负数
        return Math.abs(hash);
    }

    public double getUseRate() {
        return (double) useCount.intValue() / (double) size;
    }


    /**
     * 清空过滤器中的记录信息
     */
    public void clear() {
        useCount.set(0);
        notebook.clear();
    }

    public MisjudgmentRate getRate() {
        return rate;
    }

    /**
     * 分配的位数越多，误判率越低但是越占内存
     *
     * 4个位误判率大概是0.14689159766308
     *
     * 8个位误判率大概是0.02157714146322
     *
     * 16个位误判率大概是0.00046557303372
     *
     * 32个位误判率大概是0.00000021167340
     *
     * @author cheqiancao
     *
     */
    public enum MisjudgmentRate {
        // 这里要选取质数，能很好的降低错误率
        /**
         * 每个字符串分配4个位
         */
        VERY_SMALL(new int[] { 2, 3, 5, 7 }),
        /**
         * 每个字符串分配8个位
         */
        SMALL(new int[] { 2, 3, 5, 7, 11, 13, 17, 19 }),
        /**
         * 每个字符串分配16个位
         */
        MIDDLE(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53 }),
        /**
         * 每个字符串分配32个位
         */
        HIGH(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101, 103, 107, 109, 113, 127, 131 });

        private int[] seeds;

        private MisjudgmentRate(int[] seeds) {
            this.seeds = seeds;
        }

        public int[] getSeeds() {
            return seeds;
        }

        public void setSeeds(int[] seeds) {
            this.seeds = seeds;
        }

    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(7);
        System.out.println(filter.addIfNotExist("1111111111111"));
        System.out.println(filter.getUseRate());
        System.out.println(filter.addIfNotExist("1111111111111"));
    }

}
