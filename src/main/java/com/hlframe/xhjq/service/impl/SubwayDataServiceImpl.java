package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.subwayData.SubwayDataDao;
import com.hlframe.xhjq.domain.subwayData.SubwayData;
import com.hlframe.xhjq.service.SubwayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-14 09:25
 */
@Service("subwayDataService")
public class SubwayDataServiceImpl implements SubwayDataService {
    @Autowired
    private SubwayDataDao subwayDataDao;

    @Override
    public Integer insert(SubwayData subwayData) {
        return subwayDataDao.insert(subwayData);
    }

    @Override
    public List selectAll() {
        return subwayDataDao.selectAll();
    }

    @Override
    public List selectByDate(String date) {
        return subwayDataDao.selectByDate(date);
    }
}
