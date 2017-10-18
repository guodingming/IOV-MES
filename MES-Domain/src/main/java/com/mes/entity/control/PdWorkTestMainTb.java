package com.mes.entity.control;

import com.mes.common.framework.domain.TrackableEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
* 终端测试结果
*
* Created by xiuyou.xu on 2017/09/01.
*/
@ApiModel(value = "PdWorkTestMainTb", description = "终端测试结果")
@XmlAccessorType(XmlAccessType.FIELD)
public class PdWorkTestMainTb extends TrackableEntity {
    
    
    @ApiModelProperty(value="$column.description")
    private String workProcedureId;

    @ApiModelProperty(value = "生产工序id")
    private String produceProcessId;

    @ApiModelProperty(value = "单个产品信息id")
    private String productInfoId;
            
    
    @ApiModelProperty(value="$column.description")
    private String channelNo;
            
    
    @ApiModelProperty(value="$column.description")
    private String version;
            
    
    @ApiModelProperty(value="$column.description")
    private String testVersion;
            
    
    @ApiModelProperty(value="$column.description")
    private String testFlag;

    @ApiModelProperty(value = "执行顺序")
    private long order;
        
        
    public String getWorkProcedureId () {
        return workProcedureId;
    }

    public void setWorkProcedureId (String workProcedureId) {
        this.workProcedureId = workProcedureId;
    }
            
    public String getChannelNo () {
        return channelNo;
    }

    public void setChannelNo (String channelNo) {
        this.channelNo = channelNo;
    }
            
    public String getVersion () {
        return version;
    }

    public void setVersion (String version) {
        this.version = version;
    }
            
    public String getTestVersion () {
        return testVersion;
    }

    public void setTestVersion (String testVersion) {
        this.testVersion = testVersion;
    }
            
    public String getTestFlag () {
        return testFlag;
    }

    public void setTestFlag (String testFlag) {
        this.testFlag = testFlag;
    }

    public String getProduceProcessId() {
        return produceProcessId;
    }

    public void setProduceProcessId(String produceProcessId) {
        this.produceProcessId = produceProcessId;
    }

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}
