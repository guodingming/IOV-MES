package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.*;
import com.mes.dubbo.interprovider.control.IDpProduceProcessConfigProvider;
import com.mes.dubbo.interprovider.control.IDpProduceProcessProvider;
import com.mes.entity.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 产品管理--产品生产工序
 */
public class DpProduceProcessProviderImpl extends BaseProviderImpl<DpProduceProcess> implements IDpProduceProcessProvider {
    @Autowired
    @Qualifier("dpProduceProcessMapper")
    private DpProduceProcessMapper dpProduceProcessMapper;

    @Autowired
    @Qualifier("dpProduceProcessConfigMapper")
    private DpProduceProcessConfigMapper dpProduceProcessConfigMapper;

    @Autowired
    @Qualifier("dpProcessBaseConfigMapper")
    private DpProcessBaseConfigMapper dpProcessBaseConfigMapper;

    @Autowired
    @Qualifier("dpProcessConfigMapper")
    private DpProcessConfigMapper dpProcessConfigMapper;

    @Autowired
    @Qualifier("dpProduceProcessConfigProvider")
    private IDpProduceProcessConfigProvider dpProduceProcessConfigProvider;

    @Autowired
    @Qualifier("ftyProcessConfigTypeMapper")
    private FtyProcessConfigTypeMapper ftyProcessConfigTypeMapper;

    @Autowired
    @Qualifier("dpProjectMapper")
    private DpProjectMapper dpProjectMapper;

    @Override
    public DpProduceProcessMapper getBaseInterfaceMapper() {
        return dpProduceProcessMapper;
    }

    @Override
    public boolean updateConfig(DpProduceProcess process) throws DubboProviderException {
        try {
            super.update(process);
            List<DpProduceProcessConfig> configs = process.getExtendProperties();
            if (configs != null && !configs.isEmpty()) {
                configs.stream().forEach(config -> {
                    dpProduceProcessConfigMapper.update(config);
                });
            }
            return true;
        } catch (Exception e) {
            throw new DubboProviderException(e);
        }
    }

    @Override
    public String saveProduceProcess(DpProduceProcess process) throws DubboProviderException {
        String id = super.save(process);
        // 拷贝工序基础属性到生产工序属性配置表
        Map<String, Object> params = Maps.newHashMap();
        params.put("processId", process.getProcessId());
        List<DpProcessConfig> configs = dpProcessConfigMapper.findByMap(params);
        if (configs != null && !configs.isEmpty()) {
            configs.stream().forEach(config -> {
                DpProduceProcessConfig dpProduceProcessConfig = new DpProduceProcessConfig();
                dpProduceProcessConfig.setProduceProcessId(id);
                dpProduceProcessConfig.setDictionaryId(config.getDictionaryId());
                dpProduceProcessConfig.setDictionaryTypeId(config.getDictionaryTypeId());
                dpProduceProcessConfig.setValue(config.getValue());
                dpProduceProcessConfig.setType(config.getType());
                dpProduceProcessConfig.setDescription(config.getDescription());
                dpProduceProcessConfig.setCreateDate(new Date());
                try {
                    dpProduceProcessConfigProvider.save(dpProduceProcessConfig);
                } catch (DubboProviderException e) {
                    e.printStackTrace();
                }
            });
        }
        return id;
    }

