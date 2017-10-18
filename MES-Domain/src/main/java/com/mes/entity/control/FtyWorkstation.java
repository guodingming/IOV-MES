package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyWorkstation", description = "工作站管理-（workstation ）")
public class FtyWorkstation extends TrackableEntity {
	@ApiModelProperty(value = "工作站名称")
	private String name;
	@ApiModelProperty(value = "工作站名称字典ID")
	private String dictionaryId;
	@ApiModelProperty(value = "工作中心ID")
	private String workCenterId;
	@ApiModelProperty(value = "位置")
	private String location;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "类别")
	private String category;
    @ApiModelProperty(value = "设备ID")
	private  String deviceId;
    @ApiModelProperty(value = "设备名称")
	private String deviceName;
    @ApiModelProperty(value = "加工中心名称")
	private String workCenterName;
	@ApiModelProperty(value = "设备IDs")
	private  String deviceIds;

	public String getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceIds(String deviceIds) {
		this.deviceIds = deviceIds;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getWorkCenterName() {
		return workCenterName;
	}

	public void setWorkCenterName(String workCenterName) {
		this.workCenterName = workCenterName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkCenterId() {
		return workCenterId;
	}
	public void setWorkCenterId(String workCenterId) {
		this.workCenterId = workCenterId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
}
