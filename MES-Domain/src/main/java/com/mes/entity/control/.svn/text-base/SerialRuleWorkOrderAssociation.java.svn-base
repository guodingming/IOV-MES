package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-流水规则-规则工单关联
*
* Created by xiuyou.xu on 2017/10/16.
*/
@ApiModel(value = "SerialRuleWorkOrderAssociation", description = "开发平台-流水规则-规则工单关联")
@XmlAccessorType(XmlAccessType.FIELD)
public class SerialRuleWorkOrderAssociation extends TrackableEntity {
            
    
    @ApiModelProperty(value="work_order_id")
    private String workOrderId;

    @ApiModelProperty(value = "pd_id")
    private String pdId;
    
    @ApiModelProperty(value="rule_detail_id")
    private String ruleDetailId;
                        
                
    public String getWorkOrderId () {
        return workOrderId;
    }

    public void setWorkOrderId (String workOrderId) {
        this.workOrderId = workOrderId;
    }
            
    public String getRuleDetailId () {
        return ruleDetailId;
    }

    public void setRuleDetailId (String ruleDetailId) {
        this.ruleDetailId = ruleDetailId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }
}
