package com.mes.entity.control;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by xiuyou.xu on 2017/7/21.
 */
@ApiModel(value = "PdBomMaterialAmount", description = "BOM中一行数据中的物料及其用量等信息")
public class PdBomMaterialAmount {
    /**
     * BOM中一行数据中的产品
     */
    @ApiModelProperty(value = "BOM中一行数据中的产品")
    private PdBomMaterialsVersion product;
    /**
     * BOM中一行数据中的组件物料
     */
    @ApiModelProperty(value = "BOM中一行数据中的组件物料")
    private PdBomMaterialsVersion materials;
    /**
     * BOM中一行数据中的替代物料
     */
    @ApiModelProperty(value = "BOM中一行数据中的替代物料")
    private PdBomMaterialsVersion replacement;
    /**
     * BOM中一行数据中的物料用量等信息
     */
    @ApiModelProperty(value = "BOM中一行数据中的物料用量等信息")
    private PdBomProduceAmount amount;

    public PdBomMaterialsVersion getProduct() {
        return product;
    }

    public void setProduct(PdBomMaterialsVersion product) {
        this.product = product;
    }

    public PdBomMaterialsVersion getMaterials() {
        return materials;
    }

    public void setMaterials(PdBomMaterialsVersion materials) {
        this.materials = materials;
    }

    public PdBomMaterialsVersion getReplacement() {
        return replacement;
    }

    public void setReplacement(PdBomMaterialsVersion replacement) {
        this.replacement = replacement;
    }

    public PdBomProduceAmount getAmount() {
        return amount;
    }

    public void setAmount(PdBomProduceAmount amount) {
        this.amount = amount;
    }
}
