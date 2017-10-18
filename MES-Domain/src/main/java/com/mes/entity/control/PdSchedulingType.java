package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Time;

/**
 * 产品管理-班次类型
 */
@ApiModel(value = "PdSchedulingType", description = "产品管理-班次类型")
public class PdSchedulingType extends TrackableEntity {
    @ApiModelProperty(value = "班次类型名称（早、中、晚）")
    private String name;
    @ApiModelProperty(value = "班次开始时间")
    private Time startTime;
    @ApiModelProperty(value = "班次结束时间")
    private Time endTime;
    @ApiModelProperty(value = "班次编码，如A，B等")
    private String code;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
