package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyWorkCenter", description = "工作中心管理-（Work center）")
public class FtyWorkCenter extends TrackableEntity {
	@ApiModelProperty(value = "工作中心名称")
	private String name;
	@ApiModelProperty(value = "生产线ID")
	private String productionLineId;
	@ApiModelProperty(value = "位置")
	private String location;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "类别")
	private String category;
	@ApiModelProperty(value = "产能")
	private Integer capacity;
	@ApiModelProperty(value = "优先级")
	private Integer priority;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductionLineId() {
		return productionLineId;
	}
	public void setProductionLineId(String productionLineId) {
		this.productionLineId = productionLineId;
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
