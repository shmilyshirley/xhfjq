package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.XhjqDataDao;
import com.hlframe.xhjq.domain.XhjqData;
import com.hlframe.xhjq.service.XhjqDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("xhjqDataService")
@Transactional(rollbackFor = Exception.class)
public class XhjqDataServiceImpl implements XhjqDataService {

    @Autowired
    private XhjqDataDao xhjqDataDao;

    @Override
    public XhjqData selectXhjqDataById(Integer id) {
        return xhjqDataDao.selectXhjqDataById(id);
    }

    @Override
    public Integer insert(XhjqData xhjqData) {
        return xhjqDataDao.insert(xhjqData);
    }
}
