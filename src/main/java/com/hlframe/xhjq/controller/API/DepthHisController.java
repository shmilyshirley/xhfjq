package com.hlframe.xhjq.controller.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlframe.xhjq.domain.API.*;
import com.hlframe.xhjq.other.API.FilterTools;
import com.hlframe.xhjq.service.EventService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-19 10:41
 */
@Controller
@RequestMapping(value = "depthHIs")
public class DepthHisController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "filterBySecond")
    @ResponseBody
    public Map<String, List<DepthHis>> filterDataByTime(String boatId, String end, String start, int secondFrequency) {
        Map<String, List<DepthHis>> stringListMap = FilterTools.filterByTimestamp(boatId, end, start, secondFrequency);
        return stringListMap;
    }

    @RequestMapping(value = "events")
    @ResponseBody
    public List moniEvent() {
        List<Event> eventList = null;
        Map<String, Object> resultMap = new HashMap();

        eventList = eventService.getEvent();
//        for ( Event e : eventList ){
        for (int a = 0; a < eventList.size(); a++) {
            Event e = eventList.get(a);
            List<Locations> locationsList = new ArrayList();
            locationsList = eventService.getLocations(a + 1);
            int listSize = locationsList.size();

            List l = new ArrayList();
            if (listSize >= 0) {
                for (int i = 0; i < listSize; i++) {
                    Locations locations = locationsList.get(i);
                    l.add(locations.getJingdu());
                    l.add(locations.getWeidu());
                }
            }
            e.setLocations(l);
        }
        return eventList;
    }

    @RequestMapping(value = "playbackTrack")
    @ResponseBody
    public List playbackTrack() {

        return null;
    }

    /**
     * 将选定的时间区间数据通过接口存入数据库
     *
     * @param boatId
     * @param endTime
     * @param startTime
     * @return
     */
    @RequestMapping(value = "insertDepthHis")
    @ResponseBody
    public Map<String, Object> insertDepthHis(String boatId, String endTime, String startTime) {
        // 获取当前类的logger日志
        Log logger = LogFactory.getLog(this.getClass());
        // 状态Map
        Map<String, Object> statusMap = new HashMap<>();

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // URL前缀
        String uri = "http://river.dev.wochanye.com/apiBoatData/boat/depthHis?boatId=";
        // 创建httppost
        HttpPost httppost = new HttpPost(uri + boatId + "&end=" + endTime + "&start=" + startTime);

        try {
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            // 状态码错误返回错误信息
            if (response.getStatusLine().getStatusCode() != 200) {
                statusMap.put("错误", "状态码异常");
                return statusMap;
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
            // 接收解析后的对象的List集合
            List<TblDepthHis> resultList = new ArrayList<>();
            for (DepthHis depthHis : depthHisList) {
                // 将解析后的数据转化为TblDepthHis实体类
                TblDepthHis tblDepthHis = new TblDepthHis();
                tblDepthHis.setId(depthHis.getId());
                tblDepthHis.setBoatNo(depthHis.getBoatNo());
                tblDepthHis.setTimeStampStr(depthHis.getTimeStampStr());
                tblDepthHis.setTimeStamp(depthHis.getTimeStamp());
                tblDepthHis.setDepth(depthHis.getDepth());
                tblDepthHis.setWeidu(Double.parseDouble(String.valueOf(depthHis.getLocation().get(0))));
                tblDepthHis.setJingdu(Double.parseDouble(String.valueOf(depthHis.getLocation().get(1))));
                // 将解析后的对象存入List
                resultList.add(tblDepthHis);
            }
            // 将联通接口中的数据解析后，存入MySQL
            eventService.insertTblDepthHis(resultList);
            statusMap.put("状态", "successed");
            return statusMap;
        } catch (Exception e) {
            logger.info("出现异常");
            e.printStackTrace();
        }
        logger.info("end-------");
        return null;
    }

    @RequestMapping( "getLixianDepthHis" )
    @ResponseBody
    public  List getLixianDepthHis( int secondFrequency ) {
        List<TblDepthHis> tblDepthHisList = eventService.getLixianDepthHis();
        List<DepthHis> depthHisList = new ArrayList<>();
        for ( int i=1; i<tblDepthHisList.size(); i++ ){
            DepthHis depthHis = new DepthHis();
            depthHis.setId(tblDepthHisList.get(i).getId());
            depthHis.setBoatNo(tblDepthHisList.get(i).getBoatNo());
            depthHis.setTimeStampStr(tblDepthHisList.get(i).getTimeStampStr());
            depthHis.setTimeStamp(tblDepthHisList.get(i).getTimeStamp());
            depthHis.setDepth(tblDepthHisList.get(i).getDepth());
            List list = new ArrayList<>();
            list.add( tblDepthHisList.get(i).getWeidu() );
            list.add( tblDepthHisList.get(i).getJingdu() );
            depthHis.setLocation( list );
            // 转化为其他实体类
            depthHisList.add( depthHis );
        }
        List<DepthHis> dataList= depthHisList.stream()
                .filter(b->FilterTools.isMatch(b.getTimeStampStr(), secondFrequency))
                .filter(FilterTools.distinctByKey(DepthHis::getTimeStampStr))
                .collect(Collectors.toList());
//        dataList.forEach(System.out::println);// 打印List对象
            return dataList;
//        data.put("depthHis",dataList);
    }

}
