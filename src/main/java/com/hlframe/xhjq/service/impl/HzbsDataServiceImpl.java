package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.HzbsDataDao;
import com.hlframe.xhjq.domain.HzbsData;
import com.hlframe.xhjq.service.HzbsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-17 10:00
 */
@Service("hzbsDataService")
@Transactional(rollbackFor = Exception.class)
public class HzbsDataServiceImpl implements HzbsDataService {
    @Autowired
    private HzbsDataDao hzbsDataDao;
    @Override
    public HzbsData selectXhjqDataById(Integer id) {
        return null;
    }

    @Override
    public Integer insert(HzbsData hzbsData) {
        return hzbsDataDao.insert(hzbsData);
    }
}
