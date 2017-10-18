package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 平台管理-工作站Agent管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "Agent", description = "平台管理-工作站Agent管理")
@XmlAccessorType(XmlAccessType.FIELD)
public class Agent extends TrackableEntity {
    @ApiModelProperty(value = "工作站id")
    private String workstationId;
    @ApiModelProperty(value = "工作站名称")
    private String workstationName;
    @ApiModelProperty(value = "ip")
    private String ip;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "状态，0为离线，1为在线")
    private String status;
    @ApiModelProperty(value = "描述")
    private String description;

    public String getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(String workstationId) {
        this.workstationId = workstationId;
    }

    public String getWorkstationName() {
        return workstationName;
    }

    public void setWorkstationName(String workstationName) {
        this.workstationName = workstationName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
