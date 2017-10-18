package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-排班-人员
*/
@ApiModel(value = "PdScheduling", description = "产品管理-排班-人员")
public class PdScheduling extends TrackableEntity {
	@ApiModelProperty(value = "班次类型ID")
	private String schedulingTypeId;
	@ApiModelProperty(value = "班次类型name")
	private String schedulingTypeName;
	@ApiModelProperty(value = "是否启动")
	private String isStart;
	@ApiModelProperty(value = "产品ID")
	private String pdId;
	@ApiModelProperty(value = "产品name")
	private String pdName;
	@ApiModelProperty(value = "用户组ID")
	private String userGroupId;
	@ApiModelProperty(value = "人员ids")
	private String userIds;
	@ApiModelProperty(value = "用户名names")
	private String userNames;
	@ApiModelProperty(value = "用户组名称")
	private String groupName;
	@ApiModelProperty(value = "企业ID")
	private String enterpriseId;
	@ApiModelProperty(value = "工厂ID")
	private String siteId;
	@ApiModelProperty(value = "车间ID")
	private String areaId;
	@ApiModelProperty(value = "生产线ID")
	private String productionLineId;
	@ApiModelProperty(value = "加工中心ID")
	private String workCenterId;
	@ApiModelProperty(value = "工作站Ids")
	private String workstationIds;
	@ApiModelProperty(value = "企业name")
	private String enterpriseName;
	@ApiModelProperty(value = "工厂name")
	private String siteName;
	@ApiModelProperty(value = "车间name")
	private String areaName;
	@ApiModelProperty(value = "生产线name")
	private String productionLineName;
	@ApiModelProperty(value = "工作中心name")
	private String workCenterName;
	@ApiModelProperty(value = "工作站names")
	private String workstationNames;


	public String getSchedulingTypeId() {
		return schedulingTypeId;
	}
	public void setSchedulingTypeId(String schedulingTypeId) {
		this.schedulingTypeId = schedulingTypeId;
	}
	public String getSchedulingTypeName() {
		return schedulingTypeName;
	}
	public void setSchedulingTypeName(String schedulingTypeName) {
		this.schedulingTypeName = schedulingTypeName;
	}
	public String getIsStart() {
		return isStart;
	}
	public void setIsStart(String isStart) {
		this.isStart = isStart;
	}
	public String getPdId() {
		return pdId;
	}
	public void setPdId(String pdId) {
		this.pdId = pdId;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getWorkstationIds() {
		return workstationIds;
	}
	public void setWorkstationIds(String workstationIds) {
		this.workstationIds = workstationIds;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getProductionLineId() {
		return productionLineId;
	}
	public void setProductionLineId(String productionLineId) {
		this.productionLineId = productionLineId;
	}
	public String getWorkCenterId() {
		return workCenterId;
	}
	public void setWorkCenterId(String workCenterId) {
		this.workCenterId = workCenterId;
	}
	public String getUserNames() {
		return userNames;
	}
	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getProductionLineName() {
		return productionLineName;
	}
	public void setProductionLineName(String productionLineName) {
		this.productionLineName = productionLineName;
	}
	public String getWorkCenterName() {
		return workCenterName;
	}
	public void setWorkCenterName(String workCenterName) {
		this.workCenterName = workCenterName;
	}
	public String getWorkstationNames() {
		return workstationNames;
	}
	public void setWorkstationNames(String workstationNames) {
		this.workstationNames = workstationNames;
	}
}
