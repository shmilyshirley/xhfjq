package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.HzbsMxsj;
import com.hlframe.xhjq.domain.xhfjqData.XhfjqData2;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-09 15:53
 */
public interface XhfjqData2Service {
    // 插入数据对象
    Integer insert(XhfjqData2 xhfjqData2);
    // 通过时间计数记录条数
    Integer selectXhfjqData2BySerial(String serial);

    List selectAll();

    List selectByDate(String checkin_time);
}
