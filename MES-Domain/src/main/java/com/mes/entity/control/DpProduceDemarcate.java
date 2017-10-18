package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-产品标定
*
* Created by xiuyou.xu on 2017/08/30.
*/
@ApiModel(value = "DpProduceDemarcate", description = "开发平台-产品标定")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpProduceDemarcate extends TrackableEntity {
            
    
    @ApiModelProperty(value="属所生产工序ID")
    private String produceProcessId;
            
    
    @ApiModelProperty(value="sd_id")
    private String sdId;
            
    
    @ApiModelProperty(value="sd_name")
    private String sdName;
            
    
    @ApiModelProperty(value="sd_data")
    private String sdData;
                    
    
    @ApiModelProperty(value="记录在excel中的顺序号")
    private Long order;
        
                
    public String getProduceProcessId () {
        return produceProcessId;
    }

    public void setProduceProcessId (String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }
            
    public String getSdId () {
        return sdId;
    }

    public void setSdId (String sdId) {
        this.sdId = sdId;
    }
            
    public String getSdName () {
        return sdName;
    }

    public void setSdName (String sdName) {
        this.sdName = sdName;
    }
            
    public String getSdData () {
        return sdData;
    }

    public void setSdData (String sdData) {
        this.sdData = sdData;
    }
                    
    public Long getOrder () {
        return order;
    }

    public void setOrder (Long order) {
        this.order = order;
    }
        
}
