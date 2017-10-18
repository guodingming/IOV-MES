package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.PdBomMaterialsMapper;
import com.mes.dubbo.interprovider.control.IPdBomMaterialsProvider;
import com.mes.entity.control.PdBomMaterials;
import com.mes.entity.control.PdBomMaterialsVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-物料清单
 */
public class PdBomMaterialsProviderImpl extends BaseProviderImpl<PdBomMaterials> implements IPdBomMaterialsProvider {
    @Autowired
    @Qualifier("pdBomMaterialsMapper")
    private PdBomMaterialsMapper pdBomMaterialsMapper;

    @Override
    public PdBomMaterialsMapper getBaseInterfaceMapper() {
        return pdBomMaterialsMapper;
    }

    @Override
    public String save(PdBomMaterials pdBomMaterials) throws DubboProviderException {
        if (pdBomMaterials != null && pdBomMaterials.getCode() != null && !pdBomMaterials.getCode().isEmpty()) {
            // 相同编码和版本的物料不再重新保存
            Map<String, Object> params = Maps.newHashMap();
            params.put("code", pdBomMaterials.getCode());
            List<PdBomMaterials> list = pdBomMaterialsMapper.findByMap(params);
            if (list == null || list.isEmpty()) {
                return super.save(pdBomMaterials);
            } else {
                return list.get(0).getId();
            }
        }
        return null;
    }

    @Override
    public String saveMaterialVersion(PdBomMaterialsVersion pdBomMaterialsVersion) throws DubboProviderException {
        if (pdBomMaterialsVersion != null) {
            PdBomMaterials pdBomMaterials = new PdBomMaterials();
            pdBomMaterials.setName(pdBomMaterialsVersion.getName());
            pdBomMaterials.setCode(pdBomMaterialsVersion.getCode());
            pdBomMaterials.setType(pdBomMaterialsVersion.getType());
            String materialId = save(pdBomMaterials);
            if (materialId != null) {
                pdBomMaterialsVersion.setMaterialId(materialId);
                Map<String, Object> map = Maps.newHashMap();
                // 查询版本是否存在
                map.put("code", pdBomMaterialsVersion.getCode());
                map.put("inVersion", pdBomMaterialsVersion.getInVersion());
                map.put("outVersion", pdBomMaterialsVersion.getOutVersion());
                PdBomMaterialsVersion version = pdBomMaterialsMapper.findVersion(map);
                if (version == null) {
                    String id = IDGenerator.getID();
                    pdBomMaterialsVersion.setId(id);
                    pdBomMaterialsMapper.saveMaterialVersion(pdBomMaterialsVersion);
                    return id;
                } else {
                    // 存在则更新（type可能变化）
                    pdBomMaterialsVersion.setId(version.getId());
                    pdBomMaterialsMapper.updateMaterialVersion(pdBomMaterialsVersion);
                    return version.getId();
                }
            }
        }
        return null;
    }

    @Override
    public PdBomMaterials findMaterial(String code, String bomWorkId) throws DubboProviderException {
        try {
            return pdBomMaterialsMapper.findMaterial(code, bomWorkId);
        } catch (Exception e) {
            throw new DubboProviderException(e);
        }
    }
}
