package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 物料版本
 * <p>
 * Created by xiuyou.xu on 2017/9/25.
 */
@ApiModel(value = "PdBomMaterialsVersion", description = "物料版本")
public class PdBomMaterialsVersion extends TrackableEntity {
    @ApiModelProperty(value = "物料id")
    private String materialId;
    @ApiModelProperty(value = "物料名称")
    private String name;
    @ApiModelProperty(value = "物料编码")
    private String code;
    @ApiModelProperty(value = "物料类别")
    private String type;
    @ApiModelProperty(value = "内部版本号")
    private String inVersion;
    @ApiModelProperty(value = "外部版本号")
    private String outVersion;
    @ApiModelProperty(value = "程序文件校验和")
    private String checksum;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

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

    public String getInVersion() {
        return inVersion;
    }

    public void setInVersion(String inVersion) {
        this.inVersion = inVersion;
    }

    public String getOutVersion() {
        return outVersion;
    }

    public void setOutVersion(String outVersion) {
        this.outVersion = outVersion;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
