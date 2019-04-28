package com.hlframe.xhjq.other;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-12 19:45
 */
public class HttpClientUtil {
    public static void main(String[] args) throws IOException {
        String  url ="http://125.210.121.164:8081/hzbs-autho/auth/login";
        String indexUrl ="http://125.210.121.164:8081/hzbs-autho/auth/index";
        String dataUrl = "http://125.210.121.164:8081/hzbs-web/detail/table";
        HttpClient httpclient = new DefaultHttpClient();



        HttpGet httpget = new HttpGet("http://125.210.121.164:8081/hzbs-autho/auth/login");
        HttpResponse response1= httpclient.execute(httpget);
        HttpEntity entity = response1.getEntity();
        System.out.println("Login form get: " + response1.getStatusLine());
        EntityUtils.consume(entity);


        System.out.println("Initial set of cookies:");
        List<Cookie> cookies = ((DefaultHttpClient) httpclient).getCookieStore().getCookies();
        if (cookies.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("- " + cookies.get(i).toString());
            }
        }




        HttpPost httpost = new HttpPost(url); // 登录url
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("username", "wanyy"));
        nvp.add(new BasicNameValuePair("password", "abc123"));
        httpost.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpost.setHeader("Accept-Encoding","gzip, deflate");
        httpost.setHeader("Accept-Language","zh-CN,zh;q=0.9");
        httpost.setHeader("Cache-Control","max-age=0");
        httpost.setHeader("Connection","keep-alive");
//        httpost.setHeader("Content-Length","52");
        httpost.setHeader("Content-Type","application/x-www-form-urlencoded");
        httpost.setHeader("AHost","25.210.121.164:8081");
        httpost.setHeader("Origin","http://125.210.121.164:8081");
        httpost.setHeader("Referer","http://125.210.121.164:8081/hzbs-autho/auth/login");
        httpost.setHeader("Upgrade-Insecure-Requests","1");
        httpost.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        httpost.setHeader("cookie",cookies.get(0).toString());
        String sCharSet = "utf-8";
        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvp, sCharSet));
            HttpResponse response = httpclient.execute(httpost);
            String str = EntityUtils.toString(response.getEntity()); // post请求成功后的返回值
            String cookie = response.getLastHeader("Set-Cookie").getValue(); // 获取cookie值
            //HttpGet httpGet = new HttpGet("http://125.210.121.164:8081/hzbs-web/data/areaData?radio=raday&stdate=2018-12-05&eddate=2018-12-11&currentPage=1&pageSize=10");
            HttpGet httpGet = new HttpGet(indexUrl);
            HttpResponse response0 = httpclient.execute(httpGet);
            String htmkStr=EntityUtils.toString(response0.getEntity());
            System.out.println(htmkStr);
            String token =HttpClientLogin.match(htmkStr,"").get(0);

            HttpGet getMethod = new HttpGet("http://125.210.121.164:8081/hzbs-web/data/areaData?radio=raday&stdate=2018-12-05&eddate=2018-12-11&currentPage=1&pageSize=10");
            getMethod.setHeader("cookie",cookie);
            getMethod.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
            getMethod.setHeader("Accept-Encoding","gzip, deflate");
            getMethod.setHeader("Accept-Language","zh-CN,zh;q=0.9");
            getMethod.setHeader("Cache-Control","max-age=0");
            getMethod.setHeader("Connection","keep-alive");

            getMethod.setHeader("Cookie", cookie); // 设置之前获取到的cookie
            getMethod.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            getMethod.setHeader("Host","125.210.121.164:8081");
            getMethod.setHeader("Origin","http://125.210.121.164:8081");
            getMethod.setHeader("Referer","http://125.210.121.164:8081/hzbs-web/data/allShow?token="+token+"&userId=201");
            getMethod.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
            HttpResponse response3 = httpclient.execute(getMethod);




            HttpPost httpost2 = new HttpPost(dataUrl);
            httpost2.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
            httpost2.setHeader("Accept-Encoding","gzip, deflate");
            httpost2.setHeader("Accept-Language","zh-CN,zh;q=0.9");
            httpost2.setHeader("Cache-Control","max-age=0");
            httpost2.setHeader("Connection","keep-alive");

            httpost2.setHeader("Cookie", cookie); // 设置之前获取到的cookie
            httpost2.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost2.setHeader("Host","125.210.121.164:8081");
            httpost2.setHeader("Origin","http://125.210.121.164:8081");
            httpost2.setHeader("Referer","http://125.210.121.164:8081/hzbs-web/data/allShow?token="+token+"&userId=201");
            httpost2.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");


            // request payload
            String jsonString = "" ;
            StringEntity entity2 = new StringEntity(jsonString); // 一般是json字符串
            httpost2.setEntity(entity2);

            HttpResponse response2 = httpclient.execute(httpost2);
            String str11 = EntityUtils.toString(response2.getEntity());
            System.out.println(response2.getStatusLine().getStatusCode()+" :"+str11);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
