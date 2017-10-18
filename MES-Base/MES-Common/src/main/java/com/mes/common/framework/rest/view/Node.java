package com.mes.common.framework.rest.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by xiuyou.xu on 2017/7/19.
 */
@ApiModel(value = "Node")
public class Node {
    @ApiModelProperty(value = "树节点id")
    private String id;
    @ApiModelProperty(value = "父节点id")
    private String parentId;
    @ApiModelProperty(value = "树节点名称")
    private String name;
    @ApiModelProperty(value = "树节点描述")
    private String description;
    @ApiModelProperty(value = "节点图标")
    private String icon;
    @ApiModelProperty(value = "树节点下级节点列表")
    private List<Node> children;
    @ApiModelProperty(value = "默认是否展开")
    private boolean isExpand;
    @ApiModelProperty(value = "是否为叶子节点")
    private boolean isLeaf;
    @ApiModelProperty(value = "节点表示的实体对象信息")
    private Object data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
