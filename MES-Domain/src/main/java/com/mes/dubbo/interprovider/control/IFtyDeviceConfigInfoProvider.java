package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.FtyDeviceConfig;
import com.mes.entity.control.FtyDeviceConfigInfo;

import java.util.List;

public interface IFtyDeviceConfigInfoProvider extends DubboBaseInterface<FtyDeviceConfigInfo> {
    /**
     * 根据车间查询以设备类别分类的设备列表
     *
     * @param areaId
     * @return
     */
    List<Node> getDevicesTypedTree(String areaId);

    /**
     * 根据设备id和设备配置类型id分页查询设备配置信息
     *
     * @param deviceId
     * @param deviceConfigTypeId
     * @param page
     * @return
     */
    Page getPageByConfigType(String deviceId, String deviceConfigTypeId, Page page);

    /**
     * 根据设备id和设备配置类型id查询设备配置信息
     *
     * @param deviceId
     * @param deviceConfigTypeId
     * @return
     */
    List<FtyDeviceConfigInfo> getAllByConfigType(String deviceId, String deviceConfigTypeId) throws DubboProviderException;

    /**
     * 根据设备id查询设备配置类型列表
     *
     * @param deviceId
     * @return
     */
    List<DpDataDictionary> getDeviceConfigTypes(String deviceId);

    /**
     * 上传设备配置文件
     * @param config
     * @param info
     * @return
     */
    String saveUploadConfigInfo(FtyDeviceConfig config, FtyDeviceConfigInfo info) throws DubboProviderException;

    /**
     * 查询远程配置文件xml内容
     *
     * @param fileTypeCode
     * @param produceProcessId
     * @param deviceId
     * @param deviceConfigType
     * @return
     * @throws DubboProviderException
     */
    String getRemoteConfigXml(String fileTypeCode, String produceProcessId, String deviceId, String deviceConfigType) throws DubboProviderException;
}
