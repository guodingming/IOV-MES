package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-流水规则-规则
*
* Created by xiuyou.xu on 2017/10/16.
*/
@ApiModel(value = "SerialRule", description = "开发平台-流水规则-规则")
@XmlAccessorType(XmlAccessType.FIELD)
public class SerialRule extends TrackableEntity {
            
    
    @ApiModelProperty(value="name")
    private String name;
            
    
    @ApiModelProperty(value="step")
    private Long step;
            
    
    @ApiModelProperty(value="start_value")
    private Long startValue;
            
    
    @ApiModelProperty(value="max_value")
    private Long maxValue;
            
    
    @ApiModelProperty(value="digt")
    private Integer digt;
                            
    
    @ApiModelProperty(value="type(按工单日期，按产品，按vin，按工单)")
    private String type;
            
    
    @ApiModelProperty(value="radix_type（hex,dec）")
    private String radixType;
            
    
    @ApiModelProperty(value="code(通配符编码)")
    private String code;

    private String detailId;
        
                
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
            
    public Long getStep () {
        return step;
    }

    public void setStep (Long step) {
        this.step = step;
    }
            
    public Long getStartValue () {
        return startValue;
    }

    public void setStartValue (Long startValue) {
        this.startValue = startValue;
    }
            
    public Long getMaxValue () {
        return maxValue;
    }

    public void setMaxValue (Long maxValue) {
        this.maxValue = maxValue;
    }
            
    public Integer getDigt () {
        return digt;
    }

    public void setDigt (Integer digt) {
        this.digt = digt;
    }
                            
    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
            
    public String getRadixType () {
        return radixType;
    }

    public void setRadixType (String radixType) {
        this.radixType = radixType;
    }
            
    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }
}
