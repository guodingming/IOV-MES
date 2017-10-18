package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
* 开发平台-生产工序-工装配置信息
*
* Created by xiuyou.xu on 2017/09/22.
*/
@ApiModel(value = "DpProduceProcessAnnex", description = "开发平台-生产工序-工装配置信息")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpProduceProcessAnnex extends TrackableEntity {
            
    
    @ApiModelProperty(value="属所生产工序ID")
    private String produceProcessId;
            
    
    @ApiModelProperty(value="procedure_name")
    private String procedureName;
            
    
    @ApiModelProperty(value="设备工序工装信息关联ID")
    private String deviceProcessAnnexAssociationId;
    @ApiModelProperty(value="工装编码")
    private String number;
    @ApiModelProperty(value="工装名称")
    private String name;

    private String deviceProcessAnnexId;
    private String deviceProcessId;
    @ApiModelProperty(value="工装ID")
    private String deviceAnnexInfoId;
                
                
    public String getProduceProcessId () {
        return produceProcessId;
    }

    public void setProduceProcessId (String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }
            
    public String getProcedureName () {
        return procedureName;
    }

    public void setProcedureName (String procedureName) {
        this.procedureName = procedureName;
    }
            
    public String getDeviceProcessAnnexAssociationId () {
        return deviceProcessAnnexAssociationId;
    }

    public void setDeviceProcessAnnexAssociationId (String deviceProcessAnnexAssociationId) {
        this.deviceProcessAnnexAssociationId = deviceProcessAnnexAssociationId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceProcessAnnexId() {
        return deviceProcessAnnexId;
    }

    public void setDeviceProcessAnnexId(String deviceProcessAnnexId) {
        this.deviceProcessAnnexId = deviceProcessAnnexId;
    }

    public String getDeviceProcessId() {
        return deviceProcessId;
    }

    public void setDeviceProcessId(String deviceProcessId) {
        this.deviceProcessId = deviceProcessId;
    }

    public String getDeviceAnnexInfoId() {
        return deviceAnnexInfoId;
    }

    public void setDeviceAnnexInfoId(String deviceAnnexInfoId) {
        this.deviceAnnexInfoId = deviceAnnexInfoId;
    }
}
