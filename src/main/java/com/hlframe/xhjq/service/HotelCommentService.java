package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.xhfjqData.HotelComment;
import com.hlframe.xhjq.domain.xhfjqData.HotelPrice;

import java.util.List;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-10 15:35
 */
public interface HotelCommentService {
    // 插入数据对象
    Integer insert(HotelComment hotelComment);

    // 计算酒5个类别酒店最低价（1-12月）
    Integer countHotel();

    // 计算各类别酒店数量
    List countHotelByType();

    // 计算各类别房间数量
    List countRoomsByType();

    // 五个类别六个维度的平均评论值
    List<Map<String,String>> avgRateByType();

    // 五个类型的平均好评率
    List<Map<String,String>> avgRateByEveryType();

    // 各类别酒店的最低房价
    List<HotelPrice> lowestHotelPrice();
}
