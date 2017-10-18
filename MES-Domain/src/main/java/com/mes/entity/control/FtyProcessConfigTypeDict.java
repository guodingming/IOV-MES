package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 工厂管理-工序配置类型字典
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "FtyProcessConfigTypeDict", description = "工厂管理-工序配置类型字典")
@XmlAccessorType(XmlAccessType.FIELD)
public class FtyProcessConfigTypeDict extends TrackableEntity {
    @ApiModelProperty(value = "配置类型名称")
    private String name;
    @ApiModelProperty(value = "CODE")
    private String code;

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
}
