package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-上料管理-上料
*
* Created by xiuyou.xu on 2017/09/21.
*/
@ApiModel(value = "DpMaterialsLoad", description = "开发平台-上料管理-上料")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpMaterialsLoad extends TrackableEntity {


    @ApiModelProperty(value="物料名称")
    private String name;


    @ApiModelProperty(value="物料编码")
    private String code;


    @ApiModelProperty(value="类型（批次料，条码料）")
    private String type;
    @ApiModelProperty(value="物料批次号")
    private String batchNumber;


    @ApiModelProperty(value="上料管理ID")
    private String materialInfoId;


    @ApiModelProperty(value="工序ID")
    private String produceProcessId;


    @ApiModelProperty(value="产品线ID")
    private String pdLineId;


    @ApiModelProperty(value="产品ID")
    private String pdId;


    @ApiModelProperty(value="剩余数量")
    private Long remainNum;


    @ApiModelProperty(value="总量")
    private Long loadNum;


    @ApiModelProperty(value="单个产品所需数量")
    private Long unitNum;


    @ApiModelProperty(value="工单ID")
    private String workOrderId;

                
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
            
    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }
            
    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
            
    public String getMaterialInfoId () {
        return materialInfoId;
    }

    public void setMaterialInfoId (String materialInfoId) {
        this.materialInfoId = materialInfoId;
    }
            
    public String getProduceProcessId () {
        return produceProcessId;
    }

    public void setProduceProcessId (String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }
            
    public String getPdLineId () {
        return pdLineId;
    }

    public void setPdLineId (String pdLineId) {
        this.pdLineId = pdLineId;
    }
            
    public String getPdId () {
        return pdId;
    }

    public void setPdId (String pdId) {
        this.pdId = pdId;
    }
            
    public Long getRemainNum () {
        return remainNum;
    }

    public void setRemainNum (Long remainNum) {
        this.remainNum = remainNum;
    }
            
    public Long getLoadNum () {
        return loadNum;
    }

    public void setLoadNum (Long loadNum) {
        this.loadNum = loadNum;
    }
            
    public Long getUnitNum () {
        return unitNum;
    }

    public void setUnitNum (Long unitNum) {
        this.unitNum = unitNum;
    }
            
    public String getWorkOrderId () {
        return workOrderId;
    }

    public void setWorkOrderId (String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }
}
