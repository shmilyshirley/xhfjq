package com.hlframe.xhjq.domain.subwayData;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-09 19:37
 */
public class SubwayData {
    private String name; // 地铁站名称
    private String start_time; // 开始时间
    private Integer exit_flow; // 出客流量
    private String end_time; // 结束时间
    private String stat_id; // 唯一主键
    private String business_day; // 工作日
    private Integer entry_flow; // 进站客流

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Integer getExit_flow() {
        return exit_flow;
    }

    public void setExit_flow(Integer exit_flow) {
        this.exit_flow = exit_flow;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStat_id() {
        return stat_id;
    }

    public void setStat_id(String stat_id) {
        this.stat_id = stat_id;
    }

    public String getBusiness_day() {
        return business_day;
    }

    public void setBusiness_day(String business_day) {
        this.business_day = business_day;
    }

    public Integer getEntry_flow() {
        return entry_flow;
    }

    public void setEntry_flow(Integer entry_flow) {
        this.entry_flow = entry_flow;
    }
}
