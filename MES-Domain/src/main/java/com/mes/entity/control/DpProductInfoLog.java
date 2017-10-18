package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.activiti.engine.task.Task;

import java.util.Date;

/**
 * 开发平台-产品生产工序记录
*/
@ApiModel(value = "DpProductInfoLog", description = "开发平台-产品生产工序记录")
public class DpProductInfoLog extends TrackableEntity {
	@ApiModelProperty(value = "产品线ID")
	private String dpLineId;
	@ApiModelProperty(value = "产品ID")
	private String pdId;
	@ApiModelProperty(value = "工单ID")
	private String workOrderId;
	@ApiModelProperty(value = "生产工序ID")
	private String produceProcessId;
	@ApiModelProperty(value = "工序Code")
	private String processCode;
	@ApiModelProperty(value = "工序名称")
	private String processName;
	@ApiModelProperty(value = "工站")
	private String workstationDeviceId;
	@ApiModelProperty(value = "结果（成功、失败）")
	private String isSuccess;
	@ApiModelProperty(value = "开始生产时间")
	private Date startTime;
	@ApiModelProperty(value = "完成时间")
	private Date endTime;
	@ApiModelProperty(value = "操作人员ID")
	private String userId;
	@ApiModelProperty(value = "操作人员名称")
	private String userName;
	@ApiModelProperty(value = "属所产品ID")
	private String pdProductInfoId;
	@ApiModelProperty(value = "工单号")
	private String workOrderNum;
	@ApiModelProperty(value = "批次号")
	private String workOrderBatchNum;
	@ApiModelProperty(value = "SN")
	private String number;

	//流程任务对象
	private Task task;
	/**
	 * 状态
	 */
	public static class Status {
		/**
		 * 成功
		 */
		public static final String SUCCESS = "0";
		/**
		 * 失败
		 */
		public static final String FAIL = "1";
		/**
		 * 未投产
		 */
		public static final String NO_PRODUCTION = "2";

		/**
		 * 维修站
		 */
		public static final String ON_REPAIRSTATION = "3";
		/**
		 * 完成
		 */
		public static final String IS_COMPLETE = "4";

		/**
		 * 维修站转到工序，还未过站之前的待产状态
		 */
		public static final String WAIT_PRODUCTION = "5";

	}

	public String getDpLineId() {
		return dpLineId;
	}
	public void setDpLineId(String dpLineId) {
		this.dpLineId = dpLineId;
	}
	public String getPdId() {
		return pdId;
	}
	public void setPdId(String pdId) {
		this.pdId = pdId;
	}
	public String getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}
	public String getProduceProcessId() {
		return produceProcessId;
	}
	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}

	public String getWorkstationDeviceId() {
		return workstationDeviceId;
	}
	public void setWorkstationDeviceId(String workstationDeviceId) {
		this.workstationDeviceId = workstationDeviceId;
	}
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPdProductInfoId() {
		return pdProductInfoId;
	}

	public void setPdProductInfoId(String pdProductInfoId) {
		this.pdProductInfoId = pdProductInfoId;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getWorkOrderNum() {
		return workOrderNum;
	}
	public void setWorkOrderNum(String workOrderNum) {
		this.workOrderNum = workOrderNum;
	}
	public String getWorkOrderBatchNum() {
		return workOrderBatchNum;
	}
	public void setWorkOrderBatchNum(String workOrderBatchNum) {
		this.workOrderBatchNum = workOrderBatchNum;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
