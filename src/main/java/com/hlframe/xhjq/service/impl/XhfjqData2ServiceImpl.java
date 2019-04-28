package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.xhfjqData.XhfjqData2Dao;
import com.hlframe.xhjq.domain.xhfjqData.XhfjqData2;
import com.hlframe.xhjq.service.XhfjqData2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-09 15:52
 */
@Service("xhfjqData2Service")
@Transactional(rollbackFor = Exception.class)
public class XhfjqData2ServiceImpl implements XhfjqData2Service {
    @Autowired
    private XhfjqData2Dao xhfjqData2Dao;

    @Override
    public Integer insert(XhfjqData2 xhfjqData2) {
        return xhfjqData2Dao.insert(xhfjqData2);
    }

    @Override
    public Integer selectXhfjqData2BySerial(String serial) {
        return xhfjqData2Dao.selectXhfjqData2BySerial(serial);
    }

    @Override
    public List selectAll() {
        return xhfjqData2Dao.selectAll();
    }

    @Override
    public List selectByDate(String checkin_time) {
        return xhfjqData2Dao.selectByDate(checkin_time);
    }
}
