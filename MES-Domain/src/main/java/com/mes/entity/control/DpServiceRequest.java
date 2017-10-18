package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/7/28.
 */
@ApiModel(value = "服务接口调用请求参数")
public class DpServiceRequest implements Serializable {
    @ApiModelProperty(value = "服务接口编码")
    private String code;
    @ApiModelProperty(value = "传入服务接口的脚本中的执行参数，key为脚本中的参数名称")
    private Map<String, Object> params;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
