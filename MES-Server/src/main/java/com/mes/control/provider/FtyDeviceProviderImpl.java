package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.FtyDeviceConfigMapper;
import com.mes.control.mapper.FtyDeviceMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceProvider;
import com.mes.entity.control.FtyDevice;
import com.mes.entity.control.FtyDeviceConfig;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FtyDeviceProviderImpl extends BaseProviderImpl<FtyDevice> implements IFtyDeviceProvider {
    @Autowired
    @Qualifier("ftyDeviceMapper")
    private FtyDeviceMapper ftyDeviceMapper;

    @Autowired
    @Qualifier("ftyDeviceConfigMapper")
    private FtyDeviceConfigMapper ftyDeviceConfigMapper;

    @Override
    public FtyDeviceMapper getBaseInterfaceMapper() {
        return ftyDeviceMapper;
    }


    @Override
    public Page getDevicePageByAreaId(Page page) throws DubboProviderException {
        Map<String, Object> params = new HashMap();
        if (page != null && page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
            params = (Map) page.getCondition();
        }
        return findByPage(page, params);
    }

    @Override
    public void saveDeviceAndConfigInfo(FtyDevice ftyDevice) {
        try {
            //保存工作站信息
            String deviceId = ftyDevice.getId();
            if (null == deviceId || deviceId.isEmpty()) {
                deviceId = IDGenerator.getID();
                ftyDevice.setId(deviceId);
            }
            this.ftyDeviceMapper.save(ftyDevice);
            //保存设备-工作站信息
            String deviceConfigTypeIds = ftyDevice.getDeviceConfigTypeIds();
            if (!StringUtils.isBlank(deviceConfigTypeIds)) {
                String[] idArray = deviceConfigTypeIds.split(",");
                for (String id : idArray) {
                    FtyDeviceConfig ftyDeviceConfig = new FtyDeviceConfig();
                    ftyDeviceConfig.setId(IDGenerator.getID());
                    ftyDeviceConfig.setDeviceConfigTypeId(id);
                    ftyDeviceConfig.setDeviceId(deviceId);
                    this.ftyDeviceConfigMapper.save(ftyDeviceConfig);
                }
            }
        } catch (Exception e) {
            log.error("FtyDeviceProvider save is error :" + e.getMessage(), e);
        }
    }

    @Override
    public void updateDeviceAndConfigInfo(FtyDevice ftyDevice) {
        try {
            //更新工作站信息
            super.update(ftyDevice);
            String deviceId = ftyDevice.getId();
            Map<String, Object> query = Maps.newHashMap();
            query.put("deviceId", deviceId);
            List<FtyDeviceConfig> dbDeviceConfigTypes = this.ftyDeviceConfigMapper.findByMap(query);
            //更新设备-工作站信息
            String configTypes = ftyDevice.getDeviceConfigTypeIds();
            if (StringUtils.isNotBlank(configTypes)) {
                List<String> ids = Arrays.asList(configTypes.split(","));
                List<String> deviceConfigTypeIds = Lists.newArrayList();
                deviceConfigTypeIds.addAll(ids);
                List<String> createIds = Lists.newArrayList();
                createIds.addAll(deviceConfigTypeIds);
                List<String> deleteIds = Lists.newArrayList();
                List<String> dbIds = dbDeviceConfigTypes
                        .stream().map(FtyDeviceConfig::getDeviceConfigTypeId)
                        .collect(Collectors.toList());
                deleteIds.addAll(dbIds);
                //得到需要新加的配置类型
                createIds.removeAll(dbIds);
                //得到移除的配置类型
                deleteIds.removeAll(deviceConfigTypeIds);

                if (!createIds.isEmpty()) {
                    createIds.stream().forEach(deviceConfigTypeId -> {
                        FtyDeviceConfig ftyDeviceConfig = new FtyDeviceConfig();
                        ftyDeviceConfig.setId(IDGenerator.getID());
                        ftyDeviceConfig.setDeviceConfigTypeId(deviceConfigTypeId);
                        ftyDeviceConfig.setDeviceId(deviceId);
                        this.ftyDeviceConfigMapper.save(ftyDeviceConfig);
                    });
                }

                if (!deleteIds.isEmpty()) {
                    for (String deleteId : deleteIds) {
                        for (FtyDeviceConfig dbDeviceConfigType : dbDeviceConfigTypes) {
                            if (dbDeviceConfigType.getDeviceConfigTypeId().equalsIgnoreCase(deleteId)) {
                                this.ftyDeviceConfigMapper.deleteById(dbDeviceConfigType.getId());
                            }
                        }
                    }
                }
            } else {
                if (!dbDeviceConfigTypes.isEmpty()) {
                    dbDeviceConfigTypes.stream().forEach(dbDeviceConfigType -> {
                        this.ftyDeviceConfigMapper.deleteById(dbDeviceConfigType.getId());
                    });
                }
            }

        } catch (Exception e) {
            log.error("FtyDeviceProvider updateDeviceAndConfigInfo is error :" + e.getMessage(), e);
        }
    }

    @Override
    public List<FtyDevice> findDeviceListByProcessId(String processId) throws DubboProviderException {
        List<FtyDevice> result = Lists.newArrayList();
        try {
            result = this.ftyDeviceMapper.findDevicesByProcess(processId);
        } catch (Exception e) {
            log.error("FtyDeviceProvider findDeviceListByProcessId is error:" + e.getMessage(), e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    public String findByIp(String ip) throws DubboProviderException {
        FtyDevice result = null;
        result = ftyDeviceMapper.findByIp(ip);
        if (result != null) {
            return result.getId();
        } else {
            return null;
        }
    }
}
