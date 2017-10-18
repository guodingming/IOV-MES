package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;

/**
 * Created by xiuyou.xu on 2017/8/18.
 */
public class DpServiceInvocation extends TrackableEntity {
    private String code;
    private String path;
    private String status;
    private String tookTime;
    private String startTime;
    private String params;
    private String result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTookTime() {
        return tookTime;
    }

    public void setTookTime(String tookTime) {
        this.tookTime = tookTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
