package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.DpServiceType;

import java.util.List;

/**
 * 开发平台-服务分类
*/
public interface IDpServiceTypeProvider extends DubboBaseInterface<DpServiceType> {
    /*
     获取所有接口下的service信息
     */
    List<Node> findServiceTreeByServiceId();

    /**
     * 验证分类下是否有数据--删除时用
     * @param id
     * @return
     * lednegyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;

}
