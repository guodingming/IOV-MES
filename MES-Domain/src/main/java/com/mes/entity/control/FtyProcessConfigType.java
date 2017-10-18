package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 工厂管理-工序配置类型
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "FtyProcessConfigType", description = "工厂管理-工序配置类型")
@XmlAccessorType(XmlAccessType.FIELD)
public class FtyProcessConfigType extends TrackableEntity {
    @ApiModelProperty(value = "工序ID")
    private String processId;
    @ApiModelProperty(value = "配置类型字典ID")
    private String configTypeDictId;
    @ApiModelProperty(value = "配置类型字典名称")
    private String name;
    @ApiModelProperty(value = "配置类型字典code")
    private String code;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getConfigTypeDictId() {
        return configTypeDictId;
    }

    public void setConfigTypeDictId(String configTypeDictId) {
        this.configTypeDictId = configTypeDictId;
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
}
