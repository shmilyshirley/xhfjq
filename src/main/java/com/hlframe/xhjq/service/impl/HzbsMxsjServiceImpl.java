package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.HzbsMxsjDao;
import com.hlframe.xhjq.domain.HzbsMxsj;
import com.hlframe.xhjq.service.HzbsMxsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-18 14:38
 */
@Service("hzbsMxsjService")
@Transactional(rollbackFor = Exception.class)
public class HzbsMxsjServiceImpl implements HzbsMxsjService {

    @Autowired
    private HzbsMxsjDao hzbsMxsjDao;

    @Override
    public Integer insert(HzbsMxsj hzbsMxsj) {
        return hzbsMxsjDao.insert(hzbsMxsj);
    }

    @Override
    public Integer countHzbsMxsjByDatetime(String datetime) {
        return hzbsMxsjDao.countHzbsMxsjByDatetime(datetime);
    }
}
