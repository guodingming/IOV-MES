package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 用户管理-人员技能
*/
@ApiModel(value = "UserProcess", description = "用户管理-人员技能")
public class UserProcess extends TrackableEntity {
	@ApiModelProperty(value = "用户ID")
	private String userId;
	@ApiModelProperty(value = "用户名")
	private String username;
	@ApiModelProperty(value = "用户密码")
	private String password;
	@ApiModelProperty(value = "工序ID")
	private String processId;
	@ApiModelProperty(value = "工序名称")
	private String processName;
	@ApiModelProperty(value = "工序CODE")
	private String processCode;
	@ApiModelProperty(value = "工单ID")
	private String workOrderId;
	@ApiModelProperty(value = "工程ID")
	private String projectId;
	@ApiModelProperty(value = "工序IDs")
	private List<String> processIds;
	@ApiModelProperty(value = "工序技能有效期开始")
	private Date startTime;
	@ApiModelProperty(value = "工序技能有效期截止")
	private Date endTime;
	@ApiModelProperty(value = "生产工序ID")
	private String produceProcessId;
	@ApiModelProperty(value = "当前用户拥有当前工序的状态, 0:禁止 1:开放")
	private String processStatus;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getWorkOrderId() {
		return workOrderId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	public List<String> getProcessIds() {
		return processIds;
	}

	public void setProcessIds(List<String> processIds) {
		this.processIds = processIds;
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

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getProduceProcessId() {
		return produceProcessId;
	}

	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
}
