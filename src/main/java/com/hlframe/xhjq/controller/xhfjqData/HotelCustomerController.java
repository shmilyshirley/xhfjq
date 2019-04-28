package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 01:21
 */
@RestController
@RequestMapping(value = "hotelCustomer")
public class HotelCustomerController {
    @Autowired
    private ProvinceHotelInfoService provinceHotelInfoService;
    @Autowired
    private InteHotelInfoService inteHotelInfoService;
    @Autowired
    private InteHotelInfo12Service inteHotelInfo12Service;
    @Autowired
    private ZhejiangHotelInfo12Service zhejiangHotelInfo12Service;
    @Autowired
    private ChinaHotelInfo12Service chinaHotelInfo12Service;
    @Autowired
    private HotelCommentService hotelCommentService;
    /**
     * 计数12月份的客流量
     * @return
     */
    @RequestMapping(value = "countDec")
    public Integer countDec(){
        return inteHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer() + zhejiangHotelInfo12Service.countCustomer();
    }

    /**
     * 计数1-11月份的客流量
     * @return
     */
    @RequestMapping(value = "countJanToNov")
    public Integer countJanToNov(){
        return inteHotelInfoService.countCustomer() + provinceHotelInfoService.countCustomer();
    }

    /**
     * 计数全国全年(1-12月份)的客流量(除浙江省)
     * @return
     */
    @RequestMapping(value = "countTotal")
    public Integer countTotal(){
        return inteHotelInfoService.countCustomer() + inteHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer() + zhejiangHotelInfo12Service.countCustomer() + provinceHotelInfoService.countCustomer();
    }

    /**
     * 计算全国+国际1-12月份入住率(入住率=入住总人数/房间数)
     * @return
     */
    @RequestMapping(value = "occupancyRate")
        public Map occupancyRate(){
        Map map = new LinkedHashMap();
        map.put("入住率",(inteHotelInfoService.countCustomer() + inteHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer() + zhejiangHotelInfo12Service.countCustomer() + provinceHotelInfoService.countCustomer())/hotelCommentService.countHotel());
        return map;
    }

}