package com.hlframe.xhjq.controller;

import com.hlframe.xhjq.domain.HzbsData;
import com.hlframe.xhjq.service.HzbsDataService;
import com.hlframe.xhjq.test.LoginUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-17 10:03
 */
@Controller
@RequestMapping(value = "hzbsData")
public class HzbsDataController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HzbsDataService hzbsDataService;

    @RequestMapping(value = "insertHzbsData")
    public String insert() {
        String result;
        HzbsData hzbsData = new HzbsData();

        result = LoginUtils.start();
        if (result.indexOf("totalRecords") == -1) {
            result = LoginUtils.start();
        }
        String[] strArr = result.split("---");
        hzbsData.setFields1(strArr[0]);
        hzbsData.setHzbsInfo(strArr[1]);
        hzbsDataService.insert(hzbsData);

        return "hzbs";
    }
}
