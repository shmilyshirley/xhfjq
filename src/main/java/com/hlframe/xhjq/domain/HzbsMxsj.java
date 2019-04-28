package com.hlframe.xhjq.domain;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-18 14:28
 */
public class HzbsMxsj {
    private Integer id; // 主键id
    private String date; // 时间
    private String name; // 片区
    private String device_name; // 机器名
    private String mark; // 机器编号
    private String address; // 地址
    private String isWork; // 时间类型
    private String service_item; // 业务大类
    private String service_itemX; // 业务小类
    private Integer play_count; // 办件量
    private String datetime; // 记录时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getService_item() {
        return service_item;
    }

    public void setService_item(String service_item) {
        this.service_item = service_item;
    }

    public String getService_itemX() {
        return service_itemX;
    }

    public void setService_itemX(String service_itemX) {
        this.service_itemX = service_itemX;
    }

    public Integer getPlay_count() {
        return play_count;
    }

    public void setPlay_count(Integer play_count) {
        this.play_count = play_count;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "HzbsMxsj{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", device_name='" + device_name + '\'' +
                ", mark='" + mark + '\'' +
                ", address='" + address + '\'' +
                ", isWork='" + isWork + '\'' +
                ", service_item='" + service_item + '\'' +
                ", service_itemX='" + service_itemX + '\'' +
                ", play_count=" + play_count +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
