package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdBomProduceAmount;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-生产BOM管理用量
*/
public interface IPdBomProduceAmountProvider extends DubboBaseInterface<PdBomProduceAmount> {
    /**
     * 根据生产bom id获取物料及其版本信息
     *
     * @param bomProduceId
     * @return
     * @throws DubboProviderException
     */
    List<Map<String, Object>> getMaterialVersions(String bomProduceId) throws DubboProviderException;
}
