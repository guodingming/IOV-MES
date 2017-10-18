package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "FtyDeviceAnnexInfo", description = "工厂管理-（治具/工装/其他）")
public class FtyDeviceAnnexInfo extends TrackableEntity {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "编号")
	private String number;
	@ApiModelProperty(value = "使用次数")
	private Integer useCount;
	@ApiModelProperty(value = "开始时间")
	private Date startTime;
	@ApiModelProperty(value = "结束时间")
	private Date endTime;
	@ApiModelProperty(value = "附件分类ID")
	private String deviceAnnexId;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getUseCount() {
		return useCount;
	}
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
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
	public String getDeviceAnnexId() {
		return deviceAnnexId;
	}
	public void setDeviceAnnexId(String deviceAnnexId) {
		this.deviceAnnexId = deviceAnnexId;
	}
}
