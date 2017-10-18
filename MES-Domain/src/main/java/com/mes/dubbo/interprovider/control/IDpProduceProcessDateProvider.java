package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.DpProduceProcessDate;
/**
* 开发平台-生产工序配置-工序执行时间
* Created by xiuyou.xu on 2017/08/30.
*/
public interface IDpProduceProcessDateProvider extends DubboBaseInterface<DpProduceProcessDate> {


    /**
     * 配置工序执行时间
     * @param produceProcessDate
     * @return
     * @throws DubboProviderException
     */
    public boolean updateConfigDateSet(DpProduceProcessDate produceProcessDate) throws DubboProviderException;

}
