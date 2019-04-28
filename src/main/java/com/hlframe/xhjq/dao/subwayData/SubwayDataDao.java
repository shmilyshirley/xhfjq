package com.hlframe.xhjq.dao.subwayData;

import com.hlframe.xhjq.domain.subwayData.SubwayData;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-09 19:43
 */
public interface SubwayDataDao {
    Integer insert(SubwayData subwayData);
    List selectAll();
    List selectByDate(String date);
}
