package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-服务管理
*/
@ApiModel(value = "DpService", description = "开发平台-服务管理")
public class DpService extends TrackableEntity {
	@ApiModelProperty(value = "服务名称")
	private String name;
	@ApiModelProperty(value = "服务编码")
	private String code;
	@ApiModelProperty(value = "服务地址")
	private String url;
	@ApiModelProperty(value = "接口方法名")
	private String methodName;
	@ApiModelProperty(value = "接口参数模板内容")
	private String templateParameterContent;
	@ApiModelProperty(value = "接口返回结果模板内容")
	private String templateResultContent;
	@ApiModelProperty(value = "接口调用方法（get、post）")
	private String method;
	@ApiModelProperty(value = "发布状态（发布|未发布）")
	private String status;
	@ApiModelProperty(value = "属所服务分类ID")
	private String serviceTypeId;
	@ApiModelProperty(value = "描述")
	private String description;
	@ApiModelProperty(value = "接口请求数据类型，sql或script")
	private String type;
//	@ApiModelProperty(value = "对象类型id")
//	private String tableTypeId;
//	@ApiModelProperty(value = "对象id")
//	private String tableId;
//	@ApiModelProperty(value = "sql语句类型，select或update")
//	private String sqlType;
//	@ApiModelProperty(value = "sql语句")
//	private String sql;
	@ApiModelProperty(value = "函数分类id")
	private String fnTypeId;

	@ApiModelProperty(value = "函数id")
	private String fnId;

	@ApiModelProperty(value = "函数名称")
	private String fnName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getTemplateParameterContent() {
		return templateParameterContent;
	}

	public void setTemplateParameterContent(String templateParameterContent) {
		this.templateParameterContent = templateParameterContent;
	}

	public String getTemplateResultContent() {
		return templateResultContent;
	}

	public void setTemplateResultContent(String templateResultContent) {
		this.templateResultContent = templateResultContent;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public String getTableTypeId() {
//		return tableTypeId;
//	}
//
//	public void setTableTypeId(String tableTypeId) {
//		this.tableTypeId = tableTypeId;
//	}
//
//	public String getTableId() {
//		return tableId;
//	}
//
//	public void setTableId(String tableId) {
//		this.tableId = tableId;
//	}
//
//	public String getSqlType() {
//		return sqlType;
//	}
//
//	public void setSqlType(String sqlType) {
//		this.sqlType = sqlType;
//	}
//
//	public String getSql() {
//		return sql;
//	}
//
//	public void setSql(String sql) {
//		this.sql = sql;
//	}

	public String getFnTypeId() {
		return fnTypeId;
	}

	public void setFnTypeId(String fnTypeId) {
		this.fnTypeId = fnTypeId;
	}

	public String getFnId() {
		return fnId;
	}

	public void setFnId(String fnId) {
		this.fnId = fnId;
	}

	public String getFnName() {
		return fnName;
	}

	public void setFnName(String fnName) {
		this.fnName = fnName;
	}
}
