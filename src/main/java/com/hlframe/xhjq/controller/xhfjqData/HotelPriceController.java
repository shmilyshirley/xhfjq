package com.hlframe.xhjq.controller.xhfjqData;

import com.google.common.collect.Lists;
import com.google.gson.internal.LinkedHashTreeMap;
import com.hlframe.xhjq.domain.xhfjqData.HotelPrice;
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
     *
     * @return
     */
    @RequestMapping(value = "countLowestPriceByType")
    public List countHotel() {
        List<HotelPrice> hotelPriceList = null;
        hotelPriceList = hotelPriceService.countLowestPriceByType();

        List<Map<String, String>> resultList = Lists.newArrayList();
        if (hotelPriceList == null)
            return null;

        for (HotelPrice hotelPrice : hotelPriceList) {
            Map map = new HashMap<String, String>();
            map.put("hotelType", hotelPrice.getHotel_type());
            List list = new ArrayList<>();
            list.add(hotelPrice.getJan() != null ? hotelPrice.getJan() : 0);
            list.add(hotelPrice.getFeb() != null ? hotelPrice.getFeb() : 0);
            list.add(hotelPrice.getMar() != null ? hotelPrice.getMar() : 0);
            list.add(hotelPrice.getApr() != null ? hotelPrice.getApr() : 0);
            list.add(hotelPrice.getMar() != null ? hotelPrice.getMar() : 0);
            list.add(hotelPrice.getJun() != null ? hotelPrice.getJun() : 0);
            list.add(hotelPrice.getJul() != null ? hotelPrice.getJul() : 0);
            list.add(hotelPrice.getAug() != null ? hotelPrice.getAug() : 0);
            list.add(hotelPrice.getSept() != null ? hotelPrice.getSept() : 0);
            list.add(hotelPrice.getOct() != null ? hotelPrice.getOct() : 0);
            list.add(hotelPrice.getNov() != null ? hotelPrice.getNov() : 0);
            list.add(hotelPrice.getDec() != null ? hotelPrice.getDec() : 0);
            // 将list放入map
            map.put("value", list);
            // 将map存入list并返回
            resultList.add(map);
        }
        // 获取当前月份
        Calendar calendar = Calendar.getInstance();
        //获得当前时间的月份，月份从0开始所以结果要加1
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("month = " + month);

        return resultList;
    }

    /*// 近12个月各类酒店最低价格
    @RequestMapping(value = "test")
    public List test (){
        List<Map<String,Object>> testList = hotelPriceService.test();
        List<Map<String,Object>> resultList = new ArrayList<>();

        for (Map<String, Object> ele : testList) {
            Map<String,Object> tempMap1 = new LinkedHashTreeMap<>();
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
            tempMap1.put("hotelType",ele.get("hotel_type"));
            resultList.add(tempMap1);
//            count++;
        }
        return resultList;
    }*/

    // 近12个月各类酒店最低价格
    @RequestMapping(value = "test")
    public List test() {
        List<Map<String, Object>> testList = hotelPriceService.test();
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Map<String, Object> ele : testList) {
            Map<String, Object> tempMap1 = new LinkedHashTreeMap<>();
            // 存储value的list
            List<Integer> valueList = new ArrayList<>();
            // 存储month的list
            List<String> monthList = new ArrayList<>();
            int count = 0;
            // 当前月份
            int currMonth = new Date().getMonth() + 1;
            for (int i = currMonth; i <= 12; i++) {
                // 判断是否当前年份
                if (i >= currMonth) {
                    monthList.add(String.valueOf(i));
                    valueList.add((Integer) ele.get(String.valueOf(i)));
                }
            }
            for (int j = 1; j < currMonth; j++) {
                monthList.add(String.valueOf(j));
                valueList.add((Integer) ele.get(String.valueOf(j)));
            }
            // 设置酒店类别
            tempMap1.put("hotelType", ele.get("hotel_type"));
            // 设置月份
            tempMap1.put("month", monthList);
            // 设置值
            tempMap1.put("value", valueList);
            resultList.add(tempMap1);
        }
        return resultList;
    }

}
