package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

@ApiModel(value = "FtyDeviceFault", description = "工厂管理-设备异常管理")
public class FtyDeviceFault extends TrackableEntity {
	@ApiModelProperty(value = "设备id")
	@NotNull(message = "设备Id",groups = {BeanValidationGroups.CreateGroup.class})
	private String deviceId;
	@ApiModelProperty(value = "设备是否正在生产")
	private String isRun;
	@ApiModelProperty(value = "设备故障ID")
	@NotNull(message = "设备故障Id",groups = {BeanValidationGroups.CreateGroup.class})
	private String deviceFaultInfoId;
	@ApiModelProperty(value = "email")
	@Email(message = "email")
	private String email;
	@ApiModelProperty(value = "保修状态")
	private String status;
	@ApiModelProperty(value = "异常信息Id")
	private String deviceFaultProcessId;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "设备名称")
	private String deviceName;
	@ApiModelProperty(value = "异常信息设备名称")
	private String name;
	@ApiModelProperty(value = "设备Ip")
	private String ip;

	@ApiModelProperty(value = "维修负责联系人")
	private String maintenancePersion;
	@ApiModelProperty(value = "维修负责联系人电话")
	private String maintenancePhone;
	@ApiModelProperty(value = "保修人")
	private  String operator;
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getIsRun() {
		return isRun;
	}

	public void setIsRun(String isRun) {
		this.isRun = isRun;
	}

	public String getDeviceFaultInfoId() {
		return deviceFaultInfoId;
	}

	public void setDeviceFaultInfoId(String deviceFaultInfoId) {
		this.deviceFaultInfoId = deviceFaultInfoId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMaintenancePersion() {
		return maintenancePersion;
	}

	public void setMaintenancePersion(String maintenancePersion) {
		this.maintenancePersion = maintenancePersion;
	}

	public String getMaintenancePhone() {
		return maintenancePhone;
	}

	public void setMaintenancePhone(String maintenancePhone) {
		this.maintenancePhone = maintenancePhone;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getDeviceFaultProcessId() {
		return deviceFaultProcessId;
	}

	public void setDeviceFaultProcessId(String deviceFaultProcessId) {
		this.deviceFaultProcessId = deviceFaultProcessId;
	}
}
