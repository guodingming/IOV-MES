package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-模板管理
*/
@ApiModel(value = "DpTemplate", description = "开发平台-模板管理")
public class DpTemplate extends TrackableEntity {
	@ApiModelProperty(value = "name")
	private String name;
	@ApiModelProperty(value = "html")
	private String html;
	@ApiModelProperty(value = "url")
	private String url;
	@ApiModelProperty(value = "javascript")
	private String javascript;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "模板分类ID")
	private String templateTypeId;

	public String getTemplateTypeId() {
		return templateTypeId;
	}
	public void setTemplateTypeId(String templateTypeId) {
		this.templateTypeId = templateTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
