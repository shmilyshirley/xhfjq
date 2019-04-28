package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.ChinaHotelInfo12Dao;
import com.hlframe.xhjq.service.ChinaHotelInfo12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 01:53
 */
@Service("chinaHotelInfo12Service")
public class ChinaHotelInfo12ServiceImpl implements ChinaHotelInfo12Service {
    @Autowired
    private ChinaHotelInfo12Dao chinaHotelInfo12Dao;
    @Override
    public Integer countCustomer() {
        return chinaHotelInfo12Dao.countCustomer();
    }

    @Override
    public List countCustomerByTag() {
        return chinaHotelInfo12Dao.countCustomerByTag();
    }
}
