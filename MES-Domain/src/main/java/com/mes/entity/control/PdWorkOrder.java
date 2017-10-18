package com.mes.entity.control;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 产品管理-工单管理
 */
@ApiModel(value = "PdWorkOrder", description = "产品管理-工单管理")
public class PdWorkOrder extends TrackableEntity {
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "订单名称")
    private String orderName;
    @ApiModelProperty(value = "产品ID")
    private String pdId;
    @ApiModelProperty(value = "父工单")
    private String parentId;
    @ApiModelProperty(value = "开工单数量")
    private Long workOrderTotal;
    @ApiModelProperty(value = "工单计划开始时间", example = "2016-08-01 12:24:36")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;
    @ApiModelProperty(value = "工单计划完结时间", example = "2016-08-01 12:24:36")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;
    @ApiModelProperty(value = "工单实际开始时间（手动）", example = "2016-08-01 12:24:36")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date realStartTime;
    @ApiModelProperty(value = "工单实际完结时间（手动）", example = "2016-08-01 12:24:36")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date realEndTime;
    @ApiModelProperty(value = "工单状态（未启动、正在生产、完结）")
    private String status;
    @ApiModelProperty(value = "对应工艺路径部署状态（部署、未部署）")
    private String deployStatus;
    @ApiModelProperty(value = "批次规则ID（选择条码规则）")
    private String barcodeRulesId;
    @ApiModelProperty(value = "批次规则分类ID（选择条码规则分类）")
    private String barcodeRulesTypeId;
    @ApiModelProperty(value = "BOM_ID")
    private String bomWorkId;
    @ApiModelProperty(value = "BOM名称")
    private String bomName;
    @ApiModelProperty(value = "工单号(生产规则ID)")
    private String workOrderRulesId;
    @ApiModelProperty(value = "工单号(生产规则分类ID)")
    private String workOrderRulesTypeId;
    @ApiModelProperty(value = "工单号")
    private String workOrderNum;
    @ApiModelProperty(value = "工程ID")
    private String projectId;
    @ApiModelProperty(value = "工艺路径ID")
    private String routeId;
    @ApiModelProperty(value = "追溯码规则ID（选择条码规则）")
    private String traceCodeRulesId;
    @ApiModelProperty(value = "连版数量")
    private Integer num;
    @ApiModelProperty(value = "流水号规则id")
    private String serialRuleId;
    @ApiModelProperty(value = "生产线ID")
    private String productionLineId;
    @ApiModelProperty(value = "班次ID")
    private String shiftId;
    @ApiModelProperty(value = "流水号详情id")
    private String serialRuleDetailId;

    public String getSerialRuleDetailId() {
        return serialRuleDetailId;
    }

    public void setSerialRuleDetailId(String serialRuleDetailId) {
        this.serialRuleDetailId = serialRuleDetailId;
    }


    /**
     * 工单状态
     */
    public static class PdWorkOrderStatus {
        /**
         * 未开工
         */
        public static final String STATUS_INIT = "1";
        /**
         * 生产中
         */
        public static final String STATUS_START = "2";
        /**
         * 已完工
         */
        public static final String STATUS_STOP = "3";
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getWorkOrderTotal() {
        return workOrderTotal;
    }

    public void setWorkOrderTotal(Long workOrderTotal) {
        this.workOrderTotal = workOrderTotal;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Date getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    public Date getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeployStatus() {
        return deployStatus;
    }

    public void setDeployStatus(String deployStatus) {
        this.deployStatus = deployStatus;
    }

    public String getBarcodeRulesId() {
        return barcodeRulesId;
    }

    public void setBarcodeRulesId(String barcodeRulesId) {
        this.barcodeRulesId = barcodeRulesId;
    }

    public String getBarcodeRulesTypeId() {
        return barcodeRulesTypeId;
    }

    public void setBarcodeRulesTypeId(String barcodeRulesTypeId) {
        this.barcodeRulesTypeId = barcodeRulesTypeId;
    }

    public String getBomWorkId() {
        return bomWorkId;
    }

    public void setBomWorkId(String bomWorkId) {
        this.bomWorkId = bomWorkId;
    }

    public String getBomName() {
        return bomName;
    }

    public void setBomName(String bomName) {
        this.bomName = bomName;
    }

    public String getWorkOrderRulesId() {
        return workOrderRulesId;
    }

    public void setWorkOrderRulesId(String workOrderRulesId) {
        this.workOrderRulesId = workOrderRulesId;
    }

    public String getWorkOrderRulesTypeId() {
        return workOrderRulesTypeId;
    }

    public void setWorkOrderRulesTypeId(String workOrderRulesTypeId) {
        this.workOrderRulesTypeId = workOrderRulesTypeId;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTraceCodeRulesId() {
        return traceCodeRulesId;
    }

    public void setTraceCodeRulesId(String traceCodeRulesId) {
        this.traceCodeRulesId = traceCodeRulesId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSerialRuleId() {
        return serialRuleId;
    }

    public void setSerialRuleId(String serialRuleId) {
        this.serialRuleId = serialRuleId;
    }

    public String getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(String productionLineId) {
        this.productionLineId = productionLineId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }
}
