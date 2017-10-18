package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdWorkTestMainTb;
/**
* 终端测试结果
* Created by xiuyou.xu on 2017/09/01.
*/
public interface IPdWorkTestMainTbProvider extends DubboBaseInterface<PdWorkTestMainTb> {

    /**
     * 查询当前保存的终端测试结果的执行次序
     *
     * @param produceProcessId
     * @param productInfoId
     * @return
     * @throws DubboProviderException
     */
    long getOrder(String produceProcessId, String productInfoId) throws DubboProviderException;
}
