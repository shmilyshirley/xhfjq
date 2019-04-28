package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.ProvinceHotelInfoDao;
import com.hlframe.xhjq.service.ProvinceHotelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 00:12
 */
@Service("provinceHotelInfoService")
public class ProvinceHotelInfoServiceImpl implements ProvinceHotelInfoService {
    @Autowired
    private ProvinceHotelInfoDao provinceHotelInfoDao;

    public Integer countCustomer(){
        return provinceHotelInfoDao.countCustomer();
    }
}
