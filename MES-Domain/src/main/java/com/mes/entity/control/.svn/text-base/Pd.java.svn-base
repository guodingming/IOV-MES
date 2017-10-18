package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 产品管理-产品
*/
@ApiModel(value = "Pd", description = "产品管理-产品")
public class Pd extends TrackableEntity {
	@ApiModelProperty(value = "产品名称")
	@NotNull(message = "产品名称",groups = {BeanValidationGroups.CreateGroup.class})
	private String name;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "产品线ID")
	@NotNull(message = "产品线ID",groups = {BeanValidationGroups.CreateGroup.class})
	private String pdLineId;
	@ApiModelProperty(value = "编码")
	@NotNull(message = "编码",groups = {BeanValidationGroups.CreateGroup.class})
	private String code;

	@ApiModelProperty(value = "产品线IDs")
	private List<String> productionLineIds;


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
	public String getPdLineId() {
		return pdLineId;
	}
	public void setPdLineId(String pdLineId) {
		this.pdLineId = pdLineId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getProductionLineIds() {
		return productionLineIds;
	}

	public void setProductionLineIds(List<String> productionLineIds) {
		this.productionLineIds = productionLineIds;
	}
}
