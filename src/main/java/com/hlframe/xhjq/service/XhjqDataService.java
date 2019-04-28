package com.hlframe.xhjq.service;


import com.hlframe.xhjq.domain.XhjqData;

public interface XhjqDataService {

    XhjqData selectXhjqDataById(Integer id);

    Integer insert(XhjqData xhjqData);
}
