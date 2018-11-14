package create.sql;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/11/2.
 */
public class SqlCreator515 {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        SqlCreator515 s = new SqlCreator515();

        List<Stock> list = s.getStockList();
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO `activity_hour_coupon_stock` (`activity_date`, `activity_hour`, `coupon_code`, `coupon_name`, `coupon_from`, `coupon_to`, `city_code`, `stock`, `received_count`, `is_del`, `create_time`, `update_time`) VALUES");

        int i = 0;
        System.out.println(list.size());
        for (Stock stock: list
             ) {
            if(list.size() - 1 == i){
                String sql = s.getSql(stock);
                sb.append(sql);
                sb.append("\n");

            }else{
                String sql = s.getSql(stock);
                sb.append(sql);
                sb.append(",");
                sb.append("\n");
            }
            i ++;
        }
        sb.append("on duplicate key update stock=values(stock)");
        sb.append(";");

        BufferedWriter out = null;
        try {
            String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            File file = new File("C:/Users/admin/Desktop/createSql_"+ time+".sql");
            if (file.exists()){
                file.delete();
                file.createNewFile();
            }
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(sb + "\r\n");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }



    public String getSql(Stock stock){
        StringBuffer sb =  new StringBuffer();
        sb.append("(");
        sb.append("'" + stock.getDate() + "', " + stock.getHour() + ", '" + stock.getCouponCode() + "', '"
                + stock.getCouponName() + "', " + stock.getCouponFrom() + ", " + stock.getCouponTo() + ", '"
                + stock.getCityCode() + "', " + stock.getStock() + ",");
        sb.append("0, 0, now(), now())");

        return sb.toString();
    }

    public List<Stock> getStockList() {
        List<Stock> stockList = new ArrayList<>();

        //5-7号
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 5));
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE), 4));
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWENTY), 3));
        //上海
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 4));
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        //深圳
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 3));
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        //杭州 广州
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.GUANGZHOU),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 3));
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.GUANGZHOU),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE), 2));
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.GUANGZHOU),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWENTY), 1));


        //成都、武汉、南京、天津
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU, City.WUHAN, City.NANJING, City.TIANJIN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU, City.WUHAN, City.NANJING, City.TIANJIN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                2));
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU, City.WUHAN, City.NANJING, City.TIANJIN),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));

        //重庆、西安
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE), 1));
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWENTY), 0));
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D9,DAY.D10,DAY.D11,DAY.D12,DAY.D13,DAY.D14),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));


        //515
        //beijing
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 5));
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 4));

        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 4));
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 3));

        //上海
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 1));
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 2));

        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 4));
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 3));
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        //深圳
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 1));
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 2));
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 3));
        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        //杭州
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 3));
        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        //广州
        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 3));
        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 2));
        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 2));

        //成都
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                2));
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE),
                1));
        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY),
                2));

        //武汉、南京
        stockList.addAll(getStockList(Arrays.asList(City.WUHAN, City.NANJING),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));
        stockList.addAll(getStockList(Arrays.asList(City.WUHAN, City.NANJING),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                2));
        stockList.addAll(getStockList(Arrays.asList(City.WUHAN, City.NANJING),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));

        //天津
        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));
        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE),
                2));
        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY),
                1));
        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY),
                1));

        //重庆、西安
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE), 1));
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG515VIP ),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWENTY), 0));
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.MEIRONG515VIP, Coupon.MEIJIA515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));
        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.XIAN),
                Arrays.asList(Coupon.MANJIAN515VIP),
                Arrays.asList(DAY.D15),
                Arrays.asList(Hour.TWLVLE, Hour.TWENTY), 1));


        return stockList;
    }


    public List<Stock> getStockList(List<City> cityList, List<Coupon> couponList, List<DAY> dayList, List<Hour> hourList, int stock) {
        List<Stock> stockList = new ArrayList<>();

        for(DAY day: dayList){
            for(City city: cityList){
               for(Hour hour: hourList){
                    for(Coupon coupon: couponList){
                        stockList.add(new Stock(city, coupon, day, hour, stock));
                    }
                }
            }
        }
        return stockList;
    }

    enum DAY{
        D4("2017-05-04", "4号"),
        D5("2017-05-05", "5号"),
        D7("2017-05-07", "7号"),
        D8("2017-05-08", "8号"),
        D9("2017-05-09", "9号"),
        D10("2017-05-10", "10号"),
        D11("2017-05-11", "11号"),
        D12("2017-05-12", "12号"),
        D13("2017-05-13", "13号"),
        D14("2017-05-14", "14号"),
        D15("2017-05-15", "15号"),
        ;

        DAY(String date, String name) {
            this.date = date;
            this.name = name;
        }

        private String date;
        private String name;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    enum Hour{
        TWLVLE(12),
        TWENTY(20),
        ;
        Hour(int hour) {
            this.hour = hour;
        }

        private int hour;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }
    }

    enum Coupon{
        TONGYONG515VIP("2017_0515_tongyong_51_5_vip", "[515专享]51.5元无门槛劵"),
        MEIRONG515VIP("2017_0515_meirong_20_vip", "[515专享]20元美容劵"),
        MEIJIA515VIP("2017_0515_miejia_20_vip", "[515专享]20元美甲劵"),
        MANJIAN515VIP("2017_0515_manjian_100_vip", "[515专享]100元优惠劵"),
        ;

        Coupon(String code, String name) {
            this.code = code;
            this.name = name;
        }

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    enum City{

        BEIJING("110100", "北京市"),
        TIANJIN("120100", "天津市"),
        SHANGHAI("310100", "上海市"),
        NANJING("320100", "南京市"),
        WUHAN("420100", "武汉市"),
        HANGZHOU("330100", "杭州市"),
        GUANGZHOU("440100", "广州市"),
        SHENZHEN("440300", "深圳市"),
        CHONGQING("500100", "重庆市"),
        CHENGDU("510100", "成都市"),
        XIAN("610100", "西安市"),
        ;

        City(String cityCode, String cityName) {
            this.cityCode = cityCode;
            this.cityName = cityName;
        }

        private String cityCode;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        private String cityName;

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }
    }

    class Stock{

        public Stock(City city, Coupon coupon, DAY day, Hour hour, int stock) {
            this.date = day.getDate();
            this.hour = hour.getHour();
            this.couponCode = coupon.getCode();
            this.couponName = coupon.getName();
            this.cityCode = city.getCityCode();
            this.stock = stock;
        }

        public Stock(String date, int hour, String couponCode, String couponName, String cityCode, int stock) {
            this.date = date;
            this.hour = hour;
            this.couponCode = couponCode;
            this.couponName = couponName;
            this.cityCode = cityCode;
            this.stock = stock;
        }

        private String date;
        private int hour;
        private String couponCode;
        private String couponName;
        private int couponFrom = 1;
        private int couponTo = 0;
        private String cityCode;
        private int stock;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getCouponName() {
            return couponName;
        }

        public void setCouponName(String couponName) {
            this.couponName = couponName;
        }

        public int getCouponFrom() {
            return couponFrom;
        }

        public void setCouponFrom(int couponFrom) {
            this.couponFrom = couponFrom;
        }

        public int getCouponTo() {
            return couponTo;
        }

        public void setCouponTo(int couponTo) {
            this.couponTo = couponTo;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
    }
}
