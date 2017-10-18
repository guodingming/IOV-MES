package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-包装箱管理
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpBox", description = "开发平台-包装箱管理")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpBox extends TrackableEntity {
    @ApiModelProperty(value = "父节点")
    private String parentId;
    @ApiModelProperty(value = "箱码")
    private String boxKey;
    @ApiModelProperty(value = "生成规则Id")
    private String dpBoxRuleId;
    @ApiModelProperty(value = "产品ID")
    private String pdId;
    @ApiModelProperty(value = "额定容量")
    private Long capacity;
    @ApiModelProperty(value = "数量")
    private Long quantity;
    @ApiModelProperty(value = "是否强制装箱（0、1）")
    private String isForcedPack;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public String getBoxKey() {
        return boxKey;
    }

    public void setBoxKey(String boxKey) {
        this.boxKey = boxKey;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
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

    public String getIsForcedPack() {
        return isForcedPack;
    }

    public void setIsForcedPack(String isForcedPack) {
        this.isForcedPack = isForcedPack;
    }

    public String getDpBoxRuleId() {
        return dpBoxRuleId;
    }

    public void setDpBoxRuleId(String dpBoxRuleId) {
        this.dpBoxRuleId = dpBoxRuleId;
    }
}
