package com.mes.entity.control;

/**
 * 工序日志
 * <p>
 * Created by xiuyou.xu on 2017/9/24.
 */
public class ProcessLog {
    /**
     * 日志级别
     */
    private String level;
    private String barCode;
    private String pdLineId;
    private String pdLineName;
    private String pdId;
    private String pdName;
    private String processId;
    private String processName;
    private String workOrderId;
    private String workOrderNum;
    private String content;
    private String time;

    public String getPdLineName() {
        return pdLineName;
    }

    public void setPdLineName(String pdLineName) {
        this.pdLineName = pdLineName;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPdLineId() {
        return pdLineId;
    }

    public void setPdLineId(String pdLineId) {
        this.pdLineId = pdLineId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
