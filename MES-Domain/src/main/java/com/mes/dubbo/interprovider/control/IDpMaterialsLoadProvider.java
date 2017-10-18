package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.DpMaterialsLoad;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.PdWorkOrder;

/**
* 开发平台-上料管理-上料
* Created by xiuyou.xu on 2017/09/21.
*/
public interface IDpMaterialsLoadProvider extends DubboBaseInterface<DpMaterialsLoad> {

    /**
     * 保存上料工序信息
     *
     * @param dpMaterialsLoad
     * @param pdWorkOrder
     * @param dpProduceProcess
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject saveLoadMaterial(DpMaterialsLoad dpMaterialsLoad, PdWorkOrder pdWorkOrder, DpProduceProcess dpProduceProcess) throws DubboProviderException;
}
