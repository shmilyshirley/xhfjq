package com.hlframe.xhjq.test;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-13 09:01
 */

import com.hlframe.xhjq.utils.DateUtils;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/12/12.
 */
public class LoginUtils {
    private HttpClient httpClient = new DefaultHttpClient();
    private String loginUrl = "http://125.210.121.164:8081/hzbs-autho/auth/login";
    private String indexUrl ="http://125.210.121.164:8081/hzbs-autho/auth/index";
    private String dataPageUrl = "http://125.210.121.164:8081/hzbs-web/data/allShow?&userId=201&token=";
    private String timeAreaUrl="http://125.210.121.164:8081/hzbs-web/data/timeArea?radio=raday&stdate=2018-12-05&eddate=2018-12-11&currentPage=1&pageSize=10";

    public String detailPageUrl="http://125.210.121.164:8081/hzbs-web/detail/allShow?userId=201&token=";
    public String detailDataUrl ="http://125.210.121.164:8081/hzbs-web/detail/table";
    private String token;
    private String cookie;

    /**
     * 开始模拟用户登录login
     * @throws IOException
     */
    public void doLogin() throws IOException {
        try {
            HttpPost httpost = new HttpPost(loginUrl);
            List<NameValuePair> nvp = new ArrayList<NameValuePair>();
            nvp.add(new BasicNameValuePair("username", "wanyy"));
            nvp.add(new BasicNameValuePair("password", "abc123"));
            nvp.add(new BasicNameValuePair("password", "remember-me"));
            httpost.setEntity(new UrlEncodedFormEntity(nvp, Charset
                    .forName("utf-8")));
            HttpResponse response = httpClient.execute( httpost);
            if (response.getStatusLine().getStatusCode() == 302) {
                httpost.abort();
            } else {
                System.out.println("登录HDUContest失败！");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取token
     * @throws IOException
     */
    private void doGetToken(String url) throws IOException {
        // TODO Auto-generated method stub
        StringBuffer strResult = new StringBuffer();
        try {
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                // 获取网页源码信息
                strResult.append(EntityUtils.toString(entity, "UTF-8"));
                this.token  = match(strResult.toString()).size()==0?"":match(strResult.toString()).get(0);
                System.out.println("请求成功");
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println("请求失败！");
            }
            httpget.abort();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 通过token获取hzbs-web 项目cookie
     * * @throws IOException
     */
    private void getMainPageCookie(String url) throws IOException {
        doHzbsWebGet(url+token);
    }


    public String doHzbsWebPost(String url,String json){
        String result = null;
        HttpPost httpost = null;
        try{
            httpost = new HttpPost(url);
            httpost.setEntity(new StringEntity(json, Charset
                    .forName("utf-8")));
            httpost.setHeader("Accept","application/json, text/javascript, */*; q=0.01");
            httpost.setHeader("Content-Type","application/json; charset=UTF-8");
            HttpResponse response = httpClient.execute( httpost);
            if (response.getStatusLine().getStatusCode() == 302||response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                // 获取网页源码信息
                result = EntityUtils.toString(entity, "UTF-8");
                System.out.println(result);
                System.out.println("请求成功");
            } else {
                System.out.println("请求失败！");
            }
            httpost.abort();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            httpost.releaseConnection();
        }
        return result;
    }
    //初始化（ 暂定 ）
    public void init(String url) throws IOException {
        this.doLogin();
        this.doGetToken(indexUrl);
        this.getMainPageCookie(url);
    }
    /**
     * get 请求
     * @throws IOException
     */
    public HttpResponse doHzbsWebGet(String url) throws IOException {
        // TODO Auto-generated method stub
        StringBuffer strResult = new StringBuffer();
        HttpResponse response = null;
        try {
            HttpGet httpget = new HttpGet(url);
            response = httpClient.execute( httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                // 获取网页源码信息
                strResult.append(EntityUtils.toString(entity, "UTF-8"));
                System.out.println("请求成功");
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println("请求失败！");
            }
            httpget.abort();

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 解析html获取tokenken
     * @param managers
     * @return
     */
    public List<String> match(String managers){
        List<String> ls=new ArrayList<String>();
        Pattern pattern = Pattern.compile("token=\\\"(.*?)\\\"");
        Matcher matcher = pattern.matcher(managers);
        while(matcher.find())
            ls.add(matcher.group(1));
        return ls;
    }

    public static void main(String[] args) throws IOException {
        start();
    }

    public static String start(){
        LoginUtils hdu = new LoginUtils();
        String s = null;
        String s1 = null;
        String currentdate = DateUtils.getDate();
        String yesterday = String.valueOf(Integer.parseInt(currentdate)-1);
        try {
            hdu.init(hdu.detailPageUrl);
            //hdu.doHzbsWebGet(hdu.timeAreaUrl);
            String jsonStr0="{\"radio\":\"raday\",\"stdate\":\""+yesterday+"\",\"eddate\":\""+yesterday+"\",\"isWork\":\"0\",\"service_item\":[\"0\"],\"service_itemX\":null,\"region_id\":[\"122\",\"45893\"],\"mac_id\":[\"0\"],\"summation\":true,\"currentPage\":1,\"pageSize\":\"10\"}\n";
//            String jsonStr ="{\"radio\":\"raday\",\"stdate\":\""+yesterday+"\",\"eddate\":\""+yesterday+"\",\"isWork\":\"0\",\"service_item\":[\"26\",\"31\",\"37\",\"45\",\"59\",\"71\",\"79\",\"93\"],\"service_itemX\":[\"26\",\"27\",\"108\",\"109\",\"110\",\"118\",\"165\",\"259\",\"265\",\"266\",\"267\",\"269\",\"279\",\"280\",\"31\",\"33\",\"34\",\"35\",\"36\",\"60\",\"99\",\"105\",\"106\",\"113\",\"128\",\"129\",\"130\",\"133\",\"134\",\"135\",\"145\",\"164\",\"166\",\"262\",\"285\",\"288\",\"290\",\"372\",\"373\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"44\",\"116\",\"131\",\"152\",\"155\",\"158\",\"159\",\"45\",\"111\",\"112\",\"146\",\"200\",\"274\",\"275\",\"276\",\"277\",\"278\",\"154\",\"59\",\"62\",\"63\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"73\",\"74\",\"132\",\"147\",\"148\",\"160\",\"161\",\"162\",\"163\",\"194\",\"202\",\"252\",\"263\",\"71\",\"58\",\"77\",\"78\",\"83\",\"114\",\"115\",\"121\",\"149\",\"150\",\"168\",\"169\",\"170\",\"171\",\"172\",\"173\",\"174\",\"175\",\"176\",\"177\",\"178\",\"179\",\"180\",\"181\",\"183\",\"184\",\"185\",\"186\",\"187\",\"188\",\"190\",\"191\",\"193\",\"264\",\"268\",\"281\",\"291\",\"294\",\"295\",\"296\",\"297\",\"298\",\"299\",\"300\",\"301\",\"302\",\"303\",\"304\",\"305\",\"306\",\"307\",\"309\",\"310\",\"311\",\"312\",\"313\",\"314\",\"315\",\"316\",\"317\",\"318\",\"319\",\"320\",\"321\",\"79\",\"81\",\"85\",\"86\",\"88\",\"89\",\"90\",\"91\",\"153\",\"192\",\"253\",\"254\",\"256\",\"258\",\"273\",\"93\",\"210\",\"213\",\"214\",\"215\",\"216\",\"218\",\"219\",\"220\",\"221\",\"222\",\"223\",\"224\"],\"region_id\":[\"122\",\"45893\"],\"mac_id\":[\"0\"],\"summation\":true,\"currentPage\":1,\"pageSize\":\"10\"}";
//            String jsonStr ="{\"radio\":\"raday\",\"stdate\":\""+yesterday+"\",\"eddate\":\""+yesterday+"\",\"isWork\":\"0\",\"service_item\":[\"26\",\"31\",\"37\",\"45\",\"59\",\"71\",\"79\",\"93\"],\"service_itemX\":[\"26\",\"27\",\"108\",\"109\",\"110\",\"118\",\"165\",\"259\",\"265\",\"266\",\"267\",\"269\",\"279\",\"280\",\"31\",\"33\",\"34\",\"35\",\"36\",\"60\",\"99\",\"105\",\"106\",\"113\",\"128\",\"129\",\"130\",\"133\",\"134\",\"135\",\"145\",\"164\",\"166\",\"262\",\"285\",\"288\",\"290\",\"372\",\"373\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"44\",\"116\",\"131\",\"152\",\"155\",\"158\",\"159\",\"45\",\"111\",\"112\",\"146\",\"200\",\"274\",\"275\",\"276\",\"277\",\"278\",\"154\",\"59\",\"62\",\"63\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"73\",\"74\",\"132\",\"147\",\"148\",\"160\",\"161\",\"162\",\"163\",\"194\",\"202\",\"252\",\"263\",\"71\",\"58\",\"77\",\"78\",\"83\",\"114\",\"115\",\"121\",\"149\",\"150\",\"168\",\"169\",\"170\",\"171\",\"172\",\"173\",\"174\",\"175\",\"176\",\"177\",\"178\",\"179\",\"180\",\"181\",\"183\",\"184\",\"185\",\"186\",\"187\",\"188\",\"190\",\"191\",\"193\",\"264\",\"268\",\"281\",\"291\",\"294\",\"295\",\"296\",\"297\",\"298\",\"299\",\"300\",\"301\",\"302\",\"303\",\"304\",\"305\",\"306\",\"307\",\"309\",\"310\",\"311\",\"312\",\"313\",\"314\",\"315\",\"316\",\"317\",\"318\",\"319\",\"320\",\"321\",\"79\",\"81\",\"85\",\"86\",\"88\",\"89\",\"90\",\"91\",\"153\",\"192\",\"253\",\"254\",\"256\",\"258\",\"273\",\"93\",\"210\",\"213\",\"214\",\"215\",\"216\",\"218\",\"219\",\"220\",\"221\",\"222\",\"223\",\"224\"],\"region_id\":[\"122\",\"45893\"],\"mac_id\":[\"0\"],\"summation\":true,\"currentPage\":1,\"pageSize\":\"10\"}";
            String jsonStr ="{\"radio\":\"raday\",\"stdate\":\""+yesterday+"\",\"eddate\":\""+yesterday+"\",\"isWork\":\"0\",\"service_item\":[\"26\",\"31\",\"37\",\"45\",\"52\",\"59\",\"71\",\"79\",\"93\"],\"service_itemX\":[\"26\",\"27\",\"29\",\"259\",\"265\",\"266\",\"267\",\"269\",\"279\",\"280\",\"355\",\"356\",\"31\",\"33\",\"34\",\"35\",\"36\",\"113\",\"164\",\"166\",\"262\",\"285\",\"290\",\"357\",\"358\",\"359\",\"360\",\"361\",\"362\",\"364\",\"365\",\"366\",\"367\",\"372\",\"373\",\"374\",\"412\",\"417\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"44\",\"116\",\"131\",\"152\",\"155\",\"158\",\"159\",\"418\",\"45\",\"50\",\"111\",\"112\",\"146\",\"154\",\"200\",\"274\",\"275\",\"276\",\"277\",\"278\",\"426\",\"52\",\"380\",\"381\",\"382\",\"416\",\"59\",\"62\",\"63\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"73\",\"74\",\"132\",\"147\",\"148\",\"160\",\"161\",\"162\",\"163\",\"252\",\"263\",\"326\",\"334\",\"368\",\"429\",\"430\",\"431\",\"432\",\"433\",\"71\",\"58\",\"77\",\"78\",\"83\",\"114\",\"115\",\"121\",\"149\",\"150\",\"168\",\"169\",\"170\",\"171\",\"172\",\"173\",\"174\",\"175\",\"176\",\"177\",\"178\",\"179\",\"180\",\"181\",\"183\",\"184\",\"185\",\"186\",\"187\",\"188\",\"190\",\"191\",\"193\",\"264\",\"268\",\"281\",\"291\",\"294\",\"295\",\"296\",\"297\",\"298\",\"299\",\"300\",\"301\",\"302\",\"303\",\"304\",\"305\",\"306\",\"307\",\"309\",\"310\",\"311\",\"312\",\"313\",\"314\",\"315\",\"316\",\"317\",\"318\",\"319\",\"320\",\"321\",\"369\",\"370\",\"79\",\"81\",\"85\",\"86\",\"88\",\"89\",\"90\",\"91\",\"153\",\"192\",\"253\",\"254\",\"256\",\"258\",\"273\",\"93\",\"210\",\"215\",\"216\",\"219\",\"221\",\"222\",\"223\",\"224\",\"399\",\"400\"],\"region_id\":[\"122\",\"45893\"],\"mac_id\":[\"0\"],\"summation\":true,\"currentPage\":1,\"pageSize\":\"20\"}";
            s = hdu.doHzbsWebPost(hdu.detailDataUrl, jsonStr0);
            s1 = hdu.doHzbsWebPost(hdu.detailDataUrl, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            s = "";
            s1 = "";
        }finally {

        }

        return s+"---"+s1;
    }

}
