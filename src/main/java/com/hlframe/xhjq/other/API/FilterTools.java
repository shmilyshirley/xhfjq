package com.hlframe.xhjq.other.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlframe.xhjq.domain.API.DepthHis;
import com.hlframe.xhjq.domain.API.DepthObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-19 10:58
 */
public class FilterTools {

    /**
     * @param boatId 船ID
     * @param endTime 结束时间（时间戳）
     * @param startTime 开始时间（时间戳）
     * @param secondFrequency 频率（筛选的频率，单位秒）
     */
    public static Map<String, List<DepthHis>> filterByTimestamp(String boatId, String endTime, String startTime, int secondFrequency){
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // URL前缀
        String uri = "http://river.dev.wochanye.com/apiBoatData/boat/depthHis?boatId=";
        // 创建httppost
        HttpPost httppost = new HttpPost(uri + boatId + "&end=" + endTime + "&start=" + startTime );

        try {
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            // 状态码错误返回错误信息
            if ( response.getStatusLine().getStatusCode() != 200){
                return null ;
            }
            // 获取借口的所有json数据
            String dataContent = EntityUtils.toString(entity, "UTF-8");

            // jackson用法
            // JSON转JAVA实体类
            ObjectMapper mapper = new ObjectMapper();
            DepthObject depthObject = mapper.readValue(dataContent, DepthObject.class);

            // 获取DepthHis对象List集合
            Map<String, List<DepthHis>> data = depthObject.getData();
            List<DepthHis> depthHisList = data.get("depthHis");
//            System.out.println("depthHis = " + depthHisList);
            List<DepthHis> dataList= depthHisList.stream()
                    .filter(i->isMatch(i.getTimeStampStr(), secondFrequency))
                    .filter(distinctByKey(DepthHis::getTimeStampStr))
                    .collect(Collectors.toList());
            dataList.forEach(System.out::println);

            data.put("depthHis",dataList);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    private void test(){
        FilterTools.filterByTimestamp("00015310000000000023","1552983300000","1552983000000",5);
    }

    public static boolean isMatch(String dtime, int inteval){
        return 0==((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(dtime, new ParsePosition(0)).getTime() )/ 1000%inteval;
    }

    public static Predicate<DepthHis> distinctByKey(Function< DepthHis, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
