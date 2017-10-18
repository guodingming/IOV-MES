package com.mes.common.function;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by wanshan.hu on 2017/8/8.
 */
public class FunctionParameter implements Serializable {



    /**
     * 运行状态  (成功：1  失败：0)
     */
    private String status = "1";

    /**
     * 输入参数
     */
    private Map<String, Object> requestMap = Maps.newHashMap();
    /**
     * 返回参数或数据
     */
    private Map<String, Object> responseMap = Maps.newHashMap();

    /**
     * 运行开始时间
     */
    private Date startRunDateTime;

    /**
     * 运行结束时间
     */
    private Date endRunDateTime;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<String, Object> requestMap) {
        this.requestMap = requestMap;
    }

    public Map<String, Object> getResponseMap() {
        return responseMap;
    }

    public void setResponseMap(Map<String, Object> responseMap) {
        this.responseMap = responseMap;
    }

    public Date getStartRunDateTime() {
        return startRunDateTime;
    }

    public void setStartRunDateTime(Date startRunDateTime) {
        this.startRunDateTime = startRunDateTime;
    }

    public Date getEndRunDateTime() {
        return endRunDateTime;
    }

    public void setEndRunDateTime(Date endRunDateTime) {
        this.endRunDateTime = endRunDateTime;
    }
}
