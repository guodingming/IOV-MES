package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-栈板管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpBoxPallet", description = "开发平台-栈板管理")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpBoxPallet extends TrackableEntity {
    @ApiModelProperty(value = "栈板条码")
    private String palletKey;
    @ApiModelProperty(value = "条码分类ID")
    private String barcodeTypeId;
    @ApiModelProperty(value = "条码规则ID")
    private String barcodeId;
    @ApiModelProperty(value = "产品ID")
    private String pdId;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "额定容量")
    private Long capacity;
    @ApiModelProperty(value = "数量")
    private Long quantity;
    @ApiModelProperty(value = "栈板标签分类ID")
    private String labelTypeId;
    @ApiModelProperty(value = "栈板标签ID")
    private String labelId;

    public String getPalletKey() {
        return palletKey;
    }

    public void setPalletKey(String palletKey) {
        this.palletKey = palletKey;
    }

    public String getBarcodeTypeId() {
        return barcodeTypeId;
    }

    public void setBarcodeTypeId(String barcodeTypeId) {
        this.barcodeTypeId = barcodeTypeId;
    }

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getLabelTypeId() {
        return labelTypeId;
    }

    public void setLabelTypeId(String labelTypeId) {
        this.labelTypeId = labelTypeId;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
}
