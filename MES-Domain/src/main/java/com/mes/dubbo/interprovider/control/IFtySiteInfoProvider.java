package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.FtySiteInfo;

import java.util.List;

public interface IFtySiteInfoProvider extends DubboBaseInterface<FtySiteInfo> {
    /**
     * 根据企业分页查询工厂列表
     * @param page
     * @return
     * @throws DubboProviderException
     */
    Page getPageByEnterpriseId(Page page) throws DubboProviderException;

    /**
     * 根据企业查询工厂及其下属车间树形结构数据
     * @param enterpriseId
     * @return
     */
    List<Node> getSiteAreaTree(String enterpriseId);

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
