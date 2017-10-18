package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdBomAffiliated;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-BOM-附属信息
*/
public interface PdBomAffiliatedMapper extends BaseInterfaceMapper<PdBomAffiliated> {
    /**
     * 根据产品属性key查询属性值信息
     * @param map 包含key：pdId, attrKey, bomProduceId
     * @return
     */
    List<PdBomAffiliated> getByAttrKey(Map<String, Object> map);

    public List<PdBomAffiliated>downLoad(Map<String, Object> map);
}
