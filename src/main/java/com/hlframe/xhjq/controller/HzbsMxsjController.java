package com.hlframe.xhjq.controller;

import com.alibaba.fastjson.JSON;
import com.hlframe.xhjq.domain.HzbsMxsj;
import com.hlframe.xhjq.service.HzbsMxsjService;
import com.hlframe.xhjq.test.LoginUtils;
import com.hlframe.xhjq.utils.DateUtils;
import com.hlframe.xhjq.utils.RegexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-18 14:41
 */
@Controller
@RequestMapping(value = "hzbsMxsj")
public class HzbsMxsjController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HzbsMxsjService hzbsMxsjService;

    @RequestMapping(value = "insertHzbsMxsj")
    public String insert(){
        // 获取今日的日期
        String today = DateUtils.getCurrentDatetime()+" 00:00:00";
        // 获取昨日的日期
        String yesterday = DateUtils.getYesterday();
        // 判断数据是否已插入
        if (hzbsMxsjService.countHzbsMxsjByDatetime(today) > 0 ){
            log.info("昨日:"+yesterday+"的数据已存在，请勿重复插入！");
            return "notnull";
        }
        String result;
        HzbsMxsj hzbsMxsj = new HzbsMxsj();
        // 通过爬虫获取网站数据信息
        result = LoginUtils.start();
        // 若获取数据失败，每隔1秒获取一次，直到成功
        while (result.indexOf("totalRecords") == -1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = LoginUtils.start();
        }
        // 将获取到的json结果数据进行解析成实体类对象存入数据库
        String stringWithBracket = RegexUtils.getStringWithBracket(result);
        List<HzbsMxsj> hzbsMxsjList = JSON.parseArray(stringWithBracket, HzbsMxsj.class);
        for (int i = 1; i<hzbsMxsjList.size(); i++){
            hzbsMxsjList.get(i).setDatetime(today);
            hzbsMxsjService.insert(hzbsMxsjList.get(i));
        }
        log.info("昨日:"+yesterday+"的数据插入成功！");
        return "HzbsMxsj";
    }
}
