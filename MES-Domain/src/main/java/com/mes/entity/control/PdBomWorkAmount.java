package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品管理-工单BOM管理用量
*/
@ApiModel(value = "PdBomWorkAmount", description = "产品管理-工单BOM管理用量")
public class PdBomWorkAmount extends TrackableEntity {
	@ApiModelProperty(value = "父ID")
	private String parentId;
	@ApiModelProperty(value = "用量")
	private String amountNum;
	@ApiModelProperty(value = "损耗率")
	private String attritionRate;
	@ApiModelProperty(value = "是否有替换料")
	private String isReplace;
	@ApiModelProperty(value = "物料版本ID")
	private String materialsVersionId;
	@ApiModelProperty(value = "BOM_ID")
	private String bomWorkId;


	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAmountNum() {
		return amountNum;
	}
	public void setAmountNum(String amountNum) {
		this.amountNum = amountNum;
	}
	public String getAttritionRate() {
		return attritionRate;
	}
	public void setAttritionRate(String attritionRate) {
		this.attritionRate = attritionRate;
	}
	public String getIsReplace() {
		return isReplace;
	}
	public void setIsReplace(String isReplace) {
		this.isReplace = isReplace;
	}
	public String getMaterialsVersionId() {
		return materialsVersionId;
	}
	public void setMaterialsVersionId(String materialsVersionId) {
		this.materialsVersionId = materialsVersionId;
	}
	public String getBomWorkId() {
		return bomWorkId;
	}
	public void setBomWorkId(String bomWorkId) {
		this.bomWorkId = bomWorkId;
	}
}
