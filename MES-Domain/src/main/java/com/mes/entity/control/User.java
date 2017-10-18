package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "User", description = "用户")
public class User extends TrackableEntity {
    @ApiModelProperty(value = "登录名")
    @NotNull(message = "登录名", groups = {BeanValidationGroups.CreateGroup.class})
    private String username;
    @ApiModelProperty(value = "登录密码")
    @NotNull(message = "登录密码", groups = {BeanValidationGroups.CreateGroup.class})
    private String password;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "工号")
    private String jobNumber;
    @ApiModelProperty(value = "头衔")
    private String title;
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "手机号码")
    private String mobilePhone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "部门id")
    private String deptId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "用户组id")
    private String userGroupId;
    @ApiModelProperty(value = "逻辑删除标记")
    private String isDelete;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
