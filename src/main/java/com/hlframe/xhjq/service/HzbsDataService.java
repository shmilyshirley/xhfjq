package com.hlframe.xhjq.service;

import com.hlframe.xhjq.domain.HzbsData;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-17 09:58
 */
public interface HzbsDataService {

    HzbsData selectXhjqDataById(Integer id);

    Integer insert(HzbsData xhjqData);
}
