package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.InteHotelInfo12Dao;
import com.hlframe.xhjq.service.InteHotelInfo12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 01:42
 */
@Service("inteHotelInfo12Service")
public class InteHotelInfo12ServiceImpl implements InteHotelInfo12Service {
    @Autowired
    private InteHotelInfo12Dao inteHotelInfo12Dao;
    @Override
    public Integer countCustomer() {
        return inteHotelInfo12Dao.countCustomer();
    }

    @Override
    public List top9() {
        return inteHotelInfo12Dao.top9();
    }

    @Override
    public Integer totalPeoNum() {
        return inteHotelInfo12Dao.totalPeoNum();
    }
}
