package com.hlframe.xhjq.service;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-02-05 14:52
 */
public interface NodeService {
    String getNodeInfo();

    String getMayNodeInfo();

    String getAprilNodeInfo();

    String getMonthNode(Integer month);
}
