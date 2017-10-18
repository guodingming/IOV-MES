package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

/**
* 软件注入结果记录
*
* Created by xiuyou.xu on 2017/09/01.
*/
@ApiModel(value = "PdExecSoftinjectTb", description = "软件注入结果记录")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdExecSoftinjectTb extends TrackableEntity {
    
    
    @ApiModelProperty(value="$column.description")
    private String serialId;
            
    
    @ApiModelProperty(value="$column.description")
    private String productSerialId;
            
    
    @ApiModelProperty(value="$column.description")
    private String addr;
            
    
    @ApiModelProperty(value="$column.description")
    private String content;
            
    
    @ApiModelProperty(value="$column.description")
    private String preContent;
            
    
    @ApiModelProperty(value="$column.description")
    private Date operDate;
        
        
    public String getSerialId () {
        return serialId;
    }

    public void setSerialId (String serialId) {
        this.serialId = serialId;
    }
            
    public String getProductSerialId () {
        return productSerialId;
    }

    public void setProductSerialId (String productSerialId) {
        this.productSerialId = productSerialId;
    }
            
    public String getAddr () {
        return addr;
    }

    public void setAddr (String addr) {
        this.addr = addr;
    }
            
    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }
            
    public String getPreContent () {
        return preContent;
    }

    public void setPreContent (String preContent) {
        this.preContent = preContent;
    }
            
    public Date getOperDate () {
        return operDate;
    }

    public void setOperDate (Date operDate) {
        this.operDate = operDate;
    }
        
}
