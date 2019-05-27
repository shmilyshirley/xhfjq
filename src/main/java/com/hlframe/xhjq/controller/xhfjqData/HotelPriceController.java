package com.hlframe.xhjq.controller.xhfjqData;

import com.google.gson.internal.LinkedHashTreeMap;
import com.hlframe.xhjq.service.HotelCommentService;
import com.hlframe.xhjq.service.HotelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-11 11:03
 */
@RestController
@RequestMapping(value = "hotelPrice")
public class HotelPriceController {
    @Autowired
    private HotelPriceService hotelPriceService;

    /**
     * 计算酒5个类别酒店最低价（1-12月）
     * @return
     */
    @RequestMapping(value = "countLowestPriceByType")
    public List countHotel (){
        return hotelPriceService.countLowestPriceByType();
    }

    // 近12个月各类酒店最低价格
    @RequestMapping(value = "test")
    public List test (){
        List<Map<String,Object>> testList = hotelPriceService.test();
        List<Map<String,Object>> resultList = new ArrayList<>();

        for (Map<String, Object> ele : testList) {
            Map<String,Object> tempMap1 = new LinkedHashTreeMap<>();// 序
            int count = 0;
            // 当前月份
            int currMonth = new Date().getMonth() + 1;
            for (int i = currMonth; i <=12 ; i++) {
                // 判断是否当前年份
                if (i >= currMonth) {
                    tempMap1.put(String.valueOf(i), ele.get(String.valueOf(i)));
                }
            }
            for (int j = 1; j < currMonth;j++){
                tempMap1.put(String.valueOf(j), ele.get(String.valueOf(j)));
            }
            tempMap1.put("hotel_type",ele.get("hotel_type"));
            resultList.add(tempMap1);
//            count++;
        }
        return resultList;
    }

}
