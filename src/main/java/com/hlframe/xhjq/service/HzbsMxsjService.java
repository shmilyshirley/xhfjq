package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.HzbsMxsj;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-18 14:37
 */
public interface HzbsMxsjService {
    // 插入数据对象
    Integer insert(HzbsMxsj hzbsMxsj);
    // 通过时间计数记录条数
    Integer countHzbsMxsjByDatetime(String datetime);
}
