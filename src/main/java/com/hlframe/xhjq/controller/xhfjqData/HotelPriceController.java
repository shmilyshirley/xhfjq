package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.service.HotelCommentService;
import com.hlframe.xhjq.service.HotelPriceService;
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

}
