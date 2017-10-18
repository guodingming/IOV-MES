package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-组件分类
*/
@ApiModel(value = "DpSubassemblyType", description = "开发平台-组件分类")
public class DpSubassemblyType extends TrackableEntity {
	@ApiModelProperty(value = "name")
	private String name;
	@ApiModelProperty(value = "description")
	private String description;


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
}
