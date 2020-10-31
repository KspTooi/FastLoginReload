package com.ksptooi.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间小工具
 */
public class DateUtil {


    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 获取当前日期字符串
     * @return 日期字符串
     */
    public static String getTimeString(){
        return formatter.format(new Date());
    }

    /**
     * 解析日期字符串
     * @param timeString
     * @return
     */
    public static Date parser(String timeString){

        Date parse = null;

        try{
            formatter.parse(timeString);
            return parse;
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }



}
