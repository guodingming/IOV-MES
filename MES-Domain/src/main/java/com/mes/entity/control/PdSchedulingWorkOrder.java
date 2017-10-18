package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-工单班次
*/
@ApiModel(value = "PdSchedulingWorkOrder", description = "产品管理-工单班次")
public class PdSchedulingWorkOrder extends TrackableEntity {
	@ApiModelProperty(value = "工单ID")
	private String workOrderId;
	@ApiModelProperty(value = "班次人员")
	private String schedulingId;


	public String getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}
	public String getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(String schedulingId) {
		this.schedulingId = schedulingId;
	}
}
