package algorithm.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : LiuYong at 1/29/21
 * @package: com.techwolf.oceanus.moss.search.controller
 */
public class RedPacket {

    //最小金额 与剩余金额， 最大金额数= 平均金额？
    public static double min = 0.01d;
    //假设多可以领取平均值的n倍。这个值理论上可以调整策略
    public static int n = 3;

    public static void main(String[] args){
        Double totalMoney = 100d;
        int personNum = 10;
        //对每个人随机一分金额
        for (int i = 0; i < 10; i++) {
            List<Double> pm = new ArrayList<>();
            redPacket(personNum, totalMoney, pm);
            System.out.println(pm);
        }
    }

    public static void redPacket(Integer personNum, Double money, List<Double> list){
        if(1==personNum){
            //就是money.
            list.add(money);
            return;
        }
        int num = personNum;
        //每个人的金额要求 (min, max),
        BigDecimal remain = new BigDecimal(money);
        BigDecimal money1 = getMoney(min, num, remain);
        list.add(money1.doubleValue());
        //减去已经抽的金额和人数。 剩下的人分
        num--;
        remain = new BigDecimal(money+"").subtract(money1);
        redPacket(num, remain.doubleValue(), list);
    }


    public static BigDecimal getMoney(double min, int num, BigDecimal remain){
        int n = 3;
        BigDecimal maxBig = new BigDecimal(n).multiply(remain).divide(new BigDecimal(num), RoundingMode.HALF_UP);
        Random r = new Random();
        BigDecimal money = maxBig.multiply(new BigDecimal(r.nextDouble()+"")).setScale(2, RoundingMode.HALF_UP);
        boolean match = isMatch(money.doubleValue(), min, remain.doubleValue());
        while (!match){
            money = maxBig.multiply(new BigDecimal(r.nextDouble()+"")).setScale(2, RoundingMode.HALF_UP);
            match = isMatch(money.doubleValue(), min, remain.doubleValue());
        }
        return money;
    }

    /**
     * 判断当前红包是否合理
     **/
    public static boolean isMatch(Double money, double min, double max){
        if(money < min){
            return false;
        }
        if(money >max){
            return false;
        }
        return true;
    }

}
