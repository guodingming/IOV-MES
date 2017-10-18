package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "FtyProcess", description = "工厂管理-工序字典")
public class FtyProcess extends TrackableEntity {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "工序编码")
	private String code;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "工序展示图标")
	private String icon;
	@ApiModelProperty(value = "工序配置类型")
	private List<String> configTypes;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<String> getConfigTypes() {
		return configTypes;
	}

	public void setConfigTypes(List<String> configTypes) {
		this.configTypes = configTypes;
	}
}
