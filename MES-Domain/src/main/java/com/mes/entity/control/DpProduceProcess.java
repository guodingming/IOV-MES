package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 产品管理--产品生产工序
*/
@ApiModel(value = "DpProduceProcess", description = "产品管理--产品生产工序")
public class DpProduceProcess extends TrackableEntity {
	@ApiModelProperty(value = "产品线id")
	private String pdLineId;
	@ApiModelProperty(value = "工序顺序")
	private Integer sort;
	@ApiModelProperty(value = "产品ID")
	private String pdId;
	@ApiModelProperty(value = "工序ID")
	private String processId;
	private List<String> processIds;
	@ApiModelProperty(value = "工程ID")
	private String projectId;
	@ApiModelProperty(value = "表单分类ID")
	private String formTypeId;
	@ApiModelProperty(value = "表单ID")
	private String formId;
	@ApiModelProperty(value = "生产方式（自动、人工）")
	private String isAuto;
	@ApiModelProperty(value = "是否有物料（0,1）")
	private String isBomMaterials;
	@ApiModelProperty(value = "生产BOM_ID")
	private String bomProduceId;
	@ApiModelProperty(value = "工序名称")
	private String processName;
	@ApiModelProperty(value = "工序编码")
	private String processCode;
	@ApiModelProperty(value = "工序描述")
	private String processDescription;
	@ApiModelProperty(value = "表单名称")
	private String formName;
	@ApiModelProperty(value = "BOM名称")
	private String bomName;
	@ApiModelProperty(value = "配置类型字符串")
	private List<String> configType;
	@ApiModelProperty(value = "扩展属性")
	private List<DpProduceProcessConfig> extendProperties;

	@ApiModelProperty(value = "是否初始化工序")
	private String isInit;
	@ApiModelProperty(value = "初始化函数分类ID")
	private String initFnTypeId;
	@ApiModelProperty(value = "初始化函数ID")
	private String initFnId;
	@ApiModelProperty(value = "是否自定义工序")
	private String isCustom;
	@ApiModelProperty(value = "自定义函数分类ID")
	private String customFnTypeId;
	@ApiModelProperty(value = "自定义函数ID")
	private String customFnId;
	@ApiModelProperty(value = "是否校验上道工序")
	private String isValidateLastProcess;
	@ApiModelProperty(value = "上道生产工序ID")
	private String lastProduceProcessId;
	@ApiModelProperty(value = "当前工序可执行过站次数")
	private int executeTime;
	@ApiModelProperty(value = "当前工序是否自定义校验")
	private String isCustomCheck;
	@ApiModelProperty(value = "当前工序自定义校验函数分类")
	private String customCheckFnTypeId;
	@ApiModelProperty(value = "当前工序自定义校验函数")
	private String customCheckFnId;

	public String getPdLineId() {
		return pdLineId;
	}
	public void setPdLineId(String pdLineId) {
		this.pdLineId = pdLineId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPdId() {
		return pdId;
	}
	public void setPdId(String pdId) {
		this.pdId = pdId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<String> getProcessIds() {
		return processIds;
	}

	public void setProcessIds(List<String> processIds) {
		this.processIds = processIds;
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
	public String getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(String isAuto) {
		this.isAuto = isAuto;
	}
	public String getIsBomMaterials() {
		return isBomMaterials;
	}
	public void setIsBomMaterials(String isBomMaterials) {
		this.isBomMaterials = isBomMaterials;
	}
	public String getBomProduceId() {
		return bomProduceId;
	}
	public void setBomProduceId(String bomProduceId) {
		this.bomProduceId = bomProduceId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getProcessDescription() {
		return processDescription;
	}

	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getBomName() {
		return bomName;
	}

	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	public List<String> getConfigType() {
		return configType;
	}

	public void setConfigType(List<String> configType) {
		this.configType = configType;
	}

	public List<DpProduceProcessConfig> getExtendProperties() {
		return extendProperties;
	}

	public void setExtendProperties(List<DpProduceProcessConfig> extendProperties) {
		this.extendProperties = extendProperties;
	}

	public String getIsInit() {
		return isInit;
	}

	public void setIsInit(String isInit) {
		this.isInit = isInit;
	}

	public String getInitFnTypeId() {
		return initFnTypeId;
	}

	public void setInitFnTypeId(String initFnTypeId) {
		this.initFnTypeId = initFnTypeId;
	}

	public String getInitFnId() {
		return initFnId;
	}

	public void setInitFnId(String initFnId) {
		this.initFnId = initFnId;
	}

	public String getIsCustom() {
		return isCustom;
	}

	public void setIsCustom(String isCustom) {
		this.isCustom = isCustom;
	}

	public String getCustomFnTypeId() {
		return customFnTypeId;
	}

	public void setCustomFnTypeId(String customFnTypeId) {
		this.customFnTypeId = customFnTypeId;
	}

	public String getCustomFnId() {
		return customFnId;
	}

	public void setCustomFnId(String customFnId) {
		this.customFnId = customFnId;
	}

	public String getIsValidateLastProcess() {
		return isValidateLastProcess;
	}

	public void setIsValidateLastProcess(String isValidateLastProcess) {
		this.isValidateLastProcess = isValidateLastProcess;
	}

	public String getLastProduceProcessId() {
		return lastProduceProcessId;
	}

	public void setLastProduceProcessId(String lastProduceProcessId) {
		this.lastProduceProcessId = lastProduceProcessId;
	}

	public int getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(int executeTime) {
		this.executeTime = executeTime;
	}

	public String getIsCustomCheck() {
		return isCustomCheck;
	}

	public void setIsCustomCheck(String isCustomCheck) {
		this.isCustomCheck = isCustomCheck;
	}

	public String getCustomCheckFnTypeId() {
		return customCheckFnTypeId;
	}

	public void setCustomCheckFnTypeId(String customCheckFnTypeId) {
		this.customCheckFnTypeId = customCheckFnTypeId;
	}

	public String getCustomCheckFnId() {
		return customCheckFnId;
	}

	public void setCustomCheckFnId(String customCheckFnId) {
		this.customCheckFnId = customCheckFnId;
	}
}
