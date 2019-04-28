package com.hlframe.xhjq.test;

import com.hlframe.xhjq.utils.DateUtils;
import com.hlframe.xhjq.utils.EncodeUtils;
import com.hlframe.xhjq.utils.HttpClientUtils;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-14 09:37
 */
public class SubwayDataTest {
    // 统一认证方式 http://hzlw.maicedata.com/cdlapi/partner/{partner}/func/{func}?ts={timestamp}&sn={sn}&encode={encode}
    // 基础URL
    private static String baseURL = "http://hzlw.maicedata.com/cdlapi/partner/";
    // 合作单位编码
    private static String partner = null;
    // 请求数据方法
    private static String func = null;
    // 时间戳
    private static String timestamp = null;
    // 签名信息
    private static String sn = null;
    // 编码
    private static String encode = "base32";
    // 加密key
    private static String secretkey = "64bbde47635f39ec077f93a064e5d084";
    // 访问链接
    private static String URL = null;

    public static String jsonData(){
        String today = String.valueOf(Integer.parseInt(DateUtils.getDate()));
        partner = "subway";
        String tempFunc = "/cdl/object/tr_traffic_subway_flow?range_field=start_time&from="+ today +"T100000&to="+ today +"T100500&fields=name,entry_flow,exit_flow,start_time,end_time,business_day,stat_id&order=start_time-asc";
        // 临时func
        func = EncodeUtils.EncodeByURL(tempFunc);

        // base32加密
        func = EncodeUtils.EncodeByBase32(func);

        // 时间戳(秒)
        timestamp = DateUtils.geTimestampBys();

        // 临时sn
        String tempSn = partner + func + secretkey + timestamp;

        // Sn计算方式：md5(Partner+func+{secretkey}+timestamp)
        sn = EncodeUtils.EncodeByMD5(tempSn);
        encode = "base32";

        // 最终访问URL
        URL = baseURL + partner + "/func/" + func + "?ts=" + timestamp + "&sn=" + sn + "&encode=" + encode;
        System.out.println("URL = " + URL);

        return HttpClientUtils.getDataStr(URL);
    }

    public static String jsonData2(String date){
        partner = "subway";
        String tempFunc = "/cdl/object/tr_traffic_subway_flow?range_field=start_time&from="+ date +"T100000&to="+ date +"T100500&fields=name,entry_flow,exit_flow,start_time,end_time,business_day,stat_id&order=start_time-asc";
        // 临时func
        func = EncodeUtils.EncodeByURL(tempFunc);

        // base32加密
        func = EncodeUtils.EncodeByBase32(func);

        // 时间戳(秒)
        timestamp = DateUtils.geTimestampBys();

        // 临时sn
        String tempSn = partner + func + secretkey + timestamp;

        // Sn计算方式：md5(Partner+func+{secretkey}+timestamp)
        sn = EncodeUtils.EncodeByMD5(tempSn);
        encode = "base32";

        // 最终访问URL
        URL = baseURL + partner + "/func/" + func + "?ts=" + timestamp + "&sn=" + sn + "&encode=" + encode;
        System.out.println("URL = " + URL);

        return HttpClientUtils.getDataStr(URL);
    }

    public static String jsonDataRealTime(){
        String today = String.valueOf(Integer.parseInt(DateUtils.getDate()));
        partner = "subway";
        String tempFunc = "/cdl/object/tr_traffic_subway_flow?range_field=start_time&from="+ today +"T100000&to="+ today +"T100500&fields=name,entry_flow,exit_flow,start_time,end_time,business_day,stat_id&order=start_time-asc";
        // 临时func
        func = EncodeUtils.EncodeByURL(tempFunc);

        // base32加密
        func = EncodeUtils.EncodeByBase32(func);

        // 时间戳(秒)
        timestamp = DateUtils.geTimestampBys();

        // 临时sn
        String tempSn = partner + func + secretkey + timestamp;

        // Sn计算方式：md5(Partner+func+{secretkey}+timestamp)
        sn = EncodeUtils.EncodeByMD5(tempSn);
        encode = "base32";

        // 最终访问URL
        URL = baseURL + partner + "/func/" + func + "?ts=" + timestamp + "&sn=" + sn + "&encode=" + encode;
        System.out.println("URL = " + URL);

        return HttpClientUtils.getDataStr(URL);
    }
}
