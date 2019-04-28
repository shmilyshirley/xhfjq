package com.hlframe.xhjq.test;

import com.hlframe.xhjq.other.VirtualLogin;
import com.hlframe.xhjq.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-15 12:05
 */
public class DateTest {
    public static String getCurrentDate(){
        Calendar now = Calendar.getInstance();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }
    public static void main(String[] args) {
        String currentDate = DateUtils.getCurrentDate();
        System.out.println("currentDate = " + currentDate);
        VirtualLogin.getXhjqData();
    }
}
