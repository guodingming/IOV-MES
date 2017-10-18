package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpBarcode;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-条码
*/
public interface DpBarcodeMapper extends BaseInterfaceMapper<DpBarcode> {

    public List<DpBarcode> findByTypeId(String typeId);

    /**
     * 根据base_replace进行转换
     *
     * @param params
     * @return
     */
    String getBaseReplace(Map<String, Object> params);
}
