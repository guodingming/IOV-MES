package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-数据字典表
*/
@ApiModel(value = "DpDataDictionary", description = "开发平台-数据字典表")
public class DpDataDictionary extends TrackableEntity {
	@ApiModelProperty(value = "属所数据字典分类ID")
	private String mesDpDataDictionaryTypeId;
	@ApiModelProperty(value = "字典中文名")
	private String cnName;
	@ApiModelProperty(value = "字典key")
	private String keyk;
	@ApiModelProperty(value = "字典value")
	private String valuev;
	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "排序")
	private String sort;

	public String getMesDpDataDictionaryTypeId() {
		return mesDpDataDictionaryTypeId;
	}
	public void setMesDpDataDictionaryTypeId(String mesDpDataDictionaryTypeId) {
		this.mesDpDataDictionaryTypeId = mesDpDataDictionaryTypeId;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getKeyk() {
		return keyk;
	}

	public void setKeyk(String keyk) {
		this.keyk = keyk;
	}

	public String getValuev() {
		return valuev;
	}

	public void setValuev(String valuev) {
		this.valuev = valuev;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
