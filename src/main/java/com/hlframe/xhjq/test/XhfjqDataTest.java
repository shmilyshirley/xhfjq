package com.hlframe.xhjq.test;

import com.hlframe.xhjq.utils.DateUtils;
import com.hlframe.xhjq.utils.EncodeUtils;
import com.hlframe.xhjq.utils.HttpClientUtils;
import org.apache.commons.codec.binary.Base32;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-09 09:37
 */
public class XhfjqDataTest {
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
    private static String secretkey = "237b7ab93e9e0fb18cf90369b9647787";
    // 访问链接
    private static String URL = null;

    public static String jsonData(){
        String yesterday = String.valueOf(Integer.parseInt(DateUtils.getDate())-1);
        partner = "xihufengjingqu";
        String tempFunc = "/cdl/object/v_tr_police_hotel_checkin?range_field=checkin_time&from="+ yesterday +"T150000&to="+ yesterday +"T160000&fields=serial_no,info.manage_name,hksx,gender,born_year,checkin_time,checkout_time&join=inner-join-tr_police_hotel_info-info-on-main.hotel_name=info.hotel_name&district=景区&order=checkin_time-asc&limit=400";
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
        String yesterday = String.valueOf(Integer.parseInt(DateUtils.getDate())-1);
        partner = "xihufengjingqu";
        String tempFunc = "/cdl/object/v_tr_police_hotel_checkin?range_field=checkin_time&from="+ yesterday +"T150000&to="+ yesterday +"T190000&fields=serial_no,info.manage_name,hksx,gender,born_year,checkin_time,checkout_time&join=inner-join-tr_police_hotel_info-info-on-main.hotel_name=info.hotel_name&district=景区&order=checkin_time-asc&limit=400";
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
        partner = "xihufengjingqu";
        String tempFunc = "/cdl/object/v_tr_police_hotel_checkin?range_field=checkin_time&from="+ date +"T150000&to="+ date +"T190000&fields=serial_no,info.manage_name,hksx,gender,born_year,checkin_time,checkout_time&join=inner-join-tr_police_hotel_info-info-on-main.hotel_name=info.hotel_name&district=景区&order=checkin_time-asc&limit=400";
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



