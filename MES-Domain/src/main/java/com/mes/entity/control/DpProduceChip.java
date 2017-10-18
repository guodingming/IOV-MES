package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 开发平台-产品芯片
 * Created by xiuyou.xu on 2017/7/4.
 */
@ApiModel(value = "DpProduceChip", description = "开发平台-产品芯片")
@XmlAccessorType(XmlAccessType.FIELD)
public class DpProduceChip extends TrackableEntity {
    @ApiModelProperty(value = "属所生产工序ID")
    private String produceProcessId;
    @ApiModelProperty(value = "procedure_name")
    private String procedureName;
    @ApiModelProperty(value = "serial_id")
    private String serialId;
    @ApiModelProperty(value = "addr")
    private String addr;
    @ApiModelProperty(value = "byte_num")
    private String byteNum;
    @ApiModelProperty(value = "source_type_name")
    private String sourceTypeName;
    @ApiModelProperty(value = "content")
    private String content;
    @ApiModelProperty(value = "store_type_name")
    private String storeTypeName;
    @ApiModelProperty(value = "oper_code_name")
    private String operCodeName;
    @ApiModelProperty(value = "chip_sequence")
    private String chipSequence;
    @ApiModelProperty(value = "programmer_type_name")
    private String programmerTypeName;
    @ApiModelProperty(value = "model_name")
    private String modelName;
    @ApiModelProperty(value = "delay_time")
    private String delayTime;
    @ApiModelProperty(value = "oper_describe")
    private String operDescribe;
    private long order;

    public String getProduceProcessId() {
        return produceProcessId;
    }

    public void setProduceProcessId(String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getByteNum() {
        return byteNum;
    }

    public void setByteNum(String byteNum) {
        this.byteNum = byteNum;
    }

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStoreTypeName() {
        return storeTypeName;
    }

    public void setStoreTypeName(String storeTypeName) {
        this.storeTypeName = storeTypeName;
    }

    public String getOperCodeName() {
        return operCodeName;
    }

    public void setOperCodeName(String operCodeName) {
        this.operCodeName = operCodeName;
    }

    public String getChipSequence() {
        return chipSequence;
    }

    public void setChipSequence(String chipSequence) {
        this.chipSequence = chipSequence;
    }

    public String getProgrammerTypeName() {
        return programmerTypeName;
    }

    public void setProgrammerTypeName(String programmerTypeName) {
        this.programmerTypeName = programmerTypeName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public String getOperDescribe() {
        return operDescribe;
    }

    public void setOperDescribe(String operDescribe) {
        this.operDescribe = operDescribe;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}
