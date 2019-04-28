package com.hlframe.xhjq.domain;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-17 09:44
 */
public class HzbsData {
    private int id; // 主键
    private String hzbsInfo; // 信息
    private String fields1; // 预留字段1
    private String fields2; // 预留字段2
    private String fields3; // 预留字段3

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHzbsInfo() {
        return hzbsInfo;
    }

    public void setHzbsInfo(String hzbsInfo) {
        this.hzbsInfo = hzbsInfo;
    }

    public String getFields1() {
        return fields1;
    }

    public void setFields1(String fields1) {
        this.fields1 = fields1;
    }

    public String getFields2() {
        return fields2;
    }

    public void setFields2(String fields2) {
        this.fields2 = fields2;
    }

    public String getFields3() {
        return fields3;
    }

    public void setFields3(String fields3) {
        this.fields3 = fields3;
    }
}
