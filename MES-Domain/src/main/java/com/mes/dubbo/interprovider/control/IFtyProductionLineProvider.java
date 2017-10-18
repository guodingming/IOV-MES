package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.FtyProductionLine;

import java.util.List;

public interface IFtyProductionLineProvider extends DubboBaseInterface<FtyProductionLine> {

    /**
     * 根据车间查询所有生产线
     *
     * @param page
     * @return
     * @throws DubboProviderException
     */
    Page getPageByAreaId(Page page) throws DubboProviderException;

    /**
     * 验证生产线下是否有工作中心
     * @param id
     * @return
     * ledengyun--2017/10/13
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
