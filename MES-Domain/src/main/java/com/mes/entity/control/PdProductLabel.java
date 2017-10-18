package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 产品管理-产品标签
 * <p>
 * Created by xiuyou.xu on 2017/09/28.
 */
@ApiModel(value = "PdProductLabel", description = "产品管理-产品标签")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdProductLabel extends TrackableEntity {


    @ApiModelProperty(value = "标签ID")
    private String labelId;


    @ApiModelProperty(value = "产品ID")
    private String pdId;


    @ApiModelProperty(value = "标签名称")
    private String labelName;


    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

}
