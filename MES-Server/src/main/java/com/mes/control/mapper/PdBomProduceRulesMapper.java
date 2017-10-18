package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdBomProduceRules;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-生产BOM校验规则
 */
public interface PdBomProduceRulesMapper extends BaseInterfaceMapper<PdBomProduceRules> {
    /**
     * 根据产品分页查询bom校验规则总数
     *
     * @param map
     */
    int getCountByPd(Map<String, Object> map);

    /**
     * 根据产品分页查询bom校验规则列表
     *
     * @param map
     */
    List<PdBomProduceRules> getPageBypd(Map<String, Object> map);
}
