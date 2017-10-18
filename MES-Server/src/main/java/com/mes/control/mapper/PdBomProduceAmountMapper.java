package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdBomProduceAmount;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-生产BOM管理用量
 */
public interface PdBomProduceAmountMapper extends BaseInterfaceMapper<PdBomProduceAmount> {
    /**
     * 根据生产bom id和生产bom物料用量上级id，查询下级物料编码，名称和物料用量id
     *
     * @param params，包含bomProduceId和parentId，查询第一级时parentId为0
     * @return
     */
    List<Map<String, String>> findBomMaterials(Map<String, Object> params);

    /**
     * 查询bom下物料不同版本数量相关信息列表
     *
     * @param params
     * @return
     */
    List<Map<String, Object>> getMaterialAmount(Map<String, Object> params);

    /**
     * 根据生产bom id获取物料及其版本信息
     *
     * @param bomProduceId
     * @return
     */
    List<Map<String,Object>> getMaterialVersions(String bomProduceId);
}
