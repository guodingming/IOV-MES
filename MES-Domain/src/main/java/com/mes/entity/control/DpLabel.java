package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 开发平台-标签管理
*/
@ApiModel(value = "DpLabel", description = "开发平台-标签管理")
public class DpLabel extends TrackableEntity {

	@ApiModelProperty(value = "名称")
	private String name;
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "产品id")
	private String pdId;
	@ApiModelProperty(value = "解析类型id")
	private String type;
	@ApiModelProperty(value = "生成方式")
	private String generation;
	@ApiModelProperty(value = "模板指令")
	private String templateOrder;
	@ApiModelProperty(value = "模板附件")
	private String templatePath;
	@ApiModelProperty(value = "函数脚本类型id")
	private String functionTypeId;
	@ApiModelProperty(value = "函数脚本id")
	private String functionId;
	@ApiModelProperty(value = "说明文档")
	private String instructionPath;
	@ApiModelProperty(value = "标签样式图片")
	private String image;
	@ApiModelProperty(value = "产品name")
	private String pdName;
	@ApiModelProperty(value = "标签类型name")
	private String typeName;
	@ApiModelProperty(value = "函数脚本类型name")
	private String functionTypeName;
	@ApiModelProperty(value = "函数脚本name")
	private String functionName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

	public String getPdId() {
		return pdId;
	}

	public void setPdId(String pdId) {
		this.pdId = pdId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getTemplateOrder() {
		return templateOrder;
	}

	public void setTemplateOrder(String templateOrder) {
		this.templateOrder = templateOrder;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getFunctionTypeId() {
		return functionTypeId;
	}

	public void setFunctionTypeId(String functionTypeId) {
		this.functionTypeId = functionTypeId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getInstructionPath() {
		return instructionPath;
	}

	public void setInstructionPath(String instructionPath) {
		this.instructionPath = instructionPath;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getFunctionTypeName() {
		return functionTypeName;
	}

	public void setFunctionTypeName(String functionTypeName) {
		this.functionTypeName = functionTypeName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
