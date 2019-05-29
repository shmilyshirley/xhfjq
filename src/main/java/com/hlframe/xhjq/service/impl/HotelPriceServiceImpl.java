package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.HotelCommentDao;
import com.hlframe.xhjq.dao.xhfjqData.HotelPriceDao;
import com.hlframe.xhjq.domain.xhfjqData.HotelComment;
import com.hlframe.xhjq.domain.xhfjqData.HotelPrice;
import com.hlframe.xhjq.service.HotelCommentService;
import com.hlframe.xhjq.service.HotelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-10 15:35
 */
@Service("hotelPriceService")
@Transactional(rollbackFor = Exception.class)
public class HotelPriceServiceImpl implements HotelPriceService {
    @Autowired
    private HotelPriceDao hotelPriceDao;

    @Override
    public Integer insert(HotelComment hotelComment) {
        return null;
    }

    @Override
    public List<HotelPrice> countLowestPriceByType() {
        return hotelPriceDao.countLowestPriceByType();
    }

    @Override
    public List test() {
        return hotelPriceDao.test();
    }

}
