package com.mes.control.provider;

import com.mes.control.mapper.DpServiceMonitorMapper;
import com.mes.dubbo.interprovider.control.IDpServiceMonitorProvider;
import com.mes.entity.control.DpServiceMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 服务调用监控
 *
 * Created by xiuyou.xu on 2017/7/4.
 */
public class DpServiceMonitorProviderImpl extends BaseProviderImpl<DpServiceMonitor> implements IDpServiceMonitorProvider {
    private static Logger logger = LoggerFactory.getLogger(DpServiceMonitorProviderImpl.class);

    @Autowired
    @Qualifier("dpServiceMonitorMapper")
    private DpServiceMonitorMapper dpServiceMonitorMapper;

    @Override
    public DpServiceMonitorMapper getBaseInterfaceMapper() {
        return dpServiceMonitorMapper;
    }
}
