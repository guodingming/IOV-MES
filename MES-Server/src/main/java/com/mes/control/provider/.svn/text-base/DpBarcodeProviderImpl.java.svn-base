package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpBarcodeMapper;
import com.mes.control.mapper.FtyProductionLineMapper;
import com.mes.control.mapper.PdWorkOrderMapper;
import com.mes.control.utils.ChipOpDictionaryUtil;
import com.mes.dubbo.interprovider.control.IDpBarcodeProvider;
import com.mes.entity.control.DpBarcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-条码
 */
public class DpBarcodeProviderImpl extends BaseProviderImpl<DpBarcode> implements IDpBarcodeProvider {
    @Autowired
    @Qualifier("dpBarcodeMapper")
    private DpBarcodeMapper dpBarcodeMapper;

    @Autowired
    @Qualifier("pdWorkOrderMapper")
    private PdWorkOrderMapper pdWorkOrderMapper;

    @Autowired
    @Qualifier("ftyProductionLineMapper")
    private FtyProductionLineMapper ftyProductionLineMapper;

    @Override
    public DpBarcodeMapper getBaseInterfaceMapper() {
        return dpBarcodeMapper;
    }

    public List<DpBarcode> findByTypeId(String typeId) throws DubboProviderException {
        List<DpBarcode> list = null;
        list = dpBarcodeMapper.findByTypeId(typeId);
        return list;
    }

    @Override
    public List<Map<String, Object>> findBarCodeTypes() throws DubboProviderException {
        List<Map<String, Object>> result = Lists.newArrayList();
        try {
            Map<String, List<Map<String, Object>>> types = ChipOpDictionaryUtil.getData();
            result = types.get("bar_code_type");
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public String getBaseReplace(String tableName, String originalValue) throws DubboProviderException {
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put("tableName", tableName);
            params.put("originalValue", originalValue);

            return dpBarcodeMapper.getBaseReplace(params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }
}
