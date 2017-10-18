package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

/**
 * 服务调用监控
 * <p>
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpServiceMonitor", description = "$table.description")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpServiceMonitor extends TrackableEntity {
    @ApiModelProperty(value = "服务id")
    private String serviceId;
    @ApiModelProperty(value = "时间段起始")
    private Date periodStart;
    @ApiModelProperty(value = "时间段类型（天d，周w，月m）")
    private String periodType;
    @ApiModelProperty(value = "调用状态，1为成功，0为失败")
    private Integer status;
    @ApiModelProperty(value = "时间段内调用状态出现次数")
    private Long count;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
