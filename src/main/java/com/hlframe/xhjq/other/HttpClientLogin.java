package com.hlframe.xhjq.other;


import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.client.methods.HttpPost;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-12 16:27
 */
public class HttpClientLogin {


    private static String getStringFromStream(HttpServletRequest req) {
        ServletInputStream is;
        try {
            is = req.getInputStream();
            int nRead = 1;
            int nTotalRead = 0;
            byte[] bytes = new byte[10240];
            while (nRead > 0) {
                nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
                if (nRead > 0)
                    nTotalRead = nTotalRead + nRead;
            }
            String str = new String(bytes, 0, nTotalRead, "utf-8");
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        // 登陆 Url
        String loginUrl = "http://125.210.121.164:8081/hzbs-autho/auth/login";
        // 需登陆后访问的 Url
        String dataUrl = "http://125.210.121.164:8081/hzbs-web/detail/table";

        HttpClient httpClient = new HttpClient();

        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
        PostMethod postMethod = new PostMethod(loginUrl);

        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = { new NameValuePair("username", "wanyy"),
                new NameValuePair("password", "abc123") };
        postMethod.setRequestBody(data);
        try {
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
            httpClient.getParams().setCookiePolicy(
                    CookiePolicy.BROWSER_COMPATIBILITY);
            httpClient.executeMethod(postMethod);
            System.out.println(postMethod.getResponseBodyAsString());
            // 获得登陆后的 Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpcookies = new StringBuffer();
            for (Cookie c : cookies) {
                tmpcookies.append(c.toString() + ";");
            }


//            // 进行登陆后的操作1581,1602,1603,1610,1609,1608,1607,1606,1605,1620,1619,1617,1616,1622,1626,1642,1648,1647,1657
//            GetMethod getMethod = new GetMethod(dataUrl);
//            // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
//            getMethod.setRequestHeader("cookie", tmpcookies.toString());
//            // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
//            // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
//            postMethod.setRequestHeader("Referer", "http://125.210.121.164:8081/hzbs-web/detail/allShow?token=087f3e7a-9a5a-4f0f-b04f-9a7bd143bb1f&userId=201");
//            postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
//            httpClient.executeMethod(getMethod);
//            // 打印出返回数据，检验一下是否成功
//            String text = getMethod.getResponseBodyAsString();
//            System.out.println(text);
//            match(text,"");
            /*String p = "\"([^\"]*)\"" ;
            Pattern P=Pattern.compile(p);
            Matcher matcher1=P.matcher(str);
	        if(matcher1.find())
	        {
	    	    System.out.println(matcher1.group(0));
	        }
            text.matches("(?<=\")([\\S]+?)(?=\")");*/


            // 设置参数
            String papas = "{\"radio\":\"raday\",\"stdate\":\"20181211\",\"eddate\":\"20181211\",\"isWork\":\"0\",\"service_item\":[\"26\",\"31\",\"37\",\"45\",\"59\",\"71\",\"79\",\"93\"],\"service_itemX\":[\"26\",\"27\",\"108\",\"109\",\"110\",\"118\",\"165\",\"259\",\"265\",\"266\",\"267\",\"269\",\"279\",\"280\",\"31\",\"33\",\"34\",\"35\",\"36\",\"60\",\"99\",\"105\",\"106\",\"113\",\"128\",\"129\",\"130\",\"133\",\"134\",\"135\",\"145\",\"164\",\"166\",\"262\",\"285\",\"288\",\"290\",\"372\",\"373\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"44\",\"116\",\"131\",\"152\",\"155\",\"158\",\"159\",\"45\",\"111\",\"112\",\"146\",\"200\",\"274\",\"275\",\"276\",\"277\",\"278\",\"154\",\"59\",\"62\",\"63\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"73\",\"74\",\"132\",\"147\",\"148\",\"160\",\"161\",\"162\",\"163\",\"194\",\"202\",\"252\",\"263\",\"71\",\"58\",\"77\",\"78\",\"83\",\"114\",\"115\",\"121\",\"149\",\"150\",\"168\",\"169\",\"170\",\"171\",\"172\",\"173\",\"174\",\"175\",\"176\",\"177\",\"178\",\"179\",\"180\",\"181\",\"183\",\"184\",\"185\",\"186\",\"187\",\"188\",\"190\",\"191\",\"193\",\"264\",\"268\",\"281\",\"291\",\"294\",\"295\",\"296\",\"297\",\"298\",\"299\",\"300\",\"301\",\"302\",\"303\",\"304\",\"305\",\"306\",\"307\",\"309\",\"310\",\"311\",\"312\",\"313\",\"314\",\"315\",\"316\",\"317\",\"318\",\"319\",\"320\",\"321\",\"79\",\"81\",\"85\",\"86\",\"88\",\"89\",\"90\",\"91\",\"153\",\"192\",\"253\",\"254\",\"256\",\"258\",\"273\",\"93\",\"210\",\"213\",\"214\",\"215\",\"216\",\"218\",\"219\",\"220\",\"221\",\"222\",\"223\",\"224\"],\"region_id\":[\"122\",\"45893\"],\"mac_id\":[\"0\"],\"summation\":true,\"currentPage\":1,\"pageSize\":\"10\"}";
            RequestEntity entity = new StringRequestEntity(papas,"application/json","UTF-8");
            PostMethod pm = new PostMethod(dataUrl);
            //postMethod.setRequestEntity(entity);
//            pm.setRequestHeader("Content-Type","application/json; charset=UTF-8");
//            pm.setRequestHeader("Accept-Encoding","gzip, deflate");
//            pm.setRequestHeader("Accept-Language","zh-CN,zh;q=0.9");
//            pm.setRequestHeader("Connection","keep-alive");
            pm.setRequestHeader("Host","125.210.121.164:8081");
            pm.setRequestHeader("Origin","http://125.210.121.164:8081");
//            postMethod.setRequestHeader("Referer","http://125.210.121.164:8081/hzbs-web/detail/allShow?token="+match(text,"").get(0)+"&userId=201");
            postMethod.setRequestHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
            pm.setRequestHeader("cookie", tmpcookies.toString());


            httpClient.executeMethod(pm);

            System.out.println("str = " + pm.getStatusLine().getStatusCode());
            String str = pm.getResponseBodyAsString();
//----------判断是否重定向开始
            int code = pm.getStatusLine().getStatusCode();
            String newuri="";
            if (code == 302) {
                Header header = pm.getResponseHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
                newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
                System.out.println(newuri);
                System.out.println(code);

                HttpPost httpPost = new HttpPost(newuri);
                httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            }

            //------------重定向结束
            System.out.println("str = " + str);
//            System.out.println(getStringFromStream((HttpServletRequest) httpClient));
//
//            String str = "";


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        /**
         * 获取指定HTML标签的指定属性的值
         * @param source 要匹配的源文本
         * @param element 标签名称
         * @return 属性值列表
         */
        public static List<String> match(String source, String element) {
            List<String> result = new ArrayList<String>();
            String reg = "token=\\\"([^\\\"]*)\\\"";

            //String reg ="[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}";
            Matcher m = Pattern.compile(reg).matcher(source);
            while (m.find()) {
                String r = m.group(1);
                result.add(r);
            }
            return result;
        }



}
