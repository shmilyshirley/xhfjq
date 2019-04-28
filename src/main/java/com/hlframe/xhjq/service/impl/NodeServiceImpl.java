package com.hlframe.xhjq.service.impl;

import com.hlframe.xhjq.dao.NodeDao;
import com.hlframe.xhjq.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-02-05 15:03
 */
@Service("nodeService")
@Transactional(rollbackFor = Exception.class)
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeDao nodeDao;

    @Override
    public String getNodeInfo() {
        return nodeDao.getNodeInfo();
    }

    @Override
    public String getMayNodeInfo() {
        return nodeDao.getMayNodeInfo();
    }

    @Override
    public String getAprilNodeInfo() {
        return nodeDao.getAprilNodeInfo();
    }

    @Override
    public String getMonthNode(Integer month) {
        return nodeDao.getMonthNode(month);
    }
}
