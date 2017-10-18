package com.mes.control.provider;

import com.mes.control.mapper.PdWorkTestDeviceTbMapper;
import com.mes.dubbo.interprovider.control.IPdWorkTestDeviceTbProvider;
import com.mes.entity.control.PdWorkTestDeviceTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 终端测试项设备状态
 * Created by xiuyou.xu on 2017/09/01.
 */
public class PdWorkTestDeviceTbProviderImpl extends BaseProviderImpl<PdWorkTestDeviceTb> implements IPdWorkTestDeviceTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdWorkTestDeviceTbProviderImpl.class);

    @Autowired
    @Qualifier("pdWorkTestDeviceTbMapper")
    private PdWorkTestDeviceTbMapper pdWorkTestDeviceTbMapper;

    @Override
    public PdWorkTestDeviceTbMapper getBaseInterfaceMapper() {
        return pdWorkTestDeviceTbMapper;
    }
}
