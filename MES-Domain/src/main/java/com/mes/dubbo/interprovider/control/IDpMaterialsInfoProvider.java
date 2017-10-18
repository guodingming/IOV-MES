package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpMaterialsInfo;

/**
 * 开发平台-上料管理
*/
public interface IDpMaterialsInfoProvider extends DubboBaseInterface<DpMaterialsInfo> {

    /**
     * 批量持久化对象的信息
     *
     * @param materialsInfo
     * @return
     * @throws DubboProviderException
     */
    public boolean saveUpdate(DpMaterialsInfo materialsInfo) throws DubboProviderException;
}
