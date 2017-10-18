package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceInvocation;
import com.mes.entity.control.DpServiceRequest;

/**
 * 开发平台-服务管理
 */
public interface IDpServiceProvider extends DubboBaseInterface<DpService> {
    /**
     * 服务接口调用
     *
     * @param request
     * @return
     */
    Object saveInvocation(DpServiceRequest request) throws DubboProviderException;

    /**
     * 记录服务调用结果，用于服务监控
     *
     * @param invocation
     */
    void logInvocation(DpServiceInvocation invocation) throws DubboProviderException;
}
