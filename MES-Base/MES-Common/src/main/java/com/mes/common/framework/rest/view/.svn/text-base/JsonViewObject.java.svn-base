package com.mes.common.framework.rest.view;


import com.mes.common.framework.Constants;
import com.mes.common.utils.ErrorCodes;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * restful对外的JSON 对象封装
 */
@XmlRootElement(name="view")
@XmlAccessorType(XmlAccessType.FIELD)
public class JsonViewObject implements Serializable {
    @ApiModelProperty(value = "错误码")
    @XmlElement(name = "errorCode")
    private String errorCode;
    @ApiModelProperty(value = "响应的状态，成功为success，失败为fail", required = true, example = "success")
    @XmlElement(name = "status")
    private String status;
    @ApiModelProperty(value = "响应的说明信息，如调用出错原因，操作成功的提示信息等，可能为空", required = true, example = "条件查询成功！")
    @XmlElement(name = "message")
    private String message;
    @ApiModelProperty(value = "响应的业务内容，如根据id查询得到的记录信息，分页查询的Page对象等", required = true, example = "[{\"name\":\"Jack\",\"age\":20},{\"name\":\"Tom\",\"age\":22}]")
    @XmlElement(name = "content")
    private Object content;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public JsonViewObject pack(String errorCode, Object content) {
        this.setErrorCode(errorCode);
        String errorMessage = ErrorCodes.getMessage(errorCode);
        this.setMessage(errorMessage);
        this.setContent(content);

        return this;
    }

    public JsonViewObject noErrorPack(Object content) {
        return pack(ErrorCodes.NO_ERROR, content);
    }

    /**
     * 因在table_template.js文件中，请求deleteByIds方法时，
     * 如果删除成功，需要对status和content同时校验
     * 固，此处增加success方法，用来固定后台删除成功后的调用，
     * 避免前后台数据格式不同意导致前台提示删除失败假象
     *
     * @author vain@ccuu.me
     */
    public JsonViewObject success() {
        this.setContent("true");
        this.setStatus(Constants.jsonView.STATUS_SUCCESS);
        return this;
    }

    public JsonViewObject successPack(Object result) {
        this.setMessage("");
        this.setContent(result);
        this.setStatus(Constants.jsonView.STATUS_SUCCESS);
        return this;
    }

    public JsonViewObject successPack(Object result, String msg) {
        this.setContent(result);
        this.setMessage(msg);
        this.setStatus(Constants.jsonView.STATUS_SUCCESS);
        return this;
    }

    public JsonViewObject failPack(Exception e) {
        String message = e.getMessage();
        int index = message.indexOf(":");
        setMessage(index == -1 ? message : message.substring(index + 1));
        setContent("");
        setStatus(Constants.jsonView.STATUS_FAIL);
        return this;
    }

    public JsonViewObject failPack(String errMsg) {
        setMessage(errMsg);
        setContent("");
        setStatus(Constants.jsonView.STATUS_FAIL);
        return this;
    }

    public JsonViewObject failPack(Object result, String errMsg) {
        setMessage(errMsg);
        setContent(result);
        setStatus(Constants.jsonView.STATUS_FAIL);
        return this;
    }

    public JsonViewObject failPackMessage(String errMsg, String content) {
        setMessage(errMsg);
        setContent(content);
        setStatus(Constants.jsonView.STATUS_FAIL);
        return this;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
