package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.FtyDeviceProcessAnnex;

import java.util.List;
import java.util.Map;

public interface IFtyDeviceProcessAnnexProvider extends DubboBaseInterface<FtyDeviceProcessAnnex> {
    /**
     * @Author jinlong.zhu
     * @Date 2017/8/2 20:00
     * 更新设备-工序-附件
     */
     void updateFtyDeviceProcessAnnex(FtyDeviceProcessAnnex ftyDeviceProcessAnnex)throws DubboProviderException;

   public boolean saveFtyDeviceProcessAnnex(FtyDeviceProcessAnnex ftyDeviceProcessAnnex)throws DubboProviderException;

    /**
     * 根据设备id，生产工序id和附件类别名称，获取最新的附件信息
     * @param deviceId
     * @param annexTypeName
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    Map<String, Object> getDeviceAnnexInfo(String deviceId, String annexTypeName, String produceProcessId) throws DubboProviderException;

    /**
     * 根据设备工序ID查询工装类型
     *
     * @param query
     * @return
     * @throws DubboProviderException
     */
    public List<FtyDeviceProcessAnnex> findAnnexByDeviceProcessId(Map<String, Object> query) throws DubboProviderException;


}
