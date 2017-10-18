package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdProductPdLable;

/**
 * 开发平台-产品明细-产品标签
 * Created by xiuyou.xu on 2017/09/27.
 */
public interface IPdProductPdLableProvider extends DubboBaseInterface<PdProductPdLable> {

    /**
     * 根据产品明细ID查询已有产品标签数据
     *
     * @param pdProductInfoId
     * @return
     */
    public PdProductPdLable findByProductInfoId(String pdProductInfoId) throws DubboProviderException;
}
