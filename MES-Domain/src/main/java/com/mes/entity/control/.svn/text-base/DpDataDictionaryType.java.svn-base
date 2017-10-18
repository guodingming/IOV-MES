package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开发平台-数据字典类型
 */
@ApiModel(value = "DpDataDictionaryType", description = "开发平台-数据字典类型")
public class DpDataDictionaryType extends TrackableEntity {
    @ApiModelProperty(value = "字典分类名称")
    private String name;
    @ApiModelProperty(value = "字典分类主键")
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && DpDataDictionaryType.class.isInstance(o)) {
            DpDataDictionaryType type = (DpDataDictionaryType) o;
            return this.name.equals(type.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
