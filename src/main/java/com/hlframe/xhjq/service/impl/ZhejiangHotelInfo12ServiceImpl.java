package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.ZhejiangHotelInfo12Dao;
import com.hlframe.xhjq.service.ZhejiangHotelInfo12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 01:50
 */
@Service("zhejiangHotelInfo12Service")
public class ZhejiangHotelInfo12ServiceImpl implements ZhejiangHotelInfo12Service {
    @Autowired
    private ZhejiangHotelInfo12Dao zhejiangHotelInfo12Dao;
    @Override
    public Integer countCustomer() {
        return zhejiangHotelInfo12Dao.countCustomer();
    }
}
