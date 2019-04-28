package com.hlframe.xhjq.dao.xhfjqData;

import com.hlframe.xhjq.domain.xhfjqData.HotelComment;

import java.util.List;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-10 15:29
 */
public interface HotelCommentDao {
    // 插入数据对象
    Integer insert(HotelComment hotelComment);

    // 计算酒店总数
    Integer countHotel();

    // 计算各类别酒店数量
    List<Map<String,String>> countHotelByType();

    // 计算各类别房间数量
    List<Map<String,String>> countRoomsByType();

    // 五个类别六个维度的平均评论率
    List<Map<String,String>> avgRateByType();

    // 五个类型的平均好评率
    List<Map<String,String>>avgRateByEveryType();
}
