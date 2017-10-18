package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpProcessBaseConfigMapper;
import com.mes.control.mapper.DpProcessConfigMapper;
import com.mes.dubbo.interprovider.control.IDpProcessBaseConfigProvider;
import com.mes.entity.control.DpProcessBaseConfig;
import com.mes.entity.control.DpProcessConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-工序基础配置
 */
public class DpProcessBaseConfigProviderImpl extends BaseProviderImpl<DpProcessBaseConfig> implements IDpProcessBaseConfigProvider {
    @Autowired
    @Qualifier("dpProcessBaseConfigMapper")
    private DpProcessBaseConfigMapper dpProcessBaseConfigMapper;

    @Autowired
    @Qualifier("dpProcessConfigMapper")
    private DpProcessConfigMapper dpProcessConfigMapper;

    @Override
    public DpProcessBaseConfigMapper getBaseInterfaceMapper() {
        return dpProcessBaseConfigMapper;
    }

    @Override
    public boolean saveBaseConfig(DpProcessBaseConfig config) {
        try {
            // 判断基础工序是否已配置，是则更新，否则新增
            Map<String, Object> map = Maps.newHashMap();
            map.put("processId", config.getProcessId());
            List<DpProcessBaseConfig> dpProcessBaseConfigs = super.findByMap(map);
            if (dpProcessBaseConfigs == null || dpProcessBaseConfigs.isEmpty()) {
                super.save(config);
            } else {
                dpProcessBaseConfigs.forEach(dpProcessBaseConfig -> {
                    config.setId(dpProcessBaseConfig.getId());
                    try {
                        super.update(config);
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });
            }
            List<DpProcessConfig> dpProcessConfigs = config.getExtendProperties();
            if (dpProcessConfigs != null && !dpProcessConfigs.isEmpty()) {
                dpProcessConfigs.stream().forEach(dpProcessConfig -> {
                    dpProcessConfigMapper.update(dpProcessConfig);
                });
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
