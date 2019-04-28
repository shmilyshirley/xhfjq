package com.hlframe.xhjq.controller.subwayData;

import com.alibaba.fastjson.JSON;
import com.hlframe.xhjq.domain.subwayData.SubwayData;
import com.hlframe.xhjq.service.SubwayDataService;
import com.hlframe.xhjq.test.SubwayDataTest;
import com.hlframe.xhjq.utils.RegexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-14 09:34
 */
@RestController
@RequestMapping(value = "subwayData")
public class SubwayDataController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SubwayDataService subwayDataService;

    @RequestMapping(value = "insert")
    public String insert() throws IOException {
        String URL = null;
        // 通过数据接口获取到的json数据
        String jsonStr = SubwayDataTest.jsonData();
        // 如果jsonStr中存在有效数据才进行数据录入
        if (jsonStr.indexOf("\"rc\":0,") >= 0 && jsonStr.length() > 20) {
            String json = RegexUtils.getStringWithBracket(jsonStr);
            List<SubwayData> list = JSON.parseArray(json, SubwayData.class);
            for (int i = 0; i < list.size(); i++) {
                subwayDataService.insert(list.get(i));
            }
            log.info("地铁数据插入成功！");
        } else {
            return "Subway data is null,check your date please!";
        }
        return "Subway inserted successfully,go to and play~~~";
    }

    @RequestMapping(value = "selectAll")
    public List selectAll(){
        return subwayDataService.selectAll();
    }

    /**
     * 获取实时地铁数据
     * @return
     */
    @RequestMapping(value = "realtimeSubwayData")
    public List selectByDate(String date){
        return subwayDataService.selectByDate(date);
    }

    /**
     * 通过传入date参数，获取地铁数据。
     * @param date
     * @return
     */
    @RequestMapping(value = "selectByDate")
    public String selectSubwayDataByDate(String date){
        return SubwayDataTest.jsonData2(date);
    }
}
