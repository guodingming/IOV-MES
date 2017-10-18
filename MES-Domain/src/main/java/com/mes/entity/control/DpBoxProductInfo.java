package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-包装箱-产品
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpBoxProductInfo", description = "开发平台-包装箱-产品")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpBoxProductInfo extends TrackableEntity {
    @ApiModelProperty(value = "属所生产产品ID")
    private String pdProductInfoId;
    @ApiModelProperty(value = "产品名称")
    private String pdName;
    @ApiModelProperty(value = "软件信息")
    private String softVersion;
    @ApiModelProperty(value = "硬件版本")
    private String hardVersion;
    @ApiModelProperty(value = "工单ID")
    private String workOrderId;
    @ApiModelProperty(value = "属所产品ID")
    private String pdId;
    @ApiModelProperty(value = "批次号")
    private String workOrderBatchNum;
    @ApiModelProperty(value = "包装箱ID")
    private String boxId;
    @ApiModelProperty(value = "包装箱号")
    private String boxKey;
    @ApiModelProperty(value = "SN号")
    private String number;
    @ApiModelProperty(value = "工单号")
    private String workOrderNum;

    public String getPdProductInfoId() {
        return pdProductInfoId;
    }

    public void setPdProductInfoId(String pdProductInfoId) {
        this.pdProductInfoId = pdProductInfoId;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public String getHardVersion() {
        return hardVersion;
    }

    public void setHardVersion(String hardVersion) {
        this.hardVersion = hardVersion;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getWorkOrderBatchNum() {
        return workOrderBatchNum;
    }

    public void setWorkOrderBatchNum(String workOrderBatchNum) {
        this.workOrderBatchNum = workOrderBatchNum;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getBoxKey() {
        return boxKey;
    }

    public void setBoxKey(String boxKey) {
        this.boxKey = boxKey;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }
}
