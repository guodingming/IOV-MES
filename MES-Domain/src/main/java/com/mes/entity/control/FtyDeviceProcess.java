package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "FtyDeviceProcess", description = "工厂管理-工序-设备")
public class FtyDeviceProcess extends TrackableEntity {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "设备ID")
	private String deviceId;
	@ApiModelProperty(value = "工序ID")
	private String processId;
	@ApiModelProperty(value = "工序IDs")
	private List<String> processIds;

	@ApiModelProperty(value = "设备名称")
	private String deviceName;

	public List<String> getProcessIds() {
		return processIds;
	}

	public void setProcessIds(List<String> processIds) {
		this.processIds = processIds;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}
