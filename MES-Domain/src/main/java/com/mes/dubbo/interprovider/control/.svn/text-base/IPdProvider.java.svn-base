package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.Pd;
import com.mes.entity.control.PdproductionLineInfoList;

import java.util.List;

/**
 * 产品管理-产品
*/
public interface IPdProvider extends DubboBaseInterface<Pd> {

    /**
     * 新建产品保存
     * @param pdproductionLineInfoList
     * @return
     * ledengyun--2017/09/29
     * @throws DubboProviderException
     */
    public String savePd(PdproductionLineInfoList pdproductionLineInfoList)throws DubboProviderException;

    /**
     * 根据产品线获取工程树数据
     * @param pdLineId
     * @return
     * @throws DubboProviderException
     */
    public List<Node> getProjectTree(String pdLineId) throws DubboProviderException;
}
