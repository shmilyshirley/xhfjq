package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.service.ChinaHotelInfo12Service;
import com.hlframe.xhjq.service.ZhejiangHotelInfo12Service;
import com.hlframe.xhjq.utils.FormatNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 12:37
 */
@RestController
@RequestMapping(value = "totalHotelInfo12")
public class TotalHotelInfo12 {
    @Autowired
    private ChinaHotelInfo12Service chinaHotelInfo12Service;
    @Autowired
    private ZhejiangHotelInfo12Service zhejiangHotelInfo12Service;


    @RequestMapping(value = "top6AndOther")
    public List countNationalHotelInfo12(){
        // 全国总客流量（除浙江杭州）
        int countTotalCustomer = zhejiangHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer();

        String j = "";
        float rate = 0;
        float rateTemp = 1;
        int tempCount = 0;

        Map zhejaingMap = new HashMap();
        zhejaingMap.put("tag","浙江省");
        zhejaingMap.put("客流量",zhejiangHotelInfo12Service.countCustomer());
        int integer = zhejiangHotelInfo12Service.countCustomer();
        Map hashMap = new HashMap();
        List list = chinaHotelInfo12Service.countCustomerByTag();
        list.add(zhejaingMap);
        for (int i = 0; i < list.size(); i++){
            hashMap = (Map) list.get(i);
            j = hashMap.get("客流量").toString();
            rate = Float.parseFloat(FormatNumberUtils.numberToFloat(Integer.parseInt(j),countTotalCustomer,2));
            rateTemp = rateTemp-rate;
            FormatNumberUtils.numberToFloat2(rateTemp,Float.parseFloat("1"),2);
            tempCount = countTotalCustomer-(Integer.parseInt(j));
            hashMap.put("占比", FormatNumberUtils.numberToFloat(Integer.parseInt(j),countTotalCustomer,2));
        }

        // 添加其他部分的占比
        Map tempMap = new HashMap();
        tempMap.put("tag","其他省份");
        tempMap.put("客流量",tempCount);
        tempMap.put("占比",FormatNumberUtils.numberToFloat2(rateTemp,Float.parseFloat("1"),2));
        list.add(tempMap);
        return list;
    }
}
