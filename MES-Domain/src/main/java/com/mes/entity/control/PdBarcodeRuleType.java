package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-条码规则分类
*/
@ApiModel(value = "PdBarcodeRuleType", description = "开发平台-条码规则分类")
public class PdBarcodeRuleType extends TrackableEntity {
	@ApiModelProperty(value = "name")
	private String name;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
