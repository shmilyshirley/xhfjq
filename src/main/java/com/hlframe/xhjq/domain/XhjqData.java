package com.hlframe.xhjq.domain;

/**
 * Company:华量软件
 * Author:fanjh
 * 数据采集实体类，对应数据表名称：xhjq_data
 */
public class XhjqData {

    private int id; // ID主键
    private String xhjqName; // 名称
    private Integer xhjqPeopleNumber; // 客流量
    private String xhjqDatetime; // 时间

    public Integer getXhjqPeopleNumber() {
        return xhjqPeopleNumber;
    }

    public void setXhjqPeopleNumber(Integer xhjqPeopleNumber) {
        this.xhjqPeopleNumber = xhjqPeopleNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXhjqName() {
        return xhjqName;
    }

    public void setXhjqName(String xhjqName) {
        this.xhjqName = xhjqName;
    }

    public String getXhjqDatetime() {
        return xhjqDatetime;
    }

    public void setXhjqDatetime(String xhjqDatetime) {
        this.xhjqDatetime = xhjqDatetime;
    }
}
