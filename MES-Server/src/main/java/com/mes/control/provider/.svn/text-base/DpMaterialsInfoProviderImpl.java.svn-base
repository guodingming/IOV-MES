package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpMaterialsInfoMapper;
import com.mes.control.mapper.PdBomMaterialsMapper;
import com.mes.dubbo.interprovider.control.IDpMaterialsInfoProvider;
import com.mes.entity.control.DpMaterialsInfo;
import com.mes.entity.control.PdBomMaterials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 开发平台-上料管理
 */
public class DpMaterialsInfoProviderImpl extends BaseProviderImpl<DpMaterialsInfo> implements IDpMaterialsInfoProvider {
    @Autowired
    @Qualifier("dpMaterialsInfoMapper")
    private DpMaterialsInfoMapper dpMaterialsInfoMapper;

    @Autowired
    @Qualifier("pdBomMaterialsMapper")
    private PdBomMaterialsMapper pdBomMaterialsMapper;

    @Override
    public DpMaterialsInfoMapper getBaseInterfaceMapper() {
        return dpMaterialsInfoMapper;
    }

    @Override
    public boolean saveUpdate(DpMaterialsInfo entity) throws DubboProviderException {
        boolean flag = true;
        try {
            List<String> materialIds = Lists.newArrayList();
            materialIds = entity.getBomMaterialsIds();
            List<String> createIds = Lists.newArrayList();
            createIds.addAll(materialIds);
            Map<String, Object> query = Maps.newHashMap();
            query.put("produceProcessId", entity.getProduceProcessId());
            List<DpMaterialsInfo> materialsInfoList = this.dpMaterialsInfoMapper.findByMap(query);
            //判断如果还没有配置物料直接新建，有则对比处理
            if (!materialsInfoList.isEmpty()) {
                List<String> dbIds = materialsInfoList.stream().map(DpMaterialsInfo::getBomMaterialsId).collect(Collectors.toList());
                List<String> deleteIds = Lists.newArrayList();
                deleteIds = dbIds;
                if (materialIds.isEmpty() && StringUtils.isNotBlank(entity.getProduceProcessId())) {
                    for (DpMaterialsInfo materialsInfo : materialsInfoList) {
                        this.dpMaterialsInfoMapper.deleteById(materialsInfo.getId());
                    }
                } else {
                    createIds.removeAll(dbIds);
                    deleteIds.removeAll(materialIds);
                    //删除移除的数据项
                    for (String deleteId : deleteIds) {
                        for (DpMaterialsInfo materialsInfo : materialsInfoList) {
                            if (materialsInfo.getBomMaterialsId().equalsIgnoreCase(deleteId)) {
                                this.dpMaterialsInfoMapper.deleteById(materialsInfo.getId());
                            }
                        }
                    }
                    //新建新增数据
                    for (String createId : createIds) {
                        PdBomMaterials bomMaterials = this.pdBomMaterialsMapper.findById(createId);
                        entity.setId(IDGenerator.getID());
                        entity.setBomMaterialsId(createId);
                        entity.setCode(bomMaterials.getCode());
                        entity.setName(bomMaterials.getName());
                        super.save(entity);
                    }
                }
            } else {
                for (String materialId : materialIds) {
                    PdBomMaterials bomMaterials = this.pdBomMaterialsMapper.findById(materialId);
                    entity.setBomMaterialsId(materialId);
                    entity.setId(IDGenerator.getID());
                    entity.setCode(bomMaterials.getCode());
                    entity.setName(bomMaterials.getName());
                    entity.setBomMaterialsId(materialId);
                    super.save(entity);
                }
            }
        }catch (Exception e){
            flag = false;
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }
}
