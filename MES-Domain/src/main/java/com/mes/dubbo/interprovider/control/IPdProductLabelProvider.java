package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdProductLabel;

/**
 * 产品管理-产品标签
 * Created by xiuyou.xu on 2017/09/28.
 */
public interface IPdProductLabelProvider extends DubboBaseInterface<PdProductLabel> {
    Object getTemplate(String param) throws DubboProviderException;

    Object postTemplate(String param) throws DubboProviderException;
}
