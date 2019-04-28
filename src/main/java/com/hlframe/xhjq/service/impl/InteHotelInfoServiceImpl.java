package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.InteHotelInfoDao;
import com.hlframe.xhjq.service.InteHotelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 00:59
 */
@Service("inteHotelInfoService")
public class InteHotelInfoServiceImpl implements InteHotelInfoService {
    @Autowired
    private InteHotelInfoDao inteHotelInfoDao;

    @Override
    public Integer countCustomer() {
        return inteHotelInfoDao.countCustomer();
    }
}
