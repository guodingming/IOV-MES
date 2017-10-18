package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdFileResources;
import com.mes.entity.control.PdMaterialResourceFile;

import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;
import java.util.List;

/**
 * 资源文件管理
*/
public interface IPdFileResourcesProvider extends DubboBaseInterface<PdFileResources> {
    /**
     * 关联资源文件和物料
     * @param pdMaterialResourceFile
     * @return
     */
    boolean saveMaterialResourceFile(PdMaterialResourceFile pdMaterialResourceFile);

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
     * @throws DubboProviderException
     */
    List<String> getMaterialResourceFiles(String materialId) throws DubboProviderException;

}
