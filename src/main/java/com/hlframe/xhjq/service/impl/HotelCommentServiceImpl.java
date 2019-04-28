package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.HotelCommentDao;
import com.hlframe.xhjq.domain.xhfjqData.HotelComment;
import com.hlframe.xhjq.service.HotelCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-10 15:35
 */
@Service("hotelCommentService")
@Transactional(rollbackFor = Exception.class)
public class HotelCommentServiceImpl implements HotelCommentService {
    @Autowired
    private HotelCommentDao hotelCommentDao;

    @Override
    public Integer insert(HotelComment hotelComment) {
        return null;
    }

    @Override
    public Integer countHotel() {
        return hotelCommentDao.countHotel();
    }

    @Override
    public List countHotelByType() {
        return hotelCommentDao.countHotelByType();
    }

    @Override
    public List countRoomsByType() {
        return hotelCommentDao.countRoomsByType();
    }

    @Override
    public List<Map<String, String>> avgRateByType() {
        return hotelCommentDao.avgRateByType();
    }

    @Override
    public List<Map<String, String>> avgRateByEveryType() {
        return hotelCommentDao.avgRateByEveryType();
    }
}
