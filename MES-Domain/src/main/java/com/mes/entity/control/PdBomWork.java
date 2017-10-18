package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-工单BOM管理
*/
@ApiModel(value = "PdBomWork", description = "产品管理-工单BOM管理")
public class PdBomWork extends TrackableEntity {
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "BOM版本")
	private String version;
	@ApiModelProperty(value = "BOM状态（审核通过，未通过）")
	private String status;
	@ApiModelProperty(value = "产品ID")
	private String pdId;
	@ApiModelProperty(value = "产品名称")
	private String pdName;
	@ApiModelProperty(value = "物料编码")
	private String code;
	@ApiModelProperty(value = "物料类型")
	private String type;
	@ApiModelProperty(value = "来源生产BOM_id")
	private String bomProduceId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPdId() {
		return pdId;
	}
	public void setPdId(String pdId) {
		this.pdId = pdId;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBomProduceId() {
		return bomProduceId;
	}
	public void setBomProduceId(String bomProduceId) {
		this.bomProduceId = bomProduceId;
	}
}
