package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-工单批次
*/
@ApiModel(value = "PdWorkOrderBatch", description = "产品管理-工单批次")
public class PdWorkOrderBatch extends TrackableEntity {
	@ApiModelProperty(value = "工单ID")
	private String workOrderId;
	@ApiModelProperty(value = "批号")
	private String batchNum;


	public String getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
}
