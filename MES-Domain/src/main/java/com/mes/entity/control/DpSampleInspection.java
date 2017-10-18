package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 产品管理-抽检管理
*
* Created by xiuyou.xu on 2017/09/12.
*/
@ApiModel(value = "DpSampleInspection", description = "产品管理-抽检管理")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpSampleInspection extends TrackableEntity {
            
    
    @ApiModelProperty(value="产线ID")
    private String pdLineId;
            
    
    @ApiModelProperty(value="产品ID")
    private String pdId;
            
    
    @ApiModelProperty(value="工单ID")
    private String workOrderId;
            
    
    @ApiModelProperty(value="已抽检数量")
    private Long sampleNum;


    @ApiModelProperty(value="抽检数量")
    private Long inspectionNum;

    
    @ApiModelProperty(value="合格数量")
    private Long qualifiedNum;
            
    
    @ApiModelProperty(value="不合格数量")
    private Long unqualiedNum;
            
    
    @ApiModelProperty(value="抽检结果（1：合格，2：批退）")
    private String result;
                
                
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
            
    public String getWorkOrderId () {
        return workOrderId;
    }

    public void setWorkOrderId (String workOrderId) {
        this.workOrderId = workOrderId;
    }
            
    public Long getSampleNum () {
        return sampleNum;
    }

    public void setSampleNum (Long sampleNum) {
        this.sampleNum = sampleNum;
    }
            
    public Long getQualifiedNum () {
        return qualifiedNum;
    }

    public void setQualifiedNum (Long qualifiedNum) {
        this.qualifiedNum = qualifiedNum;
    }
            
    public Long getUnqualiedNum () {
        return unqualiedNum;
    }

    public void setUnqualiedNum (Long unqualiedNum) {
        this.unqualiedNum = unqualiedNum;
    }
            
    public String getResult () {
        return result;
    }

    public void setResult (String result) {
        this.result = result;
    }

    public Long getInspectionNum() {
        return inspectionNum;
    }

    public void setInspectionNum(Long inspectionNum) {
        this.inspectionNum = inspectionNum;
    }
}
