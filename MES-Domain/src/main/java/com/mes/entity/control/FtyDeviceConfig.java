package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyDeviceConfig", description = "工厂管理-设备配置设置")
public class FtyDeviceConfig extends TrackableEntity {
	@ApiModelProperty(value = "设备配置分类ID")
	private String deviceConfigTypeId;
	@ApiModelProperty(value = "设备ID")
	private String deviceId;


	public String getDeviceConfigTypeId() {
		return deviceConfigTypeId;
	}
	public void setDeviceConfigTypeId(String deviceConfigTypeId) {
		this.deviceConfigTypeId = deviceConfigTypeId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
