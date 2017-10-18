package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-产品明细（按工单移）
*/
@ApiModel(value = "PdProductInfo", description = "开发平台-产品明细（按工单移）")
public class PdProductInfo extends TrackableEntity {
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
	@ApiModelProperty(value = "工单号")
	private String workOrderNum;
	@ApiModelProperty(value = "批次号")
	private String workOrderBatchNum;
	@ApiModelProperty(value = "流程实例ID")
	private String instanceId;
	@ApiModelProperty(value = "产品线ID")
	private String pdLineId;
	@ApiModelProperty(value = "状态")
	private String status;
	@ApiModelProperty(value = "SN")
	private String sN;


	/**
	 * 工单状态
	 */
	public static class Status {
		/**
		 * 未投产
		 */
		public static final String STATUS_NO_PRODUCTION = "0";
		/**
		 * 正在生产
		 */
		public static final String STATUS_ON_PRODUCTING = "1";
		/**
		 * 维修站
		 */
		public static final String STATUS_ON_REPAIRSTATION = "2";
		/**
		 * 完成
		 */
		public static final String STATUS_IS_COMPLETE = "3";

		/**
		 * 已维修完成跳转到某个工序还未正式过站
		 */
		public static final String STATUS_IS_REPAIRED = "4";

	}

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

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getPdLineId() {
		return pdLineId;
	}

	public void setPdLineId(String pdLineId) {
		this.pdLineId = pdLineId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkOrderNum() {
		return workOrderNum;
	}

	public void setWorkOrderNum(String workOrderNum) {
		this.workOrderNum = workOrderNum;
	}

	public String getsN() {
		return sN;
	}

	public void setsN(String sN) {
		this.sN = sN;
	}
}
