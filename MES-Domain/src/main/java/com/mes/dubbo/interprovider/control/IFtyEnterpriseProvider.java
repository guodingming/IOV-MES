package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.FtyEnterprise;

import java.util.List;

public interface IFtyEnterpriseProvider extends DubboBaseInterface<FtyEnterprise> {

    /**
     * 企业-工厂-车间，树数据查询
     * @return
     */
    List<Node> getTree();

    /**
     * 查询仪表盘树
     *
     * @return
     */
    List<Node> getDashboardTree() throws DubboProviderException;

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
