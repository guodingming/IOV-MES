package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdBomMaterials;
import com.mes.entity.control.PdBomMaterialsVersion;

/**
 * 产品管理-物料清单
*/
public interface IPdBomMaterialsProvider extends DubboBaseInterface<PdBomMaterials> {
    /**
     * 保存物料版本信息
     *
     * @param pdBomMaterialsVersion
     * @return
     * @throws DubboProviderException
     */
    String saveMaterialVersion(PdBomMaterialsVersion pdBomMaterialsVersion) throws DubboProviderException;

    /**
     * 根据物料编码和工单bom id查询物料信息
     *
     * @param code
     * @param bomWorkId
     * @return
     * @throws DubboProviderException
     */
    PdBomMaterials findMaterial(String code, String bomWorkId) throws DubboProviderException;
}
