package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-服务日志
*/
@ApiModel(value = "DpServiceLog", description = "开发平台-服务日志")
public class DpServiceLog extends TrackableEntity {
	@ApiModelProperty(value = "服务ID")
	private String serviceId;
	@ApiModelProperty(value = "状态（成功、失败）")
	private String status;
	@ApiModelProperty(value = "调用时间")
	private String invokeTime;
	@ApiModelProperty(value = "耗时")
	private String timeTaken;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvokeTime() {
		return invokeTime;
	}

	public void setInvokeTime(String invokeTime) {
		this.invokeTime = invokeTime;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}
}
