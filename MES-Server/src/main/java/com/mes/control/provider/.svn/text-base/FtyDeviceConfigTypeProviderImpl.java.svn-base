package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.FtyDeviceConfigTypeMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigTypeProvider;
import com.mes.entity.control.FtyDeviceConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FtyDeviceConfigTypeProviderImpl extends BaseProviderImpl<FtyDeviceConfigType> implements IFtyDeviceConfigTypeProvider {
    @Autowired
    @Qualifier("ftyDeviceConfigTypeMapper")
    private FtyDeviceConfigTypeMapper ftyDeviceConfigTypeMapper;

    @Override
    public FtyDeviceConfigTypeMapper getBaseInterfaceMapper() {
        return ftyDeviceConfigTypeMapper;
    }

    @Override
    public boolean deleteById(String id) throws DubboProviderException {
        if (ftyDeviceConfigTypeMapper.countUsage(id) > 0) {
            return false;
        }
        return super.deleteById(id);
    }
}
