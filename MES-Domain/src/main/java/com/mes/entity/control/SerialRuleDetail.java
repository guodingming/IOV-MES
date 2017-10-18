package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-流水规则-明细
*
* Created by xiuyou.xu on 2017/10/16.
*/
@ApiModel(value = "SerialRuleDetail", description = "开发平台-流水规则-明细")
@XmlAccessorType(XmlAccessType.FIELD)
public class SerialRuleDetail extends TrackableEntity {
            
    
    @ApiModelProperty(value="rule_id")
    private String ruleId;
            
    
    @ApiModelProperty(value="current_value")
    private Long currentValue;

    @ApiModelProperty(value = "use_up")
    private Boolean useUp;

    @ApiModelProperty(value = "version")
    private long version = 0;
                        
                
    public String getRuleId () {
        return ruleId;
    }

    public void setRuleId (String ruleId) {
        this.ruleId = ruleId;
    }
            
    public Long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Long currentValue) {
        this.currentValue = currentValue;
    }

    public Boolean getUseUp() {
        return useUp;
    }

    public void setUseUp(Boolean useUp) {
        this.useUp = useUp;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
