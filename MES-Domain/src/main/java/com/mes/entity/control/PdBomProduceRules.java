package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-生产BOM校验规则
*/
@ApiModel(value = "PdBomProduceRules", description = "产品管理-生产BOM校验规则")
public class PdBomProduceRules extends TrackableEntity {
	@ApiModelProperty(value = "规则名称")
	private String name;
	@ApiModelProperty(value = "bom id")
	private String bomId;
	@ApiModelProperty(value = "规则正则表达式")
	private String ruleRegex;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBomId() {
		return bomId;
	}
	public void setBomId(String bomId) {
		this.bomId = bomId;
	}
	public String getRuleRegex() {
		return ruleRegex;
	}
	public void setRuleRegex(String ruleRegex) {
		this.ruleRegex = ruleRegex;
	}
}
