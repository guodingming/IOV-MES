package com.mes.common.framework.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 继承自该类的entity表示是可被跟踪的，可以查询对应实体
 */
public class TrackableEntity implements Serializable {

    private static final long serialVersionUID = -4052705808523280313L;
    @NotNull(message = "id不可以为null", groups = {BeanValidationGroups.UpdateGroup.class})
    private String id;
    @ApiModelProperty(value = "记录创建时间", required = true, example = "2016-08-01 12:24:36")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @ApiModelProperty(value = "记录更新时间", required = true, example = "2016-08-01 12:24:36")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @ApiModelProperty(value = "扩展字段，例如：{\"key1\":\"value1\",\"key2\":\"value2\"}")
    private Map<String,Object> expandMap;

    public TrackableEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * 扩展字段
     */
    public Map<String, Object> getExpandMap() {
        return expandMap;
    }

    public void setExpandMap(Map<String, Object> expandMap) {
        this.expandMap = expandMap;
    }
}
