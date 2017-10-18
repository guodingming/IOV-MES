package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理--排班-设备
*/
@ApiModel(value = "PdSchedulingDevice", description = "产品管理--排班-设备")
public class PdSchedulingDevice extends TrackableEntity {
	@ApiModelProperty(value = "企业ID")
	private String enterpriseId;
	@ApiModelProperty(value = "工厂ID")
	private String siteId;
	@ApiModelProperty(value = "车间ID")
	private String areaId;
	@ApiModelProperty(value = "生产线ID")
	private String productionLineId;
	@ApiModelProperty(value = "工作中心ID")
	private String workCenterId;
	@ApiModelProperty(value = "工作站id")
	private String workstationId;
	@ApiModelProperty(value = "属所排班ID")
	private String schedulingId;
	@ApiModelProperty(value = "企业name")
	private String enterpriseName;
	@ApiModelProperty(value = "工厂name")
	private String siteName;
	@ApiModelProperty(value = "车间name")
	private String areaName;
	@ApiModelProperty(value = "生产线name")
	private String productionLineName;
	@ApiModelProperty(value = "工作站名称")
	private String workstationName;
	@ApiModelProperty(value = "工作中心名称")
	private String workCenterName;
	@ApiModelProperty(value = "工作站ids")
	private String workstationIds;



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
	public String getWorkstationId() {
		return workstationId;
	}
	public void setWorkstationId(String workstationId) {
		this.workstationId = workstationId;
	}
	public String getSchedulingId() {
		return schedulingId;
	}
	public void setSchedulingId(String schedulingId) {
		this.schedulingId = schedulingId;
	}
	public String getWorkstationName() {
		return workstationName;
	}
	public void setWorkstationName(String workstationName) {
		this.workstationName = workstationName;
	}
	public String getWorkCenterName() {
		return workCenterName;
	}
	public void setWorkCenterName(String workCenterName) {
		this.workCenterName = workCenterName;
	}
	public String getWorkstationIds() {
		return workstationIds;
	}
	public void setWorkstationIds(String workstationIds) {
		this.workstationIds = workstationIds;
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
}
