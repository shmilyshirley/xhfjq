package com.hlframe.xhjq.other;

import com.hlframe.xhjq.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-15 13:34
 */
public class VirtualLogin {
    private static VirtualLogin virtualLogin = new VirtualLogin();
    public static String getXhjqData(){
        // 登陆时需要的请求地址
        String codeUrl = "http://www.dypopu.com/sys/sysUser/refreshCode.do";// 验证码请求地址
        String validationCodeUrl = "http://www.dypopu.com:80/sys/sysUser/validationCode.do";// 验证验证码的请求地址
        String loginUrl = "http://www.dypopu.com:80/sys/sysUser/login.do";// 登陆请求地址
        String mainUrl = "http://www.dypopu.com/show/showAll/showMainDt.do";// 获取主要数据的请求地址
        String code = HttpClientUtils.getCode(codeUrl);

        // 设置Header的参数（账号、密码、等参数信息）
        Map hashMap = new HashMap<String,String>();
        hashMap.put("account","xihu");
        hashMap.put("pwd","DsTtcsrBekMQ_nSxMxiaChhhu7k_d22fd07t1bS8n2!5k@68#sF");
        hashMap.put("code",code);
        hashMap.put("inputCode",code);
        hashMap.put("skin","no-skin");
        hashMap.put("clientWidth","1920");

        // 验证获取到的验证码
        HttpClientUtils.validationCode(validationCodeUrl,code);
        // 模拟登陆西湖景区系统
        HttpClientUtils.loginWeb(loginUrl,hashMap);
        // 开始获取数据的时间
        double l = System.currentTimeMillis();
        // 获取西湖景区游客行为系统页面上的主要数据
        String peoNum = HttpClientUtils.postData(mainUrl);
        // 结束获取数据的时间
        l = System.currentTimeMillis()-l;
        System.out.println("———————————耗时:"+l/1000+"s————————————");
        return peoNum;
    }

}
