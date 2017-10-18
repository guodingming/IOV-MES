package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文件分类管理
*/
@ApiModel(value = "PdFileType", description = "文件分类管理")
public class PdFileType extends TrackableEntity {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "type（资源文件:1，工艺文件:2）")
	private String type;


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
