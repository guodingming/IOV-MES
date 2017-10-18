package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 开发平台-工序基础配置
*/
@ApiModel(value = "DpProcessBaseConfig", description = "开发平台-工序基础配置")
public class DpProcessBaseConfig extends TrackableEntity {
	@ApiModelProperty(value = "工序ID")
	private String processId;
	@ApiModelProperty(value = "字典分类ID")
	private String dataDictionaryTypeId;
	@ApiModelProperty(value = "类型字典ID(检查/组装、分板、包装)")
	private String dataDictionaryId;
	@ApiModelProperty(value = "表单分类ID")
	private String formTypeId;
	@ApiModelProperty(value = "模式")
	private String isAuto;
	@ApiModelProperty(value = "操作表单ID")
	private String formId;
	@ApiModelProperty(value = "操作表单名称")
	private String formName;
	@ApiModelProperty(value = "扩展属性")
	private List<DpProcessConfig> extendProperties;

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getDataDictionaryTypeId() {
		return dataDictionaryTypeId;
	}
	public void setDataDictionaryTypeId(String dataDictionaryTypeId) {
		this.dataDictionaryTypeId = dataDictionaryTypeId;
	}
	public String getDataDictionaryId() {
		return dataDictionaryId;
	}
	public void setDataDictionaryId(String dataDictionaryId) {
		this.dataDictionaryId = dataDictionaryId;
	}

	public String getIsAuto() {
		return isAuto;
	}

	public void setIsAuto(String isAuto) {
		this.isAuto = isAuto;
	}

	public String getFormTypeId() {
		return formTypeId;
	}
	public void setFormTypeId(String formTypeId) {
		this.formTypeId = formTypeId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}

	public List<DpProcessConfig> getExtendProperties() {
		return extendProperties;
	}

	public void setExtendProperties(List<DpProcessConfig> extendProperties) {
		this.extendProperties = extendProperties;
	}
}
