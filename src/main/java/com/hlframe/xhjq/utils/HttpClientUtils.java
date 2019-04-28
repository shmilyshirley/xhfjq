package com.hlframe.xhjq.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-14 09:53
 */
public class HttpClientUtils {

    private static HttpClient httpClient = new DefaultHttpClient();
    private static String code;
    private static HttpClientUtils httpClientUtils = new HttpClientUtils();

    public static HttpClientUtils getHttpClientUtils(){
        return httpClientUtils;
    }

    public HttpClientUtils() {
    }

    public HttpClientUtils(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * 获取简易验证码
     *
     * @return
     */
    public static String getCode(String codeUrl) {
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(codeUrl);
            httpPost.setHeader("Accept", "*/*");
            httpPost.setHeader("Content-Type", "text/plain;charset=UTF-8");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 302 || httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = httpResponse.getEntity();
                code = EntityUtils.toString(entity, "UTF-8");

                System.out.println("》》》》》》获取验证码成功《《《《《《");
                System.out.println("》》》 登陆验证码为:" + "【" + code + "】 《《《");
            } else {
                System.out.println("《《《 获取验证码失败 》》》");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 简易验证码验证
     *
     * @return
     */
    public static String validationCode(String validationCodeUrl, String code) {
        try {
            HttpPost httpost = new HttpPost(validationCodeUrl);
            List<NameValuePair> nvp = new ArrayList<NameValuePair>();
            nvp.add(new BasicNameValuePair("code", code));
            nvp.add(new BasicNameValuePair("inputCode", code));
            httpost.setEntity(new UrlEncodedFormEntity(nvp, Charset
                    .forName("utf-8")));
            HttpResponse response = httpClient.execute(httpost);
            if (response.getStatusLine().getStatusCode() == 302 || response.getStatusLine().getStatusCode() == 200) {
//                System.out.println(EntityUtils.toString(response.getEntity()));
                if (EntityUtils.toString(response.getEntity()).equals("ok")) {
                    System.out.println(">>>>>>>>>>>> 验证码通过 <<<<<<<<<<<<");
                } else {
                    System.out.println(">>>验证码未通过<<<");
                }
                httpost.abort();
            } else {
                System.out.println("<<<请求错误>>>");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模拟验证登入
     *
     * @return
     */
    public static String loginWeb(String loginUrl, Map loginInfoMap) {
        try {
            HttpPost httpost = new HttpPost(loginUrl);
            List<NameValuePair> nvp = new ArrayList<NameValuePair>();
            for(Object key : loginInfoMap.keySet()){
                nvp.add(new BasicNameValuePair((String) key, (String) loginInfoMap.get(key)));
                /*
                nvp.add(new BasicNameValuePair("account", "xihu"));
                nvp.add(new BasicNameValuePair("pwd", "DsTtcsrBekMQ_nSxMxiaChhhu7k_d22fd07t1bS8n2!5k@68#sF"));
                nvp.add(new BasicNameValuePair("code", code));
                nvp.add(new BasicNameValuePair("inputCode", code));
                nvp.add(new BasicNameValuePair("skin", "no-skin"));
                nvp.add(new BasicNameValuePair("clientWidth", "1920"));
                */
            }
            httpost.setEntity(new UrlEncodedFormEntity(nvp, Charset
                    .forName("utf-8")));
            HttpResponse response = httpClient.execute(httpost);
            if (response.getStatusLine().getStatusCode() == 302 || response.getStatusLine().getStatusCode() == 200) {
                System.out.println(EntityUtils.toString(response.getEntity()));
                //boYixP5UlV8B8O/zzaJPGg==
                System.out.println(">>>>>西湖景区游客行为平台登陆成功<<<<<<");
                httpost.abort();
            } else {
                System.out.println("<<<<<西湖景区游客行为平台登陆失败>>>>>>");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Post请求方式获取数据
     * @param url
     * @return
     */
    public static String postData(String url) {
        String peoNum = null;
        try {
            HttpPost httpost = new HttpPost(url);
            httpost.setEntity(new StringEntity("", Charset.forName("utf-8")));
            HttpResponse response = httpClient.execute(httpost);
            if (response.getStatusLine().getStatusCode() == 302 || response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String entiryStr = EntityUtils.toString(entity, "UTF-8");

                peoNum = match(entiryStr, "<span class=\"d_number\">([^\\\"]*)</span>").get(0);

                // 获取网页源码信息
                System.out.println(">>>>>>>>>> POST请求成功 <<<<<<<<<<<");
                System.out.println("响应体数据 start >>>>>>>>>>>>>>>>>>");
                System.out.println("当前人流量：" + peoNum);
                System.out.println("<<<<<<<<<<<<<<<<<<<< 响应体数据 end ");
            } else {
                System.out.println("<<<<<<<<<<<< POST请求失败 >>>>");
            }
            httpost.abort();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return peoNum;
    }

    /**
     * Get请求方式获取数据
     *
     * @return
     */
    public static HttpResponse getData(String url) {
        StringBuffer strResult = new StringBuffer();
        HttpResponse response = null;
        try {
            HttpGet httpget = new HttpGet(url);
            response = httpClient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                // 获取网页源码信息
                strResult.append(EntityUtils.toString(entity, "UTF-8"));
//                System.out.println(">>>>>>>>>>> GET请求成功 <<<<<<<<<<<");
                System.out.println(strResult);
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println("<<<<<<<<<<< GET请求失败 >>>>>>>>>>>");
            }
            httpget.abort();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Get请求方式获取数据
     *
     * @return
     */
    public static String getDataStr(String url) {
        StringBuffer strResult = new StringBuffer();
        HttpResponse response = null;
        try {
            HttpGet httpget = new HttpGet(url);
            response = httpClient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                // 获取网页源码信息
                strResult.append(EntityUtils.toString(entity, "UTF-8"));
//                System.out.println(">>>>>>>>>>> GET请求成功 <<<<<<<<<<<");
                System.out.println(strResult);
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println("<<<<<<<<<<< GET请求失败 >>>>>>>>>>>");
            }
            httpget.abort();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strResult.toString();
    }

    /**
     * 获取指定HTML标签的指定属性的值
     *
     * @param source 要匹配的源文本
     * @param reg    正则
     * @return 属性值列表
     */
    private static List<String> match(String source, String reg) {
        List<String> result = new ArrayList<String>();
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;
    }

}
