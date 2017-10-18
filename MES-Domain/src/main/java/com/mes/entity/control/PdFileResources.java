package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资源文件管理
*/
@ApiModel(value = "PdFileResources", description = "资源文件管理")
public class PdFileResources extends TrackableEntity {
	@ApiModelProperty(value = "文件名称")
	private String fileName;
	@ApiModelProperty(value = "文件别名")
	private String otherFileName;
	@ApiModelProperty(value = "文件路径")
	private String filePath;
	@ApiModelProperty(value = "分类ID")
	private String fileTypeId;
	@ApiModelProperty(value = "版本")
	private String version;
	@ApiModelProperty(value = "erp编码")
	private String code;

	@ApiModelProperty(value = "类型")
	private String type;


	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOtherFileName() {
		return otherFileName;
	}
	public void setOtherFileName(String otherFileName) {
		this.otherFileName = otherFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileTypeId() {
		return fileTypeId;
	}
	public void setFileTypeId(String fileTypeId) {
		this.fileTypeId = fileTypeId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
}
