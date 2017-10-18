package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-条码规则设置
*/
@ApiModel(value = "PdBarcodeRule", description = "产品管理-条码规则设置")
public class PdBarcodeRule extends TrackableEntity {
	@ApiModelProperty(value = "属所分类ID")
	private String barcodeRuleTypeId;
	@ApiModelProperty(value = "函数分类ID")
	private String functionTypeId;
	@ApiModelProperty(value = "脚本函数ID")
	private String functionId;
	@ApiModelProperty(value = "描述")
	private String description;


	public String getBarcodeRuleTypeId() {
		return barcodeRuleTypeId;
	}
	public void setBarcodeRuleTypeId(String barcodeRuleTypeId) {
		this.barcodeRuleTypeId = barcodeRuleTypeId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
