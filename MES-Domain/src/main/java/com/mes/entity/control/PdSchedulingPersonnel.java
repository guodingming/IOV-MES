package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 排班管理-班次人员
*/
@ApiModel(value = "PdSchedulingPersonnel", description = "排班管理-班次人员")
public class PdSchedulingPersonnel extends TrackableEntity {
	@ApiModelProperty(value = "用户ID")
	private String userId;
	@ApiModelProperty(value = "用户组ID")
	private String userGroupId;
	@ApiModelProperty(value = "所属班次ID")
	private String schedulingId;
	@ApiModelProperty(value = "用户名")
	private String userName;
	@ApiModelProperty(value = "用户组名称")
	private String groupName;
	@ApiModelProperty(value = "用户IDs")
	private String userIds;


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(String schedulingId) {
		this.schedulingId = schedulingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
}
