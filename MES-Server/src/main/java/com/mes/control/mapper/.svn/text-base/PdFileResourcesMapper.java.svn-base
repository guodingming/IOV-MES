package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdFileResources;

import java.util.List;
import java.util.Map;

/**
 * 资源文件管理
*/
public interface PdFileResourcesMapper extends BaseInterfaceMapper<PdFileResources> {
    /**
     * 关联资源文件和物料
     * @param pdMaterialResourceFile
     */
    void saveMaterialResourceFile(Map<String, Object> pdMaterialResourceFile);

    /**
     * 根据资源文件id删除与物料的关联关系
     * @param resourceFileId
     */
    void deleteMaterialResourceFile(String resourceFileId);

    /**
     * 根据资源文件id查询已关联的物料列表
     * @param resourceFileId
     * @return
     */
    List<String> getResourceFileMaterials(String resourceFileId);

    /**
     * 根据物料id查询资源文件路径列表
     *
     * @param materialId
     * @return
     */
    List<String> getMaterialResourceFiles(String materialId);
}
