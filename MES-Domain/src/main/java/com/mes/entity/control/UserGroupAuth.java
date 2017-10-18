package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by dengyun.le on 2017/7/13.
 */
@ApiModel(value = "UserGroupAuth", description = "用户组及其用户")
public class UserGroupAuth {
    @ApiModelProperty(value = "用户组Id")
    private String groupId;
    @ApiModelProperty(value = "用户Id列表")

    private List<String> userIds;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
