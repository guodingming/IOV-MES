package com.mes.control.provider;

import com.mes.control.mapper.PdExecSystemModuleCopyMapper;
import com.mes.dubbo.interprovider.control.IPdExecSystemModuleCopyProvider;
import com.mes.entity.control.PdExecSystemModuleCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * $table.description
 * Created by xiuyou.xu on 2017/09/01.
 */
public class PdExecSystemModuleCopyProviderImpl extends BaseProviderImpl<PdExecSystemModuleCopy> implements IPdExecSystemModuleCopyProvider {
    private static Logger logger = LoggerFactory.getLogger(PdExecSystemModuleCopyProviderImpl.class);

    @Autowired
    @Qualifier("pdExecSystemModuleCopyMapper")
    private PdExecSystemModuleCopyMapper pdExecSystemModuleCopyMapper;

    @Override
    public PdExecSystemModuleCopyMapper getBaseInterfaceMapper() {
        return pdExecSystemModuleCopyMapper;
    }

    @Override
    public List<Map<String, Object>> getRelationTables(String systemName) {
        return pdExecSystemModuleCopyMapper.getRelationTables(systemName);
    }
}
