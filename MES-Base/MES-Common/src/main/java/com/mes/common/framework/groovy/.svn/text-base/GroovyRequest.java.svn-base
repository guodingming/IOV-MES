package com.mes.common.framework.groovy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * 通过restful接口执行groovy脚本的请求体，注意请求头Content-Type必须设置为：application/octet-stream
 *
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "GroovyRequest", description = "groovy脚本调用请求")
public class GroovyRequest {
    /**
     * 脚本片段
     */
    @ApiModelProperty(value = "脚本片段")
    private String script;
    /**
     * 脚本文件
     */
    @ApiModelProperty(value = "脚本文件路径")
    private String file;
    /**
     * 脚本中的函数名称
     */
    @ApiModelProperty(value = "函数名称")
    private String fn;
    /**
     * 脚本中的参数和值映射
     */
    @ApiModelProperty(value = "脚本中的参数和值映射")
    private Map<String, Object> params;
    /**
     * 函数的参数
     */
    @ApiModelProperty(value = "函数的参数")
    private Object[] args;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
