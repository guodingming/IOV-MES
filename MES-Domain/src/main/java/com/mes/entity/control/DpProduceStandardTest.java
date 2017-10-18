package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-产品测试标准
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpProduceStandardTest", description = "开发平台-产品测试标准")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpProduceStandardTest extends TrackableEntity {
    @ApiModelProperty(value = "属所生产工序ID")
    private String produceProcessId;
    @ApiModelProperty(value = "配置id")
    private String tiId;
    @ApiModelProperty(value = "配置名称")
    private String tiName;
    @ApiModelProperty(value = "标准值")
    private String tiStandard;
    @ApiModelProperty(value = "上线值")
    private String tiUpper;
    @ApiModelProperty(value = "下限值")
    private String tiLower;
    private long order;

    public String getProduceProcessId() {
        return produceProcessId;
    }

    public void setProduceProcessId(String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }

    public String getTiName() {
        return tiName;
    }

    public void setTiName(String tiName) {
        this.tiName = tiName;
    }

    public String getTiStandard() {
        return tiStandard;
    }

    public void setTiStandard(String tiStandard) {
        this.tiStandard = tiStandard;
    }

    public String getTiUpper() {
        return tiUpper;
    }

    public void setTiUpper(String tiUpper) {
        this.tiUpper = tiUpper;
    }

    public String getTiLower() {
        return tiLower;
    }

    public void setTiLower(String tiLower) {
        this.tiLower = tiLower;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getTiId() {
        return tiId;
    }

    public void setTiId(String tiId) {
        this.tiId = tiId;
    }
}
