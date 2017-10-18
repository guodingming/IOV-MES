package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-产品维修站
*
* Created by xiuyou.xu on 2017/08/25.
*/
@ApiModel(value = "DpRepairStation", description = "开发平台-产品维修站")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpRepairStation extends TrackableEntity {

    /**
     * 维修站产品状态
     */
    public static class Status {
        /**
         * 待维修
         */
        public static final String WAIT_REPAIR = "0";
        /**
         * 良品
         */
        public static final String QUALIFIED = "1";
        /**
         * 报废
         */
        public static final String REJECT = "2";
    }

    @ApiModelProperty(value="产品线ID")
    private String dpLineId;
            
    
    @ApiModelProperty(value="产品ID")
    private String pdId;

    @ApiModelProperty(value="产品名称")
    private String pdName;
            
    
    @ApiModelProperty(value="工单ID")
    private String workOrderId;


    @ApiModelProperty(value="属所产品ID")
    private String pdProductInfoId;

    
    @ApiModelProperty(value="工单号")
    private String workOrderNum;
            
    
    @ApiModelProperty(value="批次号")
    private String workOrderBatchNum;
            
    
    @ApiModelProperty(value="状态（待维修：0，已维修：1，报废：2）")
    private String status;

    @ApiModelProperty(value="不良工序")
    private String produceProcessId;
    @ApiModelProperty(value="不良工序编码")
    private String processCode;
    @ApiModelProperty(value="不良工序名称")
    private String processName;
    @ApiModelProperty(value="录入人员ID")
    private String userId;
    @ApiModelProperty(value="录入人员名称")
    private String userName;
    @ApiModelProperty(value="SN")
    private String number;

                
                
    public String getDpLineId () {
        return dpLineId;
    }

    public void setDpLineId (String dpLineId) {
        this.dpLineId = dpLineId;
    }
            
    public String getPdId () {
        return pdId;
    }

    public void setPdId (String pdId) {
        this.pdId = pdId;
    }
            
    public String getWorkOrderId () {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getPdProductInfoId() {
        return pdProductInfoId;
    }

    public void setPdProductInfoId(String pdProductInfoId) {
        this.pdProductInfoId = pdProductInfoId;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getWorkOrderBatchNum() {
        return workOrderBatchNum;
    }

    public void setWorkOrderBatchNum(String workOrderBatchNum) {
        this.workOrderBatchNum = workOrderBatchNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduceProcessId() {
        return produceProcessId;
    }

    public void setProduceProcessId(String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
