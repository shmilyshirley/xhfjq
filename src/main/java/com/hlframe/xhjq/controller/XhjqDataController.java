package com.hlframe.xhjq.controller;

import com.hlframe.xhjq.domain.XhjqData;
import com.hlframe.xhjq.other.VirtualLogin;
import com.hlframe.xhjq.service.XhjqDataService;
import com.hlframe.xhjq.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/xhjqData")
public class XhjqDataController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XhjqDataService xhjqDataService;

    /**
     * 插入数据
     * @return
     */
//    @ResponseBody
    @RequestMapping(value = "insertData")
    public String insert(){
        int count = 1;
        XhjqData xhjqData = new XhjqData();
        // 获取当前游客数
        String peoNum = VirtualLogin.getXhjqData();
        while (peoNum == null || "".equals(peoNum)){
            System.out.println("已查询当前游客数【"+count+"】次");
            peoNum = VirtualLogin.getXhjqData();
            ++count;
        }
        count = 1;
        xhjqData.setXhjqName("西湖景区当前游客数");
        xhjqData.setXhjqPeopleNumber(Integer.parseInt(peoNum));
        xhjqData.setXhjqDatetime(DateUtils.getCurrentDate());
        xhjqDataService.insert(xhjqData);
        return "success";
    }

    /**
     * 通过id查询所有数据
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getDataById")
    public XhjqData selectDataCollectionById(String id) {
        return xhjqDataService.selectXhjqDataById(Integer.parseInt(id));
    }

}







