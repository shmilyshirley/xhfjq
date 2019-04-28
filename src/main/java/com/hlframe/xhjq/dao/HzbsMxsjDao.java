package com.hlframe.xhjq.dao;

import com.hlframe.xhjq.domain.HzbsMxsj;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-18 14:35
 */
public interface HzbsMxsjDao {
    // 插入数据对象
    Integer insert(HzbsMxsj hzbsMxsj);
    // 通过时间计数记录条数
    Integer countHzbsMxsjByDatetime(String datetime);
}
