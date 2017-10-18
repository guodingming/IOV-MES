package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceProcessConfig;

/**
 * 开发平台-生产工序配置属性
*/
public interface IDpProduceProcessConfigProvider extends DubboBaseInterface<DpProduceProcessConfig> {
    /**
     * 根据配置字典项key和生产工序id查询配置信息
     * @param dicKey
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    DpProduceProcessConfig getConfig(String dicKey, String produceProcessId) throws DubboProviderException;
}
