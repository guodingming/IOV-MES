package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-设备配置信息
*/
@ApiModel(value = "DpProduceProcessDeviceConfig", description = "开发平台-设备配置信息")
public class DpProduceProcessDeviceConfig extends TrackableEntity {
	@ApiModelProperty(value = "生产工序ID")
	private String produceProcessId;
	@ApiModelProperty(value = "属所设备配置分类ID")
	private String deviceConfigTypeId;
	@ApiModelProperty(value = "配置类型（文件、其他）")
	private String dataType;
	@ApiModelProperty(value = "配置文件名称")
	private String fileName;
	@ApiModelProperty(value = "配置文件别名")
	private String fileAnotherName;
	@ApiModelProperty(value = "存储路径")
	private String filePath;
	@ApiModelProperty(value = "配置参数内容")
	private String content;
	@ApiModelProperty(value = "设备ID")
	private String deviceId;
	@ApiModelProperty(value = "设备配置ID")
	private String deviceConfigId;
	@ApiModelProperty(value = "配置名称")
	private String name;
	@ApiModelProperty(value = "配置版本")
	private String version;


	public String getProduceProcessId() {
		return produceProcessId;
	}
	public void setProduceProcessId(String produceProcessId) {
		this.produceProcessId = produceProcessId;
	}
	public String getDeviceConfigTypeId() {
		return deviceConfigTypeId;
	}
	public void setDeviceConfigTypeId(String deviceConfigTypeId) {
		this.deviceConfigTypeId = deviceConfigTypeId;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileAnotherName() {
		return fileAnotherName;
	}
	public void setFileAnotherName(String fileAnotherName) {
		this.fileAnotherName = fileAnotherName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceConfigId() {
		return deviceConfigId;
	}

	public void setDeviceConfigId(String deviceConfigId) {
		this.deviceConfigId = deviceConfigId;
	}

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
}
