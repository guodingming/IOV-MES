package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
* $table.description
*
* Created by xiuyou.xu on 2017/09/01.
*/
@ApiModel(value = "PdExecTransmitSetTb", description = "$table.description")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdExecTransmitSetTb extends TrackableEntity {
    
    
    @ApiModelProperty(value="$column.description")
    private String sendModule;
            
    
    @ApiModelProperty(value="$column.description")
    private String sendSubModule;
            
    
    @ApiModelProperty(value="$column.description")
    private String sendMessage;
            
    
    @ApiModelProperty(value="$column.description")
    private String receiveModule;
            
    
    @ApiModelProperty(value="$column.description")
    private String receiveSubModule;
            
    
    @ApiModelProperty(value="$column.description")
    private String receiveMessage;
        
        
    public String getSendModule () {
        return sendModule;
    }

    public void setSendModule (String sendModule) {
        this.sendModule = sendModule;
    }
            
    public String getSendSubModule () {
        return sendSubModule;
    }

    public void setSendSubModule (String sendSubModule) {
        this.sendSubModule = sendSubModule;
    }
            
    public String getSendMessage () {
        return sendMessage;
    }

    public void setSendMessage (String sendMessage) {
        this.sendMessage = sendMessage;
    }
            
    public String getReceiveModule () {
        return receiveModule;
    }

    public void setReceiveModule (String receiveModule) {
        this.receiveModule = receiveModule;
    }
            
    public String getReceiveSubModule () {
        return receiveSubModule;
    }

    public void setReceiveSubModule (String receiveSubModule) {
        this.receiveSubModule = receiveSubModule;
    }
            
    public String getReceiveMessage () {
        return receiveMessage;
    }

    public void setReceiveMessage (String receiveMessage) {
        this.receiveMessage = receiveMessage;
    }
        
}
