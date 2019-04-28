package com.hlframe.xhjq.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-19 11:51
 */
public class TranTimeStampUtils {

    /**
     * 日期转化为时间戳（单位：秒）
     * @param date
     * @return
     */
    public static long dateToTimeStamp(String date){
        //获取指定时间的时间戳，除以1000说明得到的是秒级别的时间戳（10位）
        long time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(date, new ParsePosition(0)).getTime() / 1000;
        System.out.println(time%5);
        return time;
    }

    public static void main(String[] args) {
        System.out.println(dateToTimeStamp("2019-03-19 16:10:00"));
    }
}
