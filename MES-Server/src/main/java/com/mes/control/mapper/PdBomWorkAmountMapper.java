package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdBomMaterials;
import com.mes.entity.control.PdBomWorkAmount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-工单BOM管理用量
*/
public interface PdBomWorkAmountMapper extends BaseInterfaceMapper<PdBomWorkAmount> {
    /**
     * 根据工单bom id和工单bom物料用量上级id，查询下级物料编码，名称和物料用量id
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
     * 根据类型查询bom中的物料列表
     * @param bomWorkId
     * @param type
     * @return
     */
    List<PdBomMaterials> getBomMaterialsByType(@Param("bomWorkId") String bomWorkId, @Param("type") String type);

    /**
     * 根据工单bom id和物料编码获取物料内外部版本
     *
     * @param bomWorkId
     * @param materialCode
     * @return
     */
    Map<String,Object> getVersions(@Param("bomWorkId") String bomWorkId, @Param("code") String materialCode);
}
