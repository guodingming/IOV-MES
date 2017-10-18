package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.utils.FileUtils;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.DpProduceProcessDeviceConfigMapper;
import com.mes.control.mapper.FtyDeviceConfigInfoMapper;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDeviceConfigProvider;
import com.mes.entity.control.DpProduceProcessDeviceConfig;
import com.mes.entity.control.FtyDeviceConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-设备配置信息
 */
public class DpProduceProcessDeviceConfigProviderImpl extends BaseProviderImpl<DpProduceProcessDeviceConfig> implements IDpProduceProcessDeviceConfigProvider {
    @Autowired
    @Qualifier("dpProduceProcessDeviceConfigMapper")
    private DpProduceProcessDeviceConfigMapper dpProduceProcessDeviceConfigMapper;

    @Autowired
    @Qualifier("ftyDeviceConfigInfoMapper")
    private FtyDeviceConfigInfoMapper ftyDeviceConfigInfoMapper;

    @Override
    public DpProduceProcessDeviceConfigMapper getBaseInterfaceMapper() {
        return dpProduceProcessDeviceConfigMapper;
    }

    @Override
    public Map<String, Object> saveCopyConfig(DpProduceProcessDeviceConfig produceProcessDeviceConfig) throws DubboProviderException {
        Map<String, Object> resultMap = Maps.newHashMap();
        String result = "";
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("deviceId", produceProcessDeviceConfig.getDeviceId());
            query.put("deviceConfigTypeId", produceProcessDeviceConfig.getDeviceConfigTypeId());
            query.put("deviceConfigId", produceProcessDeviceConfig.getDeviceConfigId());
            query.put("produceProcessId", produceProcessDeviceConfig.getProduceProcessId());
            List<DpProduceProcessDeviceConfig> produceProcessDeviceConfigs = this.findByMap(query);
            if (null != produceProcessDeviceConfigs && produceProcessDeviceConfigs.isEmpty()) {
                FtyDeviceConfigInfo ftyDeviceConfigInfo = this.ftyDeviceConfigInfoMapper.findById(produceProcessDeviceConfig.getDeviceConfigId());
                if (null != ftyDeviceConfigInfo) {
                    produceProcessDeviceConfig.setDataType(ftyDeviceConfigInfo.getType());
                    produceProcessDeviceConfig.setContent(ftyDeviceConfigInfo.getContent());
                    produceProcessDeviceConfig.setFileName(ftyDeviceConfigInfo.getFilename());
                    produceProcessDeviceConfig.setName(ftyDeviceConfigInfo.getName());
                    produceProcessDeviceConfig.setVersion(ftyDeviceConfigInfo.getVersion());
                    produceProcessDeviceConfig.setId(IDGenerator.getID());
                    String filePath = "";
                    String shareDir = ConfigHelper.getValue("shared.fs.dir");
                    if (produceProcessDeviceConfig.getDataType().equalsIgnoreCase("file")) {
                        String sourceFilePath = shareDir +
                                ftyDeviceConfigInfo.getFilePath() + "/" +
                                ftyDeviceConfigInfo.getFilename();
                        filePath = "/produce-process-device-config-files/" +
                                produceProcessDeviceConfig.getProduceProcessId() + "/" + produceProcessDeviceConfig.getId() + "/";
                        String targetFilePath = shareDir +
                                filePath +
                                ftyDeviceConfigInfo.getFilename();
                        boolean flag = FileUtils.copyFileTo(sourceFilePath, targetFilePath, true);
                        if (flag) {
                            produceProcessDeviceConfig.setFilePath(filePath);
                            result = super.save(produceProcessDeviceConfig);
                            resultMap.put("content", result);
                            resultMap.put("message", "配置设备信息成功");
                        } else {
                            resultMap.put("content", "");
                            resultMap.put("message", "文件拷贝失败!");
                        }
                    } else {
                        result = super.save(produceProcessDeviceConfig);
                        resultMap.put("content", result);
                        resultMap.put("message", "配置设备信息成功!");
                    }
                }
            } else {
                resultMap.put("content", "");
                resultMap.put("message", "该配置信息已存在!");
            }

        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return resultMap;
    }
}
