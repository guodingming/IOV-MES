package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "Dept", description = "部门")
public class Dept extends TrackableEntity {
    @ApiModelProperty(value = "上级部门id")
    @NotNull(message = "上级部门id不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String parentId;
    @NotNull(message = "部门名称", groups = {BeanValidationGroups.CreateGroup.class})
    @ApiModelProperty(value = "部门名称")
    private String name;
    @NotNull(message = "部门编码", groups = {BeanValidationGroups.CreateGroup.class})
    @ApiModelProperty(value = "部门编码")
    private String code;
    @ApiModelProperty(value = "描述")
    private String description;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
