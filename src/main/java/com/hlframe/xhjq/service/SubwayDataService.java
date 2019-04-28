package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.subwayData.SubwayData;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-14 09:24
 */
public interface SubwayDataService {
    Integer insert(SubwayData subwayData);
    List selectAll();
    List selectByDate(String date);
}
