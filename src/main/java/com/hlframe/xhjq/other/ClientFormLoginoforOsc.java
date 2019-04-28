package com.hlframe.xhjq.other;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-12 21:25
 */
public class ClientFormLoginoforOsc {
    public static void main(String[] args) throws Exception {

        String url = "http://125.210.121.164:8081/hzbs-web/data/areaData?radio=raday&stdate=2018-12-05&eddate=2018-12-11&currentPage=1&pageSize=10";

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet("http://125.210.121.164:8081/hzbs-autho/auth/login");

            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            System.out.println("Login form get: " + response.getStatusLine());
            EntityUtils.consume(entity);

            System.out.println("Initial set of cookies:");
            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    System.out.println("- " + cookies.get(i).toString());
                }
            }

            //Cookie 登录之后记录
            String tmpcookies = "";
            HttpPost httpost = new HttpPost("http://125.210.121.164:8081/hzbs-autho/auth/login");

            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("username", "wanyy"));
            nvps.add(new BasicNameValuePair("password", "abc123"));

            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            response = httpclient.execute(httpost);
            entity = response.getEntity();

            System.out.println("Login form get: " + response.getStatusLine());
            EntityUtils.consume(entity);

            System.out.println("Post logon cookies:");
            cookies = httpclient.getCookieStore().getCookies();
            if (cookies.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                    System.out.println("- " + cookies.get(i).toString());
                    tmpcookies += cookies.get(i).toString();
                }
            }


            //登录之后进行操作
            HttpGet httpget1 = new HttpGet(url);
            //设置cookie,登录后操作
            httpget1.setHeader("cookie",tmpcookies);

            HttpResponse response1 = httpclient.execute(httpget1);
            HttpEntity entity1 = response1.getEntity();

            System.out.println("Login form find: " + response.getStatusLine());


            System.out.println("Initial set of cookies:");
            List<Cookie> cookies1 = httpclient.getCookieStore().getCookies();
            if (cookies1.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i = 0; i < cookies1.size(); i++) {
                    System.out.println("- " + cookies1.get(i).toString());
                }
            }
            if(entity1 !=null){//读取内容
                //System.out.println(entity1.getContentLength());
                //System.out.println(EntityUtils.toString(entity1));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(entity1.getContent(),"utf-8"));
                try {

                    String str = null;
                    while((str = reader.readLine()) != null){
                        System.out.println(str);
                    }
                } catch (IOException ex) {
                    throw ex;
                } catch (RuntimeException ex) {
                    throw ex;
                } finally {
                    reader.close();
                }
            }
            EntityUtils.consume(entity1);

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }
}
