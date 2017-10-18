package com.mes.control.provider;
import com.mes.control.mapper.PdProductionLineInfoMapper;
import com.mes.dubbo.interprovider.control.IPdProductionLineInfoProvider;

import com.mes.entity.control.PdProductionLineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by dengyun.le on 2017/9/29.
 */
public class PdProductionLineInfoProviderImpl extends BaseProviderImpl<PdProductionLineInfo> implements IPdProductionLineInfoProvider {

    @Autowired
    @Qualifier("pdProductionLineInfoMapper")
    private PdProductionLineInfoMapper pdProductionLineInfoMapper;
    @Override
    public PdProductionLineInfoMapper getBaseInterfaceMapper() {
        return pdProductionLineInfoMapper;
    }
}
