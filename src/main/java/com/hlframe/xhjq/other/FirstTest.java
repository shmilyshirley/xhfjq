package com.hlframe.xhjq.other;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-12 16:02
 */

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 第一个爬虫测试
 * Created by DuFei on 2017/7/27.
 */
public class FirstTest {

    public static void main(String[] args) {

        //建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = null;
        int i = 1;
        while (i <= 10) {
            //使用HttpGet方式请求网址
            httpGet = new HttpGet("https://api.double.com.cn/v2.0/user/buser/sms/send?mobile=17851182164&type=1&userType=3");
            i++;
            //获取网址的返回结果
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //获取返回结果中的实体
            HttpEntity entity = response.getEntity();

            //将返回的实体输出
            try {
                System.out.println(EntityUtils.toString(entity));
                EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

