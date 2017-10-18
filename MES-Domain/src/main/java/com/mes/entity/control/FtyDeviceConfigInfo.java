package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xiuyou.xu on 2017/7/19.
 */
@ApiModel(value = "FtyDeviceConfigInfo", description = "设备配置详情")
public class FtyDeviceConfigInfo extends TrackableEntity {
    @ApiModelProperty(value = "设备配置详情名称")
    private String name;
    @ApiModelProperty(value = "所属设备配置id")
    private String deviceConfigId;
    @ApiModelProperty(value = "设备配置分类id")
    private String deviceConfigTypeId;
    @ApiModelProperty(value = "配置类型（文件或其他）")
    private String type;
    @ApiModelProperty(value = "配置文件名称")
    private String filename;
    @ApiModelProperty(value = "版本")
    private String version;
    @ApiModelProperty(value = "存储路径")
    private String filePath;
    @ApiModelProperty(value = "配置内容（非文件类配置的配置内容）")
    private String content;
    @ApiModelProperty(value = "配置文件转换后的xml")
    private String fileContent;
    @ApiModelProperty(value = "Excel类型配置文件转换XML函数id")
    private String fnId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceConfigId() {
        return deviceConfigId;
    }

    public void setDeviceConfigId(String deviceConfigId) {
        this.deviceConfigId = deviceConfigId;
    }

    public String getDeviceConfigTypeId() {
        return deviceConfigTypeId;
    }

    public void setDeviceConfigTypeId(String deviceConfigTypeId) {
        this.deviceConfigTypeId = deviceConfigTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFnId() {
        return fnId;
    }

    public void setFnId(String fnId) {
        this.fnId = fnId;
    }
}
