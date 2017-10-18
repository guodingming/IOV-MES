package com.mes.entity.control;

import com.mes.common.framework.domain.BeanValidationGroups;
import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by xiuyou.xu on 2017/7/6.
 */
@ApiModel(value = "ExpandTableConfig", description = "扩展表配置")
public class ExpandTableConfig extends TrackableEntity {
    @ApiModelProperty(value = "主表id")
    @NotNull(message = "主表id不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String tableId;
    @ApiModelProperty(value = "扩展表名称")
    @NotNull(message = "扩展表名称不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String tableName;
    @ApiModelProperty(value = "是否有历史表")
    private String isHistoryTable;
    @ApiModelProperty(value = "历史表名称")
    private String historyTableName;
    @ApiModelProperty(value = "与主表关联的扩展表字段id")
    @NotNull(message = "与主表关联的扩展表字段id不可以为null", groups = {BeanValidationGroups.CreateGroup.class})
    private String fkColumnId;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIsHistoryTable() {
        return isHistoryTable;
    }

    public void setIsHistoryTable(String isHistoryTable) {
        this.isHistoryTable = isHistoryTable;
    }

    public String getHistoryTableName() {
        return historyTableName;
    }

    public void setHistoryTableName(String historyTableName) {
        this.historyTableName = historyTableName;
    }

    public String getFkColumnId() {
        return fkColumnId;
    }

    public void setFkColumnId(String fkColumnId) {
        this.fkColumnId = fkColumnId;
    }
}
