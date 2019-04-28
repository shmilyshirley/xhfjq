package com.hlframe.xhjq.domain.API;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-19 11:24
 */
public class DepthHis {

    private String id;
    private String boatNo;
    private String timeStampStr;
    private String timeStamp;
    private double depth;
    private List location;

    public DepthHis() {
    }

    public List getLocation() {
        return location;
    }

    public void setLocation(List location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBoatNo() {
        return boatNo;
    }

    public void setBoatNo(String boatNo) {
        this.boatNo = boatNo;
    }

    public String getTimeStampStr() {
        return timeStampStr;
    }

    public void setTimeStampStr(String timeStampStr) {
        this.timeStampStr = timeStampStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }



    @Override
    public String toString() {
        return "DepthHis{" +
                "id='" + id + '\'' +
                ", boatNo='" + boatNo + '\'' +
                ", timeStampStr='" + timeStampStr + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", depth=" + depth +
                ", location=" + location +
                '}';
    }
}
