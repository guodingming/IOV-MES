package com.mes.control.provider;

import com.mes.common.utils.IDGenerator;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.FtyDeviceConfigMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceConfigProvider;
import com.mes.entity.control.FtyDeviceConfig;
import com.mes.entity.control.FtyDeviceConfigTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class FtyDeviceConfigProviderImpl extends BaseProviderImpl<FtyDeviceConfig> implements IFtyDeviceConfigProvider {
    @Autowired
    @Qualifier("ftyDeviceConfigMapper")
    private FtyDeviceConfigMapper ftyDeviceConfigMapper;

    @Override
    public FtyDeviceConfigMapper getBaseInterfaceMapper() {
        return ftyDeviceConfigMapper;
    }

    @Override
    public boolean saveDeviceConfigTypes(FtyDeviceConfigTypes ftyDeviceConfigTypes) throws DubboProviderException {
        String deviceId = ftyDeviceConfigTypes.getDeviceId();
        deleteAll(deviceId);
        List<String> deviceConfigTypeIds = ftyDeviceConfigTypes.getDeviceConfigTypeIds();
        if (deviceConfigTypeIds != null && !deviceConfigTypeIds.isEmpty()) {
            deviceConfigTypeIds.stream().forEach(deviceConfigTypeId -> {
                FtyDeviceConfig config = new FtyDeviceConfig();
                config.setDeviceId(deviceId);
                config.setDeviceConfigTypeId(deviceConfigTypeId);
                config.setId(IDGenerator.getID());
                ftyDeviceConfigMapper.save(config);
            });
        }
        return true;
    }

    @Override
    public void deleteAll(String deviceId) throws DubboProviderException {
        ftyDeviceConfigMapper.deleteAll(deviceId);
    }
}
