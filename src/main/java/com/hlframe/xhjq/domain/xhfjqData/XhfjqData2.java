package com.hlframe.xhjq.domain.xhfjqData;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-09 15:47
 */
public class XhfjqData2 {

    private String serial_no; // 唯一标识
    private String hksx; // 户口来源地
    private String manage_name; // 旅馆名称
    private String checkout_time; // 离店时间
    private String born_year; // 出生年份
    private String gender; // 性别
    private String checkin_time; // 入住时间

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getHksx() {
        return hksx;
    }

    public void setHksx(String hksx) {
        this.hksx = hksx;
    }

    public String getManage_name() {
        return manage_name;
    }

    public void setManage_name(String manage_name) {
        this.manage_name = manage_name;
    }

    public String getCheckout_time() {
        return checkout_time;
    }

    public void setCheckout_time(String checkout_time) {
        this.checkout_time = checkout_time;
    }

    public String getBorn_year() {
        return born_year;
    }

    public void setBorn_year(String born_year) {
        this.born_year = born_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(String checkin_time) {
        this.checkin_time = checkin_time;
    }
}
