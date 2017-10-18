package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.Pd;
import com.mes.entity.control.PdLine;

import java.util.List;

/**
 * 产品管理-产品线
 */
public interface IPdLineProvider extends DubboBaseInterface<PdLine> {
    public List<Pd> findByPdLineId(String pdLineId) throws DubboProviderException;

    /**
     * 获取产品线及对应产品列表树形结构数据
     *
     * @return
     */
    List<Node> getPdLineTree() throws DubboProviderException;


    /**
     * 工作站登录页面获取产品关联信息
     * @return
     * @throws DubboProviderException
     */
    List<Node> loginPdInfo() throws DubboProviderException;

    /**
     * 工作站根据工程ID获取生产工序
     * @param workOrderId
     * @return
     * @throws DubboProviderException
     */
    List<DpProduceProcess> loginProcess(String workOrderId) throws DubboProviderException;

    /**
     * 验证分类下是否有数据
     * @param id
     * @return
     * ledengyun--2017/09/22
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException;
}