    @Override
    public boolean saveDpProduceProcess(DpProduceProcess process) throws DubboProviderException {
        try {
            String projectId = process.getProjectId();
            Map<String, Object> params = Maps.newHashMap();
            params.put("projectId", projectId);
            List<DpProduceProcess> processes = dpProduceProcessMapper.findByMap(params);
            // 删除当前配置中不存在的工序
            if (processes != null && !processes.isEmpty()) {
                List<String> processIds = process.getProcessIds();
                processes.stream().filter(produceProcess -> {
                    return processIds != null ? !processIds.contains(produceProcess.getProcessId()) : true;
                }).forEach(produceProcess -> {
                    dpProduceProcessMapper.deleteById(produceProcess.getId());
                });
            }

            List<String> processIds = process.getProcessIds();
            if (processIds != null && !processIds.isEmpty()) {
                for (int i = 0; i < processIds.size(); i++) {
                    String processId = processIds.get(i);
                    process.setProcessId(processId);
                    process.setSort(i);
                    // update existed
                    boolean existed = false;
                    List<String> ids = Lists.newArrayList();
                    if (processes != null && !processes.isEmpty()) {
                        existed = processes.stream().anyMatch(produceProcess -> {
                            boolean b = produceProcess.getProcessId().equals(processId);
                            if (b) {
                                ids.add(produceProcess.getId());
                            }
                            return b;
                        });
                    }
                    if (existed) {
                        process.setId(ids.get(0));
                        dpProduceProcessMapper.update(process);
                    } else {
                        String formId = null;
                        String formTypeId = null;
                        String isAuto = null;
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("processId", processId);
                        List<DpProcessBaseConfig> dpProcessBaseConfigs = dpProcessBaseConfigMapper.findByMap(map);
                        if (dpProcessBaseConfigs != null && !dpProcessBaseConfigs.isEmpty()) {
                            DpProcessBaseConfig dpProcessBaseConfig = dpProcessBaseConfigs.get(0);
                            formId = dpProcessBaseConfig.getFormId();
                            formTypeId = dpProcessBaseConfig.getFormTypeId();
                            isAuto = dpProcessBaseConfig.getIsAuto();
                        }
                        try {
                            process.setIsAuto(isAuto);
                            process.setFormId(formId);
                            process.setFormTypeId(formTypeId);
                            process.setId(null);
                            process.setExecuteTime(1);
                            saveProduceProcess(process);
                        } catch (DubboProviderException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            //更新工程是否配置工序标志
            List<DpProduceProcess> dbProcess = dpProduceProcessMapper.findByMap(params);
            DpProject project = new DpProject();
            project.setId(projectId);
            if (null != dbProcess && dbProcess.size() > 0) {
                project.setIsConfigProcess("1");
                this.dpProjectMapper.update(project);
            } else {
                project.setIsConfigProcess("0");
                this.dpProjectMapper.update(project);
            }
            return true;
        } catch (Exception e) {
            throw new DubboProviderException(e);
        }
    }

    @Override
    public List<Map<String, Object>> getProduceProcesses(String pdId, String isAuto) {
        return dpProduceProcessMapper.getProduceProcesses(pdId, isAuto);
    }

    @Override
    public boolean updateSort(String maxSortId, String minSortId) throws DubboProviderException {
        boolean flag = true;
        try {
            DpProduceProcess maxProduceProcess = this.dpProduceProcessMapper.findById(maxSortId);
            int maxSort = maxProduceProcess.getSort();
            DpProduceProcess minProduceProcess = this.dpProduceProcessMapper.findById(minSortId);
            int minSort = minProduceProcess.getSort();
            maxProduceProcess.setSort(minSort);
            maxProduceProcess.setUpdateDate(new Date());
            this.dpProduceProcessMapper.update(maxProduceProcess);
            minProduceProcess.setSort(maxSort);
            minProduceProcess.setUpdateDate(new Date());
            this.dpProduceProcessMapper.update(minProduceProcess);
        } catch (Exception e) {
            flag = false;
            throw new DubboProviderException(e);
        }
        return flag;
    }

    @Override
    public List<DpProduceProcess> findByMap(Map<String, Object> map) throws DubboProviderException {
        List<DpProduceProcess> result = super.findByMap(map);
        if (null != result) {
            Map<String, Object> query = Maps.newHashMap();
            for (DpProduceProcess produceProcess : result) {
                query.put("processId", produceProcess.getProcessId());
                List<FtyProcessConfigType> ftyProcessConfigTypes = this.ftyProcessConfigTypeMapper.findByMap(query);
                List<String> configType = Lists.newArrayList();
                for (FtyProcessConfigType ftyProcessConfigType : ftyProcessConfigTypes) {
                    configType.add(ftyProcessConfigType.getName());
                }
                produceProcess.setConfigType(configType);
            }
        }
        return result;
    }

}
