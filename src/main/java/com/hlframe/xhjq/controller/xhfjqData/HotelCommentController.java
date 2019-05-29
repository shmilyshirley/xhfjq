package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.domain.xhfjqData.HotelPrice;
import com.hlframe.xhjq.service.HotelCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@Api(tags="HotelCommentController",description="user的控制层")
public class HotelCommentController {
    @Autowired
    private HotelCommentService hotelCommentService;

    /**
     * 计算酒店总数
     * @return
     */
    @ApiOperation(value="注册", notes="注册用户",tags = "注册用户",httpMethod = "GET")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = Void.class),
            @ApiResponse(code = 400, message = "参数错误", response = Void.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class)
    })
    @RequestMapping(value = "countHotel",method = RequestMethod.GET)
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

    /**
     * 各类别酒店的最低房价
     * @return
     */
    @RequestMapping(value = "lowestHotelPrice")
    public List lowestHotelPrice(){
        Map map = new HashMap<String,String>();
        List<HotelPrice> list = hotelCommentService.lowestHotelPrice();
        List<Map<String,String>> resultList = new ArrayList<>();
        for (HotelPrice hotelPrice : list){
            Map map2 = new HashMap<String,String>();
            map2.put("hotel_type",hotelPrice.getHotel_type());
            map2.put("lowPrice",hotelPrice.getDec());
            List list2 = new ArrayList<>();
            list2.add(hotelPrice.getDec() != null ? hotelPrice.getDec() : 0);
            resultList.add(map2);
        }

        return resultList;
    }
}
