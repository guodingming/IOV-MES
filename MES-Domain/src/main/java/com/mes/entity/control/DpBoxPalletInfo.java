package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-栈板管理-包装箱
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpBoxPalletInfo", description = "开发平台-栈板管理-包装箱")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpBoxPalletInfo extends TrackableEntity {
    @ApiModelProperty(value = "栈板ID")
    private String palletId;
    @ApiModelProperty(value = "包装箱id")
    private String boxId;
    @ApiModelProperty(value = "箱码")
    private String boxKey;

    public String getPalletId() {
        return palletId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getBoxKey() {
        return boxKey;
    }

    public void setBoxKey(String boxKey) {
        this.boxKey = boxKey;
    }
}
