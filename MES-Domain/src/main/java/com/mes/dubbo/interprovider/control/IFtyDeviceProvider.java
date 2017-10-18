package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.FtyDevice;

import java.util.List;

public interface IFtyDeviceProvider extends DubboBaseInterface<FtyDevice> {

    /**
     * 根据车间分页查询设备列表
     * @param page
     * @return
     * @throws DubboProviderException
     */
    Page getDevicePageByAreaId(Page page) throws DubboProviderException;

    /**
     *  新增设备信息以及设备配置信息
     */
     void saveDeviceAndConfigInfo(FtyDevice ftyDevice);

    /**
     *  保存设备信息以及设备配置信息
     */
    void updateDeviceAndConfigInfo(FtyDevice ftyDevice);


    /**
     * 根据工序ID查询设备信息列表
     * @param processId
     * @return
     * @throws DubboProviderException
     */
    List<FtyDevice> findDeviceListByProcessId(String processId) throws DubboProviderException;

    public String findByIp(String ip) throws DubboProviderException;

}
