package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.DpProduceProcessAnnex;

import java.util.List;

/**
* 开发平台-生产工序-工装配置信息
* Created by xiuyou.xu on 2017/09/22.
*/
public interface IDpProduceProcessAnnexProvider extends DubboBaseInterface<DpProduceProcessAnnex> {


    /**
     * 获取设备工序附件级联信息
     *
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    public List<Node> processDeviceAnnexInfo(String produceProcessId) throws DubboProviderException;
}
