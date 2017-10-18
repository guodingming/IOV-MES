package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-函数分类
*/
@ApiModel(value = "DpFunctionType", description = "开发平台-函数分类")
public class DpFunctionType extends TrackableEntity {
	@ApiModelProperty(value = "父ID")
	private String parentId;
	@ApiModelProperty(value = "分类名称")
	private String name;
	@ApiModelProperty(value = "type(groovy/java)")
	private String type;


	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
