package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
* 终端测试项结果
*
* Created by xiuyou.xu on 2017/09/01.
*/
@ApiModel(value = "PdWorkTestDetailTb", description = "终端测试项结果")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdWorkTestDetailTb extends TrackableEntity {
    
    
    @ApiModelProperty(value="$column.description")
    private String workTestId;
            
    
    @ApiModelProperty(value="$column.description")
    private String workProcedureId;
            
    
    @ApiModelProperty(value="$column.description")
    private String itemId;
            
    
    @ApiModelProperty(value="$column.description")
    private String stepOrder;
            
    
    @ApiModelProperty(value="$column.description")
    private String itemData;
            
    
    @ApiModelProperty(value="$column.description")
    private String testResult;
            
    
    @ApiModelProperty(value="$column.description")
    private String stepLower;
            
    
    @ApiModelProperty(value="$column.description")
    private String stepUpper;
        
        
    public String getWorkTestId () {
        return workTestId;
    }

    public void setWorkTestId (String workTestId) {
        this.workTestId = workTestId;
    }
            
    public String getWorkProcedureId () {
        return workProcedureId;
    }

    public void setWorkProcedureId (String workProcedureId) {
        this.workProcedureId = workProcedureId;
    }
            
    public String getItemId () {
        return itemId;
    }

    public void setItemId (String itemId) {
        this.itemId = itemId;
    }
            
    public String getStepOrder () {
        return stepOrder;
    }

    public void setStepOrder (String stepOrder) {
        this.stepOrder = stepOrder;
    }
            
    public String getItemData () {
        return itemData;
    }

    public void setItemData (String itemData) {
        this.itemData = itemData;
    }
            
    public String getTestResult () {
        return testResult;
    }

    public void setTestResult (String testResult) {
        this.testResult = testResult;
    }
            
    public String getStepLower () {
        return stepLower;
    }

    public void setStepLower (String stepLower) {
        this.stepLower = stepLower;
    }
            
    public String getStepUpper () {
        return stepUpper;
    }

    public void setStepUpper (String stepUpper) {
        this.stepUpper = stepUpper;
    }
        
}
