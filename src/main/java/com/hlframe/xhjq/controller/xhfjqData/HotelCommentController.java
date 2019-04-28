package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.service.HotelCommentService;
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
@RequestMapping(value = "hotelComment")
public class HotelCommentController {
    @Autowired
    private HotelCommentService hotelCommentService;

    /**
     * 计算酒店总数
     * @return
     */
    @RequestMapping(value = "countHotel")
    public Map countHotel (){
        Integer integer = hotelCommentService.countHotel();
        Map map = new HashMap<String,String>();
        map.put("酒店总数",integer.toString());
        return map;
    }

    /**
     * 计算各类别酒店数量
     * @return
     */
    @RequestMapping(value = "countHotelByType")
    public List countHotelByType(){
        return hotelCommentService.countHotelByType();
    }

    /**
     * 计算各类别酒店的房间数量
     * @return
     */
    @RequestMapping(value = "countRoomsByType")
    public List countRoomsByType(){
        return hotelCommentService.countRoomsByType();
    }

    /**
     * 五个类别六个维度的平均评论率
     * @return
     */
    @RequestMapping(value = "avgRateByType")
    public List avgRateByType(){
        return hotelCommentService.avgRateByType();
    }

    /**
     * 五个类型的平均好评率
     * @return
     */
    @RequestMapping(value = "avgRateByEveryType")
    public List avgRateByEveryType(){
        return hotelCommentService.avgRateByEveryType();
    }
}
