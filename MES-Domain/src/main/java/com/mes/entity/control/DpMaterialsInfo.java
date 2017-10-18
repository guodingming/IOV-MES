package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 开发平台-上料管理
*/
@ApiModel(value = "DpMaterialsInfo", description = "开发平台-上料管理")
public class DpMaterialsInfo extends TrackableEntity {

	/**
	 * 物料类型
	 */
	public static class Type {
		/**
		 * 条码料
		 */
		public static final String BAR_MATERIAL = "1";
		/**
		 * 批次料
		 */
		public static final String BATCH_MATERIAL = "2";

	}

	@ApiModelProperty(value = "物料名称")
	private String name;
	@ApiModelProperty(value = "物料编码")
	private String code;
	@ApiModelProperty(value = "类型（批次料，条码料）")
	private String type;
	@ApiModelProperty(value = "属所产品生产工序ID")
	private String produceProcessId;
	@ApiModelProperty(value = "物料ID")
	private String bomMaterialsId;
	@ApiModelProperty(value = "物料IDs")
	private List<String> bomMaterialsIds;


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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduceProcessId() {
		return produceProcessId;
	}
	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}
	public String getBomMaterialsId() {
		return bomMaterialsId;
	}

	public void setBomMaterialsId(String bomMaterialsId) {
		this.bomMaterialsId = bomMaterialsId;
	}

	public List<String> getBomMaterialsIds() {
		return bomMaterialsIds;
	}

	public void setBomMaterialsIds(List<String> bomMaterialsIds) {
		this.bomMaterialsIds = bomMaterialsIds;
	}
}
