package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by dengyun.le on 2017/7/26.
 */
@ApiModel(value = "ExpandFieldSave", description = "扩展字段保存")
public class ExpandFieldSave {
    @ApiModelProperty(value = "主表Id")
    private String tableId;
    @ApiModelProperty(value = "字段信息列表")
    private List<Metadata> columnList;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public List<Metadata> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Metadata> columnList) {
        this.columnList = columnList;
    }
}
