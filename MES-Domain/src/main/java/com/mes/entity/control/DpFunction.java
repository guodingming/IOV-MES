package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-脚本
*/
@ApiModel(value = "DpFunction", description = "开发平台-脚本")
public class DpFunction extends TrackableEntity {
	@ApiModelProperty(value = "属所函数分类ID")
	private String functionTypeId;
	@ApiModelProperty(value = "接口参数模板内容")
	private String templateParameterContent;
	@ApiModelProperty(value = "接口返回结果模板内容")
	private String templateResultContent;
	@ApiModelProperty(value = "脚本")
	private String script;
	@ApiModelProperty(value = "文件上传路劲")
	private String filePath;

	@ApiModelProperty(value = "jar包名称")
	private String jarName;
	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "文件类型")
	private String type;
	@ApiModelProperty(value = "实现BaseCall的类名称")
	private String clazz;


	public String getFunctionTypeId() {
		return functionTypeId;
	}
	public void setFunctionTypeId(String functionTypeId) {
		this.functionTypeId = functionTypeId;
	}
	public String getTemplateParameterContent() {
		return templateParameterContent;
	}
	public void setTemplateParameterContent(String templateParameterContent) {
		this.templateParameterContent = templateParameterContent;
	}
	public String getTemplateResultContent() {
		return templateResultContent;
	}
	public void setTemplateResultContent(String templateResultContent) {
		this.templateResultContent = templateResultContent;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getJarName() {
		return jarName;
	}

	public void setJarName(String jarName) {
		this.jarName = jarName;
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

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
