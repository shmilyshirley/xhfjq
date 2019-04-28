package com.hlframe.xhjq.other;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-12 14:49
 */
public class HttpClientLoginTest {
    public static void main(String[] args) throws Exception {
//        grabPageHTML();
        login2Lashou();
    }

    // 获取一个HTML页面的内容，一个简单的get应用
    public static void grabPageHTML() throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://125.210.121.164:8081/hzbs-autho/auth/login");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity, "GBK");

        // releaseConnection等同于reset，作用是重置request状态位，为下次使用做好准备。
        // 其实就是用一个HttpGet获取多个页面的情况下有效果；否则可以忽略此方法。
        httpget.releaseConnection();

        System.out.println(html);
    }

    // Post方法，模拟表单提交参数登录到网站。
    // 结合了上面两个方法：grabPageHTML/downloadFile，同时增加了Post的代码。
    public static void login2Lashou() throws Exception {

        // 第一步：先下载验证码到本地
        String url = "http://125.210.121.164:8081/hzbs-autho/auth/login";
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        httpget.releaseConnection();
        // 第二步：主要步骤（第一步骤可以省略）
        HttpPost httppost = new HttpPost("http://125.210.121.164:8081/hzbs-autho/auth/login");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", "wanyy"));
        params.add(new BasicNameValuePair("password", "abc123"));
        httppost.setEntity(new UrlEncodedFormEntity(params));

        response = httpclient.execute(httppost);
        entity = response.getEntity();
        // 在这里可以用Jsoup之类的工具对返回结果进行分析，以判断登录是否成功
        String postResult = EntityUtils.toString(entity, "GBK");
        // 我们这里只是简单的打印出当前Cookie值以判断登录是否成功。
        CookieStore cookieStore = ((AbstractHttpClient) httpclient).getCookieStore();
        List<Cookie> cookies = ((AbstractHttpClient) httpclient)
                .getCookieStore().getCookies();
        for (Cookie cookie : cookies)
            System.out.println("cookie begin***\n" + cookie + "\n cookie end");
        httppost.releaseConnection();

        // 第三步：打开会员页面以判断登录成功（未登录用户是打不开会员页面的）
        String memberpage = "http://125.210.121.164:8081/hzbs-autho/auth/login";
        httpget = new HttpGet(memberpage);
        response = httpclient.execute(httpget); // 必须是同一个HttpClient！
        entity = response.getEntity();
        String html = EntityUtils.toString(entity, "GBK");
        httpget.releaseConnection();

        System.out.println(html);
    }

}
