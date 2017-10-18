package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-产品明细-物料
*/
@ApiModel(value = "PdProductInfoMaterials", description = "开发平台-产品明细-物料")
public class PdProductInfoMaterials extends TrackableEntity {
	@ApiModelProperty(value = "属所产品ID")
	private String pdProductInfoId;
	@ApiModelProperty(value = "物料清单ID")
	private String pdBomMaterialsId;
	@ApiModelProperty(value = "物料批次")
	private String batchNum;
	@ApiModelProperty(value = "物料编码")
	private String sn;


	public String getPdProductInfoId() {
		return pdProductInfoId;
	}
	public void setPdProductInfoId(String pdProductInfoId) {
		this.pdProductInfoId = pdProductInfoId;
	}
	public String getPdBomMaterialsId() {
		return pdBomMaterialsId;
	}
	public void setPdBomMaterialsId(String pdBomMaterialsId) {
		this.pdBomMaterialsId = pdBomMaterialsId;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
}
