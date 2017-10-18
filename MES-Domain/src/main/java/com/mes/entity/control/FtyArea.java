package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyArea", description = "工厂管理-车间管理")
public class FtyArea extends TrackableEntity {
	@ApiModelProperty(value = "工厂id")
	private String siteInfoId;
	@ApiModelProperty(value = "车间名称")
	private String name;
	@ApiModelProperty(value = "联系电话")
	private String phone;
	@ApiModelProperty(value = "位置")
	private String location;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "类别")
	private String category;
	@ApiModelProperty(value = "时区")
	private String timeZone;


	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
