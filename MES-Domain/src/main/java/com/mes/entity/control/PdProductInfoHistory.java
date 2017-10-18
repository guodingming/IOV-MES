package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-产品明细（按工单移）历史表
*/
@ApiModel(value = "PdProductInfoHistory", description = "开发平台-产品明细（按工单移）历史表")
public class PdProductInfoHistory extends TrackableEntity {
	@ApiModelProperty(value = "产品唯一条码")
	private String pdNum;
	@ApiModelProperty(value = "产品名称")
	private String pdName;
	@ApiModelProperty(value = "软件信息")
	private String softVersion;
	@ApiModelProperty(value = "硬件版本")
	private String hardVersion;
	@ApiModelProperty(value = "工单ID")
	private String workOrderId;
	@ApiModelProperty(value = "属所产品ID")
	private String pdId;
	@ApiModelProperty(value = "批次号")
	private String workOrderBatchNum;


	public String getPdNum() {
		return pdNum;
	}
	public void setPdNum(String pdNum) {
		this.pdNum = pdNum;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getSoftVersion() {
		return softVersion;
	}
	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}
	public String getHardVersion() {
		return hardVersion;
	}
	public void setHardVersion(String hardVersion) {
		this.hardVersion = hardVersion;
	}
	public String getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}
	public String getPdId() {
		return pdId;
	}
	public void setPdId(String pdId) {
		this.pdId = pdId;
	}
	public String getWorkOrderBatchNum() {
		return workOrderBatchNum;
	}
	public void setWorkOrderBatchNum(String workOrderBatchNum) {
		this.workOrderBatchNum = workOrderBatchNum;
	}
}
