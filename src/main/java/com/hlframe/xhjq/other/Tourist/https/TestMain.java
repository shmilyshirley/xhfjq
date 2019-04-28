package com.hlframe.xhjq.other.Tourist.https;

import com.hlframe.xhjq.utils.DateUtils;
import com.hlframe.xhjq.utils.EncodeUtils;

import java.util.HashMap;
import java.util.Map;
/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-08 17:01
 */
//对接口进行测试
public class TestMain {
    private String url = "http://218.205.67.180:23003";
    private String charset = "utf-8";
    private HttpClientUtil httpClientUtil = null;

    public TestMain(){
        httpClientUtil = new HttpClientUtil();
    }

    public void test(){

        String nonce = "WScqanjCEAC4mQoBE07sAQ==";
        String created = DateUtils.getSpecialDate();
        String passwdDigest = EncodeUtils.EncodeByBase64(EncodeUtils.EncodeBySHA256(nonce+created+"xianghu_2016"));

        String httpOrgCreateTest = url + "httpOrg/create";
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("Authorization","App_key");
        createMap.put("Username","xianghu");
        createMap.put("PasswdDigest","passwdDigest");
        createMap.put("Nonce","WScqanjCEAC4mQoBE07sAQ==");
        createMap.put("Created","created");
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
        System.out.println("result:"+httpOrgCreateTestRtn);
    }

    public static void main(String[] args){
        TestMain main = new TestMain();
        main.test();
    }
}

