package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.DpRepairStation;

/**
* 开发平台-产品维修站
* Created by xiuyou.xu on 2017/08/25.
*/
public interface IDpRepairStationProvider extends DubboBaseInterface<DpRepairStation> {

    //public List<DpRepairStation> findByWorkOrderId(String )

    /**
     * 根据产品条码获取产品维修站信息
     *
     * @param number
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getRepairStationInfoByNumber(String number) throws DubboProviderException;

    /**
     * 获取维修站出口工序信息
     *
     * @param pdProductInfoId
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getRepairStationNextProcess(String pdProductInfoId) throws DubboProviderException;
}
