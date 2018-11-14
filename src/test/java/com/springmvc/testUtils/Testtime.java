package com.springmvc.testUtils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.helpers.DateTimeDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: com.springmvc.testUtils
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/19.
 */
public class Testtime {

    public static void main(String[] args) {
        String time="2018-09-19 17:59:59";

        Date date=null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date=formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date();
        long expireTime = (date.getTime() - now.getTime())/1000 + 60;
        System.out.println(expireTime);
        System.out.println((expireTime-60)/60);
    }

}
