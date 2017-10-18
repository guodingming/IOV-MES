package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-生产工序配置属性
*/
@ApiModel(value = "DpProduceProcessConfig", description = "开发平台-生产工序配置属性")
public class DpProduceProcessConfig extends TrackableEntity {
	@ApiModelProperty(value = "生产工序ID")
	private String produceProcessId;
	@ApiModelProperty(value = "value")
	private String value;
	@ApiModelProperty(value = "字典中文名")
	private String dictionaryCnName;
	@ApiModelProperty(value = "字典id")
	private String dictionaryId;
	@ApiModelProperty(value = "字典分类id")
	private String dictionaryTypeId;
	@ApiModelProperty(value = "数据类型（文件，字符，数字）")
	private String type;
	@ApiModelProperty(value = "描述")
	private String description;


	public String getProduceProcessId() {
		return produceProcessId;
	}
	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getDictionaryCnName() {
		return dictionaryCnName;
	}

	public void setDictionaryCnName(String dictionaryCnName) {
		this.dictionaryCnName = dictionaryCnName;
	}

	public String getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	public String getDictionaryTypeId() {
		return dictionaryTypeId;
	}
	public void setDictionaryTypeId(String dictionaryTypeId) {
		this.dictionaryTypeId = dictionaryTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
