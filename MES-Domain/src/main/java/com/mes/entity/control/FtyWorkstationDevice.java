package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyWorkstationDevice", description = "工厂管理-设备-工作站")
public class FtyWorkstationDevice extends TrackableEntity {
	@ApiModelProperty(value = "设备ID")
	private String deviceId;
	@ApiModelProperty(value = "工作站ID")
	private String workstationId;


	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getWorkstationId() {
		return workstationId;
	}
	public void setWorkstationId(String workstationId) {
		this.workstationId = workstationId;
	}
}
