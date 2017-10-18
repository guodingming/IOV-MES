package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.DpRepairStationBadInfo;

/**
* 开发平台-产品维修站-不良信息
* Created by xiuyou.xu on 2017/08/25.
*/
public interface IDpRepairStationBadInfoProvider extends DubboBaseInterface<DpRepairStationBadInfo> {

    /**
     * 根据产品条码获取产品不良信息
     * @param number
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getBadInfoByNumber(String number) throws DubboProviderException;

    /**
     * 保存不良信息
     * @param dpRepairStationBadInfo
     * @param produceProcess
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject saveRepairInfo(DpRepairStationBadInfo dpRepairStationBadInfo, DpProduceProcess produceProcess) throws DubboProviderException;

}
