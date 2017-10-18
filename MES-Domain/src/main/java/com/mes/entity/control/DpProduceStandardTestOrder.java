package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-产品测试标准-测试顺序
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpProduceStandardTestOrder", description = "开发平台-产品测试标准-测试顺序")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpProduceStandardTestOrder extends TrackableEntity {
    @ApiModelProperty(value = "属所生产工序ID")
    private String produceProcessId;
    @ApiModelProperty(value = "测试项名称")
    private String name;
    @ApiModelProperty(value = "排序")
    private String order;
    @ApiModelProperty(value = "signal")
    private String signal;
    private long dataOrder;

    public String getProduceProcessId() {
        return produceProcessId;
    }

    public void setProduceProcessId(String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public long getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(long dataOrder) {
        this.dataOrder = dataOrder;
    }
}
