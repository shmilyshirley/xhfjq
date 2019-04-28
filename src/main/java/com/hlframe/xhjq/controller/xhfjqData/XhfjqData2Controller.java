package com.hlframe.xhjq.controller.xhfjqData;

import com.alibaba.fastjson.JSON;
import com.hlframe.xhjq.domain.xhfjqData.XhfjqData2;
import com.hlframe.xhjq.service.XhfjqData2Service;
import com.hlframe.xhjq.test.XhfjqDataTest;
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
 * @date:2019-01-09 15:57
 */
@RestController
@RequestMapping(value = "xhfjqData2")
public class XhfjqData2Controller {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XhfjqData2Service xhfjqData2Service;

    @RequestMapping(value = "insertXhfjqData2")
    public String insert() throws IOException {
        String URL = null;
        // 通过数据接口获取到的json数据
        String jsonStr = XhfjqDataTest.jsonData();
        // 如果jsonStr中存在有效数据才进行数据录入
        if (jsonStr.indexOf("\"rc\":0,") >= 0 && jsonStr.length() > 20) {
            String json = RegexUtils.getStringWithBracket(jsonStr);
            List<XhfjqData2> list = JSON.parseArray(json, XhfjqData2.class);
            for (int i = 0; i < list.size(); i++) {
                xhfjqData2Service.insert(list.get(i));
            }
            log.info("西湖风景名胜区酒店数据插入成功！");
        } else {
            return "XihuRiver data is null,check your date please!";
        }
        return "Xjhu River inserted successfully,go to and play~~~";
    }

    @RequestMapping(value = "selectAll")
    public List selectAll(){
        return xhfjqData2Service.selectAll();
    }

    @RequestMapping(value = "selectByCheckintime")
    public List selectByCheckintime(String checkin_time){
        return xhfjqData2Service.selectByDate(checkin_time);
    }

    @RequestMapping(value = "selectByDate")
    public String selectByDate(String date){
        return XhfjqDataTest.jsonData2(date);
    }
}
