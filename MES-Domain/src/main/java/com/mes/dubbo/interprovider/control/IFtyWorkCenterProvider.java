package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.FtyWorkCenter;
import com.mes.entity.control.FtyWorkstation;

import java.util.List;

public interface IFtyWorkCenterProvider extends DubboBaseInterface<FtyWorkCenter> {


    /**
     * 根据车间获取产线及其下属工作中心
     * @param areaId 车间ID
     * @return
     */
    List<Node> getAreaProductionLineTree(String areaId);

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;



}
