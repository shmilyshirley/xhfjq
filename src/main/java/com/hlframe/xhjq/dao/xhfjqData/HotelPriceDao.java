package com.hlframe.xhjq.dao.xhfjqData;

import com.hlframe.xhjq.domain.xhfjqData.ChinaHotelInfo12;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-10 15:11
 */
public interface HotelPriceDao {
    // 插入数据对象
    Integer insert(ChinaHotelInfo12 chinaHotelInfo12);

    // 计算酒店总数
    List countLowestPriceByType();

    List test();

}
