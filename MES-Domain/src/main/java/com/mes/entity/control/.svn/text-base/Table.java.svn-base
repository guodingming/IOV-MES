package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
@ApiModel(value = "Table", description = "主表")
public class Table extends TrackableEntity {
    @ApiModelProperty(value = "表名称")
    @NotNull(message = "表名称不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String name;
    @ApiModelProperty(value = "表中文名称")
    private String cnName;
    @ApiModelProperty(value = "表对应的实体类名称")
   // @NotNull(message = "表对应的实体类名称不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String entityClass;
    @ApiModelProperty(value = "表所属分类")
    private String type;

    @ApiModelProperty(value = "表所属分类Id")
    private String tableTypeId;
    @ApiModelProperty(value = "是否内置表")
    private String isInternal;
    @ApiModelProperty(value = "是否已创建")
    private String isCreate;
    @ApiModelProperty(value = "是否创建扩展表")
    private String isCreateExpand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableTypeId() {
        return tableTypeId;
    }

    public void setTableTypeId(String tableTypeId) {
        this.tableTypeId = tableTypeId;
    }

    public String getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(String isInternal) {
        this.isInternal = isInternal;
    }

    public String getIsCreate() {
        return isCreate;
    }

    public void setIsCreate(String isCreate) {
        this.isCreate = isCreate;
    }

    public String getIsCreateExpand() {
        return isCreateExpand;
    }

    public void setIsCreateExpand(String isCreateExpand) {
        this.isCreateExpand = isCreateExpand;
    }
}
