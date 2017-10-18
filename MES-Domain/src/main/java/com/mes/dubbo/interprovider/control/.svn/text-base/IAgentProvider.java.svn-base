package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.Agent;
import com.mes.entity.control.PdWorkOrder;

/**
* 平台管理-工作站Agent管理
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IAgentProvider extends DubboBaseInterface<Agent> {

    /**
     * 根据ip更新状态
     * @param ip
     * @param status
     */
    void updateStatusByIp(String ip, String status) throws DubboProviderException;

    /**
     * 打印产品标签
     * @param agentId
     * @param pdProductInfoId
     * @return
     * @throws DubboProviderException
     */
    boolean printProductLabel(String agentId, String pdProductInfoId) throws DubboProviderException;

    /**
     * 打印包装箱标签
     *
     * @param agentId
     * @param pdWorkOrder
     * @param boxKey
     * @return
     * @throws DubboProviderException
     */
    boolean printBoxLabel(String agentId, PdWorkOrder pdWorkOrder, String boxKey) throws DubboProviderException;

    /**
     * 打印包装箱条码
     *
     * @param agentId
     * @param boxId
     * @param num
     * @return
     * @throws DubboProviderException
     */
    boolean printBoxBarCode(String agentId, String boxId, int num) throws DubboProviderException;
}
