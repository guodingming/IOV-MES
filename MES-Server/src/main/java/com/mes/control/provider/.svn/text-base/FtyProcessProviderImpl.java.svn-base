package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.FtyProcessConfigTypeMapper;
import com.mes.control.mapper.FtyProcessMapper;
import com.mes.dubbo.interprovider.control.IFtyProcessProvider;
import com.mes.entity.control.FtyProcess;
import com.mes.entity.control.FtyProcessConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FtyProcessProviderImpl extends BaseProviderImpl<FtyProcess> implements IFtyProcessProvider {
    @Autowired
    @Qualifier("ftyProcessMapper")
    private FtyProcessMapper ftyProcessMapper;

    @Autowired
    @Qualifier("ftyProcessConfigTypeMapper")
    private FtyProcessConfigTypeMapper ftyProcessConfigTypeMapper;

    @Override
    public FtyProcessMapper getBaseInterfaceMapper() {
        return ftyProcessMapper;
    }

    @Override
    public String save(FtyProcess entity) throws DubboProviderException {
        String result = "";
        List<String> configTypes = entity.getConfigTypes();
        result = super.save(entity);
        if (null != configTypes) {
            for (String dictId : configTypes) {
                FtyProcessConfigType ftyProcessConfigType = new FtyProcessConfigType();
                ftyProcessConfigType.setId(IDGenerator.getID());
                ftyProcessConfigType.setProcessId(result);
                ftyProcessConfigType.setConfigTypeDictId(dictId);
                ftyProcessConfigType.setCreateDate(new Date());
                this.ftyProcessConfigTypeMapper.save(ftyProcessConfigType);
            }
        }
        return result;
    }

    @Override
    public boolean update(FtyProcess entity) throws DubboProviderException {
        boolean result = false;
        List<String> configTypes = entity.getConfigTypes();
        result = super.update(entity);
        Map<String, Object> query = Maps.newHashMap();
        query.put("processId", entity.getId());
        List<FtyProcessConfigType> ftyProcessConfigTypes = this.ftyProcessConfigTypeMapper.findByMap(query);

        List<String> dbConfigTypes = Lists.newArrayList();
        if (null != ftyProcessConfigTypes) {
            for (FtyProcessConfigType ftyProcessConfigType : ftyProcessConfigTypes) {
                dbConfigTypes.add(ftyProcessConfigType.getConfigTypeDictId());
            }
        }

        List<String> createConfigTypes = Lists.newArrayList();
        createConfigTypes.addAll(configTypes);
        List<String> deleteConfigTypes = Lists.newArrayList();
        deleteConfigTypes.addAll(dbConfigTypes);
        createConfigTypes.removeAll(dbConfigTypes);
        deleteConfigTypes.removeAll(configTypes);

        if (null != deleteConfigTypes) {
            for (FtyProcessConfigType ftyProcessConfigType : ftyProcessConfigTypes) {
                for (String dictId : deleteConfigTypes) {
                    if (ftyProcessConfigType.getConfigTypeDictId().equalsIgnoreCase(dictId)) {
                        this.ftyProcessConfigTypeMapper.deleteById(ftyProcessConfigType.getId());
                    }
                }
            }
        }

        if (null != createConfigTypes) {
            for (String dictId : createConfigTypes) {
                FtyProcessConfigType ftyProcessConfigType = new FtyProcessConfigType();
                ftyProcessConfigType.setId(IDGenerator.getID());
                ftyProcessConfigType.setProcessId(entity.getId());
                ftyProcessConfigType.setConfigTypeDictId(dictId);
                ftyProcessConfigType.setCreateDate(new Date());
                this.ftyProcessConfigTypeMapper.save(ftyProcessConfigType);
            }
        }
        return result;
    }
}
