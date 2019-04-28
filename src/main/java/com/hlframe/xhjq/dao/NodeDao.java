package com.hlframe.xhjq.dao;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-02-05 14:40
 */
public interface NodeDao {
    String getNodeInfo();

    String getMayNodeInfo();

    String getAprilNodeInfo();

    String getMonthNode(Integer month);
}
