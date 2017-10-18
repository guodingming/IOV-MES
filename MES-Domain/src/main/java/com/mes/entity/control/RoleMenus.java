package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/12.
 */
@ApiModel(value = "RoleMenus", description = "角色及其已授权菜单项")
public class RoleMenus {
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "菜单id列表")
    private List<String> menuIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
