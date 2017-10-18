package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-产品测试项
*/
@ApiModel(value = "DpProductTestLog", description = "开发平台-产品测试项")
public class DpProductTestLog extends TrackableEntity {
	@ApiModelProperty(value = "产品唯一编码")
	private String pdNum;
	@ApiModelProperty(value = "生产工序ID")
	private String produceProcessId;
	@ApiModelProperty(value = "工序ID")
	private String processId;
	@ApiModelProperty(value = "ti_name")
	private String tiName;
	@ApiModelProperty(value = "item_data")
	private String itemData;
	@ApiModelProperty(value = "test_result")
	private String testResult;
	@ApiModelProperty(value = "ti_upper")
	private String tiUpper;
	@ApiModelProperty(value = "ti_lower")
	private String tiLower;
	@ApiModelProperty(value = "channel")
	private String channel;


	public String getPdNum() {
		return pdNum;
	}
	public void setPdNum(String pdNum) {
		this.pdNum = pdNum;
	}
	public String getProduceProcessId() {
		return produceProcessId;
	}
	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getTiName() {
		return tiName;
	}
	public void setTiName(String tiName) {
		this.tiName = tiName;
	}
	public String getItemData() {
		return itemData;
	}
	public void setItemData(String itemData) {
		this.itemData = itemData;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getTiUpper() {
		return tiUpper;
	}
	public void setTiUpper(String tiUpper) {
		this.tiUpper = tiUpper;
	}
	public String getTiLower() {
		return tiLower;
	}
	public void setTiLower(String tiLower) {
		this.tiLower = tiLower;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
}
