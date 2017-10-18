package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "FtyDeviceProcessAnnex", description = "工厂管理-工序-设备-附件")
public class FtyDeviceProcessAnnex extends TrackableEntity {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "设备ID")
	private String deviceId;
	@ApiModelProperty(value = "设备-工序ID")
	private String deviceProcessId;
	@ApiModelProperty(value = "工序ID")
	private String processId;
	@ApiModelProperty(value = "附件分类ID")
	private String deviceAnnexId;
	@ApiModelProperty(value = "附件IDs")
	private List<String> deviceAnnexInfoIds;
	public List<String> getDeviceAnnexInfoIds() {
		return deviceAnnexInfoIds;
	}

	public void setDeviceAnnexInfoIds(List<String> deviceAnnexInfoIds) {
		this.deviceAnnexInfoIds = deviceAnnexInfoIds;
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
	public String getDeviceProcessId() {
		return deviceProcessId;
	}
	public void setDeviceProcessId(String deviceProcessId) {
		this.deviceProcessId = deviceProcessId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getDeviceAnnexId() {
		return deviceAnnexId;
	}
	public void setDeviceAnnexId(String deviceAnnexId) {
		this.deviceAnnexId = deviceAnnexId;
	}

}
