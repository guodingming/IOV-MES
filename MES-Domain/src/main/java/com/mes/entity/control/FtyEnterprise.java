package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FtyEnterprise", description = "工厂管理-企业登记")
public class FtyEnterprise extends TrackableEntity {
	@ApiModelProperty(value = "企业名称")
	private String company;
	@ApiModelProperty(value = "描述")
	private String description;


	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
