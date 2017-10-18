package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-产品明细-产品标签
 * <p>
 * Created by xiuyou.xu on 2017/09/27.
 */
@ApiModel(value = "PdProductPdLable", description = "开发平台-产品明细-产品标签")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdProductPdLable extends TrackableEntity {


    @ApiModelProperty(value = "产品明细ID")
    private String pdProductInfoId;


    @ApiModelProperty(value = "标签内容")
    private String content;


    public String getPdProductInfoId() {
        return pdProductInfoId;
    }

    public void setPdProductInfoId(String pdProductInfoId) {
        this.pdProductInfoId = pdProductInfoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
