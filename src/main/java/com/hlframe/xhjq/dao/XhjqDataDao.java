package com.hlframe.xhjq.dao;

import com.hlframe.xhjq.domain.XhjqData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface XhjqDataDao {

    XhjqData selectXhjqDataById(@Param("id") Integer id);

//    XhjqData selectXhjqDataByXhjqNameXhjqDate(@Param("xhjqName") String itemCode, @Param("xhjqDate") String itemName);

    Integer insert(XhjqData xhjqData);
}
