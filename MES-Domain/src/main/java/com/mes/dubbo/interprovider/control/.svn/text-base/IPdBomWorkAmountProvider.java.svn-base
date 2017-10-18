package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdBomMaterials;
import com.mes.entity.control.PdBomWorkAmount;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-工单BOM管理用量
*/
public interface IPdBomWorkAmountProvider extends DubboBaseInterface<PdBomWorkAmount> {
    /**
     * 根据类型查询bom中的物料列表
     *
     * @param bomWorkId
     * @param type
     * @return
     */
    List<PdBomMaterials> getBomMaterialsByType(String bomWorkId, String type) throws DubboProviderException;

    /**
     * 根据工单bom id和物料编码获取物料内外部版本
     *
     * @param bomWorkId
     * @param materialCode
     * @return
     * @throws DubboProviderException
     */
    Map<String, Object> getVersions(String bomWorkId, String materialCode) throws DubboProviderException;
}
