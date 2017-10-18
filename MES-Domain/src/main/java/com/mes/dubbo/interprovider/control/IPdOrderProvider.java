package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.PdOrder;

/**
 * 产品管理-产品订单管理
*/
public interface IPdOrderProvider extends DubboBaseInterface<PdOrder> {

    /**
     * 根据产品Id分页查询订单列表
     * @param page
     * @return
     * @throws DubboProviderException
     */
    public Page findByPdId(Page page)throws DubboProviderException;
}
