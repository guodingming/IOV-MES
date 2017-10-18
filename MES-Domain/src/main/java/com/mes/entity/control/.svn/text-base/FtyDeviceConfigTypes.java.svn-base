package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/21.
 */
@ApiModel(value = "FtyDeviceConfigTypes", description = "设备及其多个配置类型关联关系")
public class FtyDeviceConfigTypes {
    @ApiModelProperty(value = "设备ID")
    @NotNull(message = "设备ID不能为null")
    private String deviceId;
    @ApiModelProperty(value = "设备配置分类ID列表")
    @NotNull(message = "设备配置分类ID列表不能为null")
    private List<String> deviceConfigTypeIds;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<String> getDeviceConfigTypeIds() {
        return deviceConfigTypeIds;
    }

    public void setDeviceConfigTypeIds(List<String> deviceConfigTypeIds) {
        this.deviceConfigTypeIds = deviceConfigTypeIds;
    }
}
