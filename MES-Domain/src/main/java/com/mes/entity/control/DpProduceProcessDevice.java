package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 生产工序-设备
*/
@ApiModel(value = "DpProduceProcessDevice", description = "生产工序-设备")
public class DpProduceProcessDevice extends TrackableEntity {
	@ApiModelProperty(value = "工作站")
	private String workstationDeviceId;
	@ApiModelProperty(value = "设备ID")
	private String deviceId;
	@ApiModelProperty(value = "属所产品生产工序ID")
	private String produceProcessId;


	public String getWorkstationDeviceId() {
		return workstationDeviceId;
	}
	public void setWorkstationDeviceId(String workstationDeviceId) {
		this.workstationDeviceId = workstationDeviceId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getProduceProcessId() {
		return produceProcessId;
	}
	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}
}
