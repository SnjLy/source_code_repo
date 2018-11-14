package algorithm.bloomfilter;

import java.io.*;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: ansj.snsj_seg
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/10/26.
 */
public class MyBloomFilter implements Serializable {
    private int[] seeds;
    private int size;
    private BitSet bitSet;
    private MisjudgmentRate rate;
    private int dataCount ;
    private AtomicInteger userCount = new AtomicInteger(0);
    /**
     * 自动清除比例，达到多少比例之后就自动清空重新使用
     */
    private Double autoClearRate;


    /**
     * 默认中等程度的误判率，以及不自动清空数据(性能少许提升)
     * @param dataCount 预期处理的数据规模，如预期用于处理1百万数据的查重，这里则填写1000000
     */
    public MyBloomFilter(int dataCount) {
        this(MisjudgmentRate.MIDDLE, dataCount, null);
    }

    /**
     * @param rate 枚举类型的误判率，默认中等程度的误判，每个字符串分配16个位
     * @param dataCount  预期处理的数据规模，如预期用于处理1百万数据的查重，这里则填写1000000
     * @param autoClearRate  自动清空过滤器内部信息的使用比率，传null则表示不会自动清理，
     *            当过滤器使用率达到100%时，则无论传入什么数据，都会认为在数据已经存在了
     *            当希望过滤器使用率达到80%时自动清空重新使用，则传入0.8

     */
    public MyBloomFilter(MisjudgmentRate rate, int dataCount, Double autoClearRate) {
        long bitSize = rate.getSeeds().length * dataCount;
        if (bitSize < 0 || bitSize>Integer.MAX_VALUE){
            throw new RuntimeException("位数太大了，请降低误判率或者数据量");
        }
        this.rate = rate;
        this.dataCount = dataCount;
        seeds = rate.getSeeds();
        size = (int)bitSize;
        bitSet = new BitSet(size);
        this.autoClearRate = autoClearRate;
    }

    public void add(String data){
        checkNeedClear();

        for (int seed : seeds) {
            int index = hash(data, seed);
            setTrue(index);
        }
    }

    public void setTrue(int index){
        userCount.incrementAndGet();
        bitSet.set(index, true);
    }

    public int hash(String data, int seeds){
        char[] value = data.toCharArray();
        int hash = 0;
        if (value.length > 0){
            for (int i = 0; i < value.length; i++) {
                hash = i * hash + value[i];
            }
        }
        hash = hash * seeds % size;
        //防止数据溢出成负数
        return Math.abs(hash);
    }


    /**
     * 判断数据是否存在
     * @param data
     * @return
     */
    public boolean checkExist(String data){
        for (int seed : seeds){
            int index = hash(data, seed);
            //seeds.length位在bitSet中只要有一个为0， 就不存在， 全为true不一定真的存在，可能有误判
            if (!bitSet.get(index)){
                return false;
            }
        }
        return true;
    }

    /**
     * 添加数据data
     * @param data
     * @return  如果已经存在，返回true, 如果不存在返回false并加入
     */
    public boolean addIfNotExist(String data){
        checkNeedClear();

        int[] indexs = new int[seeds.length];
        //先假定存在
        boolean exist = true;
        int index;
        for (int i = 0; i < seeds.length; i++) {
            indexs[i] = index = hash(data, seeds[i]);
            if (exist){
                //如果验证发现不存在
                if (!bitSet.get(index)){
                    exist = false;
                    for (int idx : indexs) {
                        //补充data数据的前i个数据信息
                        setTrue(idx);
                    }
                }
            }else{
                setTrue(index);
            }
        }
        return exist;
    }


    /**
     * 判断是否需要自动清除
     */
    private void checkNeedClear(){
        if (autoClearRate != null){
            if (getUseRate() >=autoClearRate){
                synchronized (this){
                    //double check
                    if (getUseRate() >= autoClearRate){
                        clear();
                    }
                }
            }
        }
    }

    /**
     * 获取当前使用率
     * @return
     */
    public double getUseRate(){
        return (double)userCount.intValue() / (double) size;
    }

    /**
     * 清空bitSet
     */
    public void clear(){
        userCount.set(0);
        bitSet.clear();
    }

    public MisjudgmentRate getRate() {
        return rate;
    }

    /**
     * 写入文件，保证高可用
     * @param path
     */
    public void saveFilterToFile(String path) {
        File file = new File(path);
        if (file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从文件加载之前的过滤器
     * @param path
     * @return
     */
    public static MyBloomFilter readFilterFromFile(String path){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
           return (MyBloomFilter) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        String path = "/tmp/logs/bloom.txt";
        MyBloomFilter fileter = new MyBloomFilter(7);
        System.out.println(fileter.addIfNotExist("1111111111111"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray().toString());
        System.out.println(fileter.addIfNotExist("2222222222222222"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray().toString());
        System.out.println(fileter.addIfNotExist("3333333333333333"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray());
        System.out.println(fileter.addIfNotExist("444444444444444"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray());
        System.out.println(fileter.addIfNotExist("5555555555555"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray());
        System.out.println(fileter.addIfNotExist("6666666666666"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray());
        System.out.println(fileter.addIfNotExist("1111111111111"));
        System.out.println("bitSet:" + fileter.bitSet.toByteArray());
        fileter.saveFilterToFile(path);
        fileter = readFilterFromFile(path);
        System.out.println(fileter.getUseRate());
        System.out.println(fileter.addIfNotExist("1111111111111"));
    }


}
/**
 * hash种子的位数，分配的位数越多，误判率越低但是越占内存
 *
 * 4个位误判率大概是0.14689159766308
 *
 * 8个位误判率大概是0.02157714146322
 *
 * 16个位误判率大概是0.00046557303372
 *
 * 32个位误判率大概是0.00000021167340
 *
 */
enum MisjudgmentRate{
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

    MisjudgmentRate(int[] seeds) {
        this.seeds = seeds;
    }

    public int[] getSeeds() {
        return seeds;
    }

    public void setSeeds(int[] seeds) {
        this.seeds = seeds;
    }
}
