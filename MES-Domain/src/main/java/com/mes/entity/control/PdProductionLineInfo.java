package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by dengyun.le on 2017/9/29.
 */
@ApiModel(value = "PdproductionLineInfo", description = "平台管理-产品线管理-生产线与产品关联表")
public class PdProductionLineInfo extends TrackableEntity {
    @ApiModelProperty(value = "属所产品ID")
    private String pdId;
    @ApiModelProperty(value = "生产线ID")
    private String productionLineId;
    @ApiModelProperty(value = "生产线名称")
    private String name;

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(String productionLineId) {
        this.productionLineId = productionLineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
