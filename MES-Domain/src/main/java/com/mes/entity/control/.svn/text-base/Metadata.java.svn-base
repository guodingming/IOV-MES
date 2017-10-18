package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
@ApiModel(value = "Metadata", description = "表字段信息")
public class Metadata extends TrackableEntity {
    @ApiModelProperty(value = "字段中文名称")
    private String name;
    @ApiModelProperty(value = "字段英文名称")
    @NotNull(message = "字段英文名称不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String column;
    @ApiModelProperty(value = "字段数据类型")
    @NotNull(message = "字段数据类型不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String type;
    @ApiModelProperty(value = "字段最大数据长度")
    private String length;
    @ApiModelProperty(value = "字段是否允许为空")
    private String  isNull;
    @ApiModelProperty(value = "字段是否为主键")
    private String isPk;
    @ApiModelProperty(value = "字段默认值")
    private String defaultValue;
    @ApiModelProperty(value = "字段所属表id")
    @NotNull(message = "字段所属表id不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String tableId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getIsPk() {
        return isPk;
    }

    public void setIsPk(String isPk) {
        this.isPk = isPk;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
}
