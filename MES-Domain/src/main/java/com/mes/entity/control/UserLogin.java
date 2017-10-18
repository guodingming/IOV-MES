package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xiuyou.xu on 2017/7/18.
 */
@ApiModel(value = "UserLogin", description = "用户登录信息")
public class UserLogin {
    @ApiModelProperty(value = "登录名")
    @NotNull(message = "登录名")
    private String username;
    @ApiModelProperty(value = "登录密码")
    @NotNull(message = "登录密码")
    private String password;
    private Boolean adAuth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdAuth() {
        return adAuth;
    }

    public void setAdAuth(Boolean adAuth) {
        this.adAuth = adAuth;
    }
}
