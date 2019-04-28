package com.hlframe.xhjq.domain.API;

import java.util.List;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-19 13:56
 */
public class DepthObject {

    private Boolean success;
    private int code;
    private String message;
    private Map<String, List<DepthHis>> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, List<DepthHis>> getData() {
        return data;
    }

    public void setData(Map<String, List<DepthHis>> data) {
        this.data = data;
    }

    public DepthObject() {
    }

    @Override
    public String toString() {
        return "DepthObject{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
