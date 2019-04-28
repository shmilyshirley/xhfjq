package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.xhfjqData.HotelComment;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-10 15:35
 */
public interface HotelPriceService {
    // 插入数据对象
    Integer insert(HotelComment hotelComment);

    // 计算酒店总数
    List countLowestPriceByType();

}
