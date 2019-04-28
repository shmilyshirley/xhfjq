package com.hlframe.xhjq.dao;

import com.hlframe.xhjq.domain.HzbsData;
import com.hlframe.xhjq.domain.XhjqData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-17 09:56
 */
@Repository
public interface HzbsDataDao {
    HzbsData selectHzbsDataById(@Param("id") Integer id);

    Integer insert(HzbsData hzbsData);
}
