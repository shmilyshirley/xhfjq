package com.hlframe.xhjq.other;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-12 13:58
 */

public class LoginUtils {

    private String indexURL = "http://125.210.121.164:8081/hzbs-autho/auth/login/";
    private String loginURL = "http://125.210.121.164:8081/hzbs-autho/auth/login";
//    private String captchaURL = "https://www.zhihu.com/captcha.gif?type=login";验证码
    protected RequestConfig requestConfig = null;
    protected CloseableHttpClient httpClient = null;

    public LoginUtils(String indexURL, String loginURL, String captchaURL) {
        super();
        this.indexURL = indexURL;
        this.loginURL = loginURL;
//        this.captchaURL = captchaURL;验证码
        requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
    }
    public LoginUtils() {
        super();
        requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
    }
    //获取XSRF
    public String getXSRF() throws ClientProtocolException, IOException{
        /*

        Content-Language: zh-CN
        Content-Length: 5557
        Content-Type: text/html;charset=UTF-8
        Date: Wed, 12 Dec 2018 06:28:42 GMT
        Server: Apache-Coyote/1.1
        Set-Cookie: rememberMe=deleteMe; Path=/hzbs-autho; Max-Age=0; Expires=Tue, 11-Dec-2018 06:28:42 GMT
        Set-Cookie: JSESSIONID=E3DD8F899E60B51EFCFC0BD9E2D7C49B; Path=/hzbs-autho; HttpOnly
        X-Adguard-Filtered: Adguard for Mac; version=1.5.8

        */
        HttpGet get = new HttpGet(indexURL);
        get.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        get.setHeader("Accept-Encoding","gzip, deflate");
        get.setHeader("Accept-Language","zh-CN,zh;q=0.9");
        get.setHeader("Origin","http://125.210.121.164:8081");
        get.setHeader("Referer","http://125.210.121.164:8081/hzbs-autho/auth/out");
        get.setHeader("Cookie","userCookie=bdb93620-5941-4f3b-8abd-351fd3a075d4; JSESSIONID=7ED650390075C59AD1318675EF895398; userAndPass=wanyy/abc123");
        CloseableHttpResponse response = httpClient.execute(get);
        String responseHtml = EntityUtils.toString(response.getEntity());
        String xsrfValue = responseHtml.split("<input type=\"hidden\" name=\"_xsrf\" value=\"")[1].split("\"/>")[0];
        return xsrfValue;
    }
    //获取验证码
    /*public String getCaptcha() throws ClientProtocolException, IOException{
        CloseableHttpResponse response = httpClient.execute(new HttpGet(captchaURL));
        InputStream input= response.getEntity().getContent();
        BufferedImage bio = ImageIO.read(input);
        File w2 = new File("src/QQ.jpg");
        ImageIO.write(bio, "jpg", w2);
        input.close();
        response.close();
        String captcha =null;
        Scanner s = new Scanner(System.in);
        System.out.print("captcha:");
        captcha = s.nextLine();
        s.close();
        return captcha;
    }*/
    //获取登陆后的响应状态，包含cookie信息
    public HttpResponse logIn(String email,String password) throws ClientProtocolException, IOException{
        List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
        valuePairs.add(new BasicNameValuePair("_xsrf", getXSRF()));
        valuePairs.add(new BasicNameValuePair("email", email));
        valuePairs.add(new BasicNameValuePair("password", password));
//        valuePairs.add(new BasicNameValuePair("captcha", getCaptcha()));验证码
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
        HttpPost post = new HttpPost(loginURL);
        post.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(post);

        return httpResponse;
    }
    //根据cookie信息，访问其他页面
    public String visitURL(HttpResponse httpResponse, String url) throws ClientProtocolException, IOException{
        HttpGet get = new HttpGet("http://www.zhihu.com/question/following");
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        for(int i =0 ;i<headers.length;i++){
            get.addHeader(headers[i]);
        }
        CloseableHttpResponse r = httpClient.execute(get);
        String content = EntityUtils.toString(r.getEntity());
        System.out.println(content);
        r.close();
        return null;
    }
    /**
     * @param args
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static void main(String[] args) throws ClientProtocolException, IOException {
        LoginUtils login = new LoginUtils();
        HttpResponse httpResponse = login.logIn("wanyy", "abc123");
        StatusLine responseState = httpResponse.getStatusLine();
        System.out.println(responseState.toString());
        Header[] headers = httpResponse.getAllHeaders();
        for(int i =0 ;i<headers.length;i++){
            System.out.println(headers[i].getName()+": "+headers[i].getValue());
        }
        HttpEntity httpEntiey = httpResponse.getEntity();
        String responseString = EntityUtils.toString(httpEntiey);
        System.out.println(responseString);
//		{"r":0,
//			 "msg": "\u767b\u5f55\u6210\u529f"
//			}

//        login.visitURL(httpResponse,"http://www.zhihu.com/question/following");
    }

}

