package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdBomWorkAmountMapper;
import com.mes.dubbo.interprovider.control.IPdBomWorkAmountProvider;
import com.mes.entity.control.PdBomMaterials;
import com.mes.entity.control.PdBomWorkAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-工单BOM管理用量
 */
public class PdBomWorkAmountProviderImpl extends BaseProviderImpl<PdBomWorkAmount> implements IPdBomWorkAmountProvider {
    @Autowired
    @Qualifier("pdBomWorkAmountMapper")
    private PdBomWorkAmountMapper pdBomWorkAmountMapper;

    @Override
    public PdBomWorkAmountMapper getBaseInterfaceMapper() {
        return pdBomWorkAmountMapper;
    }

    @Override
    public List<PdBomMaterials> getBomMaterialsByType(String bomWorkId, String type) throws DubboProviderException {
        try {
            return pdBomWorkAmountMapper.getBomMaterialsByType(bomWorkId, type);
        } catch (Exception e) {
            throw new DubboProviderException(e);
        }
    }

    @Override
    public Map<String, Object> getVersions(String bomWorkId, String materialCode) throws DubboProviderException {
        return pdBomWorkAmountMapper.getVersions(bomWorkId, materialCode);
    }
}
