package com.mes.control.provider;


import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdFileResourcesMapper;
import com.mes.dubbo.interprovider.control.IPdFileResourcesProvider;
import com.mes.entity.control.PdFileResources;
import com.mes.entity.control.PdMaterialResourceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;


/**
 * 资源文件管理
 */
public class PdFileResourcesProviderImpl extends BaseProviderImpl<PdFileResources> implements IPdFileResourcesProvider {
    @Autowired
    @Qualifier("pdFileResourcesMapper")
    private PdFileResourcesMapper pdFileResourcesMapper;

    @Override
    public PdFileResourcesMapper getBaseInterfaceMapper() {
        return pdFileResourcesMapper;
    }


    @Override
    public boolean saveMaterialResourceFile(PdMaterialResourceFile pdMaterialResourceFile) {
        String resourceFileId = pdMaterialResourceFile.getResourceFileId();
        pdFileResourcesMapper.deleteMaterialResourceFile(resourceFileId);
        List<String> materialIds = pdMaterialResourceFile.getMaterialIds();
        if (materialIds != null && !materialIds.isEmpty()) {
            materialIds.stream().forEach(materialId -> {
                Map<String, Object> materialResourceFile = Maps.newHashMap();
                materialResourceFile.put("materialId", materialId);
                materialResourceFile.put("resourceFileId", resourceFileId);
                pdFileResourcesMapper.saveMaterialResourceFile(materialResourceFile);
            });
        }
        return true;
    }

    @Override
    public List<String> getResourceFileMaterials(String resourceFileId) {
        return pdFileResourcesMapper.getResourceFileMaterials(resourceFileId);
    }

    @Override
    public List<String> getMaterialResourceFiles(String materialId) throws DubboProviderException {
        return pdFileResourcesMapper.getMaterialResourceFiles(materialId);
    }


}
