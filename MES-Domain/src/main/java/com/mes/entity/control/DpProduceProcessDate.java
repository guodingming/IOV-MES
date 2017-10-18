package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-生产工序配置-工序执行时间
*
* Created by xiuyou.xu on 2017/08/30.
*/
@ApiModel(value = "DpProduceProcessDate", description = "开发平台-生产工序配置-工序执行时间")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpProduceProcessDate extends TrackableEntity {
            
    
    @ApiModelProperty(value="属所生产工序ID")
    private String produceProcessId;
            
    
    @ApiModelProperty(value="expression")
    private String expression;
            
    
    @ApiModelProperty(value="unit")
    private String unit;
            
    
    @ApiModelProperty(value="data")
    private String data;
                
                
    public String getProduceProcessId () {
        return produceProcessId;
    }

    public void setProduceProcessId (String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }
            
    public String getExpression () {
        return expression;
    }

    public void setExpression (String expression) {
        this.expression = expression;
    }
            
    public String getUnit () {
        return unit;
    }

    public void setUnit (String unit) {
        this.unit = unit;
    }
            
    public String getData () {
        return data;
    }

    public void setData (String data) {
        this.data = data;
    }
                
}
