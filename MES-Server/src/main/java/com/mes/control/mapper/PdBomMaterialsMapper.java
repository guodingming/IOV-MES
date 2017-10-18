package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdBomMaterials;
import com.mes.entity.control.PdBomMaterialsVersion;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 产品管理-物料清单
 */
public interface PdBomMaterialsMapper extends BaseInterfaceMapper<PdBomMaterials> {
    /**
     * 根据物料编码和工单bom id查询物料信息
     *
     * @param code
     * @param bomWorkId
     * @return
     */
    PdBomMaterials findMaterial(@Param("code") String code, @Param("bomWorkId") String bomWorkId);

    /**
     * 根据物料编码和内部版本号查询物料版本
     *
     * @param map
     * @return
     */
    PdBomMaterialsVersion findVersion(Map<String, Object> map);

    /**
     * 保存物料版本信息
     *
     * @param pdBomMaterialsVersion
     */
    void saveMaterialVersion(PdBomMaterialsVersion pdBomMaterialsVersion);

    /**
     * 更新物料版本信息
     * @param pdBomMaterialsVersion
     */
    void updateMaterialVersion(PdBomMaterialsVersion pdBomMaterialsVersion);
}
