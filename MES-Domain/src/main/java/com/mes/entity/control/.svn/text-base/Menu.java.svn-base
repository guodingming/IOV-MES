package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/10.
 */
@ApiModel(value = "Menu", description = "菜单")
public class Menu extends TrackableEntity {
    @ApiModelProperty(value = "上级菜单id")
    private String parentId;
    @ApiModelProperty(value = "上级菜单名称")
    private String parentName;
    @ApiModelProperty(value = "菜单级别")
    private Integer level;
    @ApiModelProperty(value = "菜单显示名称")
    private String name;
    @ApiModelProperty(value = "菜单对应页面url")
    private String url;
    @ApiModelProperty(value = "菜单描述")
    private String description;
    @ApiModelProperty(value = "菜单项顺序")
    private Integer itemOrder;
    @ApiModelProperty(value = "菜单项图标")
    private String icon;
    @ApiModelProperty(value = "子菜单列表")
    private List<Menu> subMenus;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
