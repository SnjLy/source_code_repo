package sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2016/11/2.
 */
public class SqlCreator {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        SqlCreator s = new SqlCreator();

        java.util.List<Stock> list = s.getStockList();
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
        /**
         * 7号晚上的
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 42));

        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 44));

        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 27));

        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 34));


        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 10));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 10));

        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 12));

        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 3));

        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN, City.WUHAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 5));


        stockList.addAll(getStockList(Arrays.asList(City.NANJING),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.NANJING),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 3));

        stockList.addAll(getStockList(Arrays.asList(City.XIAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D7),
                Arrays.asList(Hour.EIGHTEEN), 3));

         **/

        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 40));

        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 42));

        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 44));

        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 27));

        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 30));

        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 34));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 12));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 10));

        stockList.addAll(getStockList(Arrays.asList(City.CHENGDU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 12));

        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 12));

        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 3));

        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 3));

        stockList.addAll(getStockList(Arrays.asList(City.TIANJIN),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.WUHAN),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.WUHAN),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.WUHAN),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.EIGHTEEN), 5));


        stockList.addAll(getStockList(Arrays.asList(City.NANJING),
                Arrays.asList(Coupon.TONGYONG),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 5));

        stockList.addAll(getStockList(Arrays.asList(City.NANJING),
                Arrays.asList(Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 3));

        stockList.addAll(getStockList(Arrays.asList(City.XIAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 3));


        //10 11
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 50));
        stockList.addAll(getStockList(Arrays.asList(City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 45));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU,City.CHENGDU,City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 12));

        stockList.addAll(getStockList(Arrays.asList(City.SHENZHEN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 15));

        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING,City.TIANJIN,City.WUHAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 8));

        stockList.addAll(getStockList(Arrays.asList(City.NANJING,City.XIAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 5));

        return stockList;
    }


    public List<Stock> getOldStockList() {
        List<Stock> stockList = new ArrayList<>();
        //4号
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING, City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D4),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 50));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.CHENGDU, City.SHENZHEN, City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D4),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 30));

        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.TIANJIN, City.WUHAN, City.NANJING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D4),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 15));

        //5号到九号
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING, City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D5, DAY.D6, DAY.D7, DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 20));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.CHENGDU, City.SHENZHEN, City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D5, DAY.D6, DAY.D7, DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 12));

        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.TIANJIN, City.WUHAN, City.NANJING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D5, DAY.D6, DAY.D7, DAY.D8, DAY.D9),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 8));

        //10、11
        stockList.addAll(getStockList(Arrays.asList(City.BEIJING, City.SHANGHAI),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 25));

        stockList.addAll(getStockList(Arrays.asList(City.HANGZHOU, City.CHENGDU, City.SHENZHEN, City.GUANGZHOU),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 20));

        stockList.addAll(getStockList(Arrays.asList(City.CHONGQING, City.TIANJIN, City.WUHAN, City.NANJING, City.XIAN),
                Arrays.asList(Coupon.TONGYONG, Coupon.MANJIAN),
                Arrays.asList(DAY.D10, DAY.D11),
                Arrays.asList(Hour.TEN, Hour.EIGHTEEN), 10));

        return stockList;
    }

    public List<Stock> getStockList(List<City> cityList, List<Coupon> couponList, List<DAY> dayList, List<Hour> hourList, int stock) {
        List<Stock> stockList = new ArrayList<>();

        for(DAY day: dayList){
            for(Hour hour: hourList){
                for(City city: cityList){
                    for(Coupon coupon: couponList){
                        stockList.add(new Stock(city, coupon, day, hour, stock));
                    }
                }
            }
        }
        return stockList;
    }

    enum DAY{
        D4("2016-11-04", "4号"),
        D5("2016-11-05", "5号"),
        D6("2016-11-06", "6号"),
        D7("2016-11-07", "7号"),
        D8("2016-11-08", "8号"),
        D9("2016-11-09", "9号"),
        D10("2016-11-10", "10号"),
        D11("2016-11-11", "11号"),
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
        TEN(10),
        EIGHTEEN(18),
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
        TONGYONG("2016_1111_wmk_20", "11.11专享无门槛券"),
        MANJIAN("2016_1111_majian_50", "11.11专享满减券"),
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
