package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProject;

/**
 * 开发平台--开发工程
 */
public interface IDpProjectProvider extends DubboBaseInterface<DpProject> {
    /**
     * 修改工程是否启用
     * @param ids
     * @param enable
     * @return
     */
    boolean updateEnable(String ids, int enable) throws DubboProviderException;

    /**
     * 修改工程是否发布
     * @param ids
     * @param release
     * @return
     */
    boolean updateRelease(String ids, int release) throws DubboProviderException;
}
