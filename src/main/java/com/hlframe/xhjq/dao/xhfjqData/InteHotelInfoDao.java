package com.hlframe.xhjq.dao.xhfjqData;

import com.hlframe.xhjq.domain.xhfjqData.Vo;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 00:58
 */
public interface InteHotelInfoDao {
    Integer countCustomer();

    List<Vo> occupancyRate();
}
