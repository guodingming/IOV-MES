package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "Role", description = "角色")
public class Role extends TrackableEntity {
    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String name;
    @ApiModelProperty(value = "描述")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
