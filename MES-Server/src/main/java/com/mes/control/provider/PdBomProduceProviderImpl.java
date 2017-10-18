package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.ExcelHandler;
import com.mes.common.utils.FileUtils;
import com.mes.control.mapper.PdBomProduceAmountMapper;
import com.mes.control.mapper.PdBomProduceMapper;
import com.mes.control.mapper.PdMapper;
import com.mes.control.utils.BomMaterialAdapter;
import com.mes.dubbo.interprovider.control.*;
import com.mes.entity.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-生产BOM管理
 */
public class PdBomProduceProviderImpl extends BaseProviderImpl<PdBomProduce> implements IPdBomProduceProvider {
    @Autowired
    @Qualifier("pdBomProduceMapper")
    private PdBomProduceMapper pdBomProduceMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Autowired
    @Qualifier("pdBomMaterialsProvider")
    private IPdBomMaterialsProvider pdBomMaterialsProvider;

    @Autowired
    @Qualifier("pdBomWorkProvider")
    private IPdBomWorkProvider pdBomWorkProvider;

    @Autowired
    @Qualifier("pdBomWorkAmountProvider")
    private IPdBomWorkAmountProvider pdBomWorkAmountProvider;

    @Autowired
    @Qualifier("pdBomMaterialsReplaceProvider")
    private IPdBomMaterialsReplaceProvider pdBomMaterialsReplaceProvider;

    @Autowired
    @Qualifier("pdBomProduceAmountMapper")
    private PdBomProduceAmountMapper pdBomProduceAmountMapper;

    @Autowired
    @Qualifier("pdBomProduceAmountProvider")
    private IPdBomProduceAmountProvider pdBomProduceAmountProvider;

    @Autowired
    @Qualifier("dpDataDictionaryProvider")
    private IDpDataDictionaryProvider dpDataDictionaryProvider;

    @Override
    public PdBomProduceMapper getBaseInterfaceMapper() {
        return pdBomProduceMapper;
    }

    @Override
    public String save(PdBomProduce pdBomProduce) throws DubboProviderException {
        try {
            Pd pd = pdMapper.findById(pdBomProduce.getPdId());
            String name = pdBomProduce.getCode();
            if (pd != null) {
                pdBomProduce.setPdName(pd.getName());
                name += "|" + pd.getName();
            }
            pdBomProduce.setName(name);
            String id = super.save(pdBomProduce);
            // 保存到工单bom
            PdBomWork pdBomWork = new PdBomWork();
            pdBomWork.setCode(pdBomProduce.getCode());
            pdBomWork.setVersion(pdBomProduce.getVersion());
            pdBomWork.setPdId(pdBomProduce.getPdId());
            pdBomWork.setPdName(pdBomProduce.getPdName());
            pdBomWork.setBomProduceId(id);
            pdBomWork.setName(name);
            String workBomId = pdBomWorkProvider.save(pdBomWork);

            File bomFile = new File(ConfigHelper.getValue("shared.fs.dir") + pdBomProduce.getFilePath());

            List<Map<String, Object>> rows = ExcelHandler.read(FileUtils.getExt(bomFile), 0, new FileInputStream(bomFile));
            // TODO 提供灵活的方式解析bom excel文件每一行数据，得到每行对应的物料和物料用量等信息
            List<PdBomMaterialAmount> materialAmounts = BomMaterialAdapter.getInstance().handleBom(id, pdBomProduce.getFnId(), rows);
            if (materialAmounts != null && !materialAmounts.isEmpty()) {
                materialAmounts.stream().forEach(materialAmount -> {
                    try {
                        String productVersionId = pdBomMaterialsProvider.saveMaterialVersion(materialAmount.getProduct());
                        String materialVersionId = pdBomMaterialsProvider.saveMaterialVersion(materialAmount.getMaterials());
                        String replacementVersionId = pdBomMaterialsProvider.saveMaterialVersion(materialAmount.getReplacement());

                        materialAmount.getAmount().setMaterialsVersionId(materialVersionId);
                        String productParentId = getProductParentId(id, productVersionId);
                        materialAmount.getAmount().setParentId(productParentId);
                        pdBomProduceAmountProvider.save(materialAmount.getAmount());

                        PdBomWorkAmount pdBomWorkAmount = new PdBomWorkAmount();
                        String workParentId = getWorkParentId(workBomId, productVersionId);
                        pdBomWorkAmount.setParentId(workParentId);
                        pdBomWorkAmount.setAmountNum(materialAmount.getAmount().getAmountNum());
                        pdBomWorkAmount.setAttritionRate(materialAmount.getAmount().getAttritionRate());
                        if (materialAmount.getReplacement() != null) {
                            pdBomWorkAmount.setIsReplace("1");
                        }
                        pdBomWorkAmount.setMaterialsVersionId(materialVersionId);
                        pdBomWorkAmount.setBomWorkId(workBomId);
                        String pdBomWorkAmountId = pdBomWorkAmountProvider.save(pdBomWorkAmount);

                        // 保存替换料信息
                        if (materialAmount.getReplacement() != null) {
                            PdBomMaterialsReplace replace = new PdBomMaterialsReplace();
                            replace.setBomMaterialsId(replacementVersionId);
                            replace.setBomWorkAmountId(pdBomWorkAmountId);
                            pdBomMaterialsReplaceProvider.save(replace);
                        }
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                });
            }

            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }

    /**
     * 查询工单bom用量父id
     *
     * @param id
     * @param materialsVersionId
     * @return
     */
    private String getWorkParentId(String id, String materialsVersionId) throws DubboProviderException {
        if (materialsVersionId != null && !materialsVersionId.isEmpty()) {
            Map<String, Object> params = Maps.newHashMap();
            params.put("materialsVersionId", materialsVersionId);
            params.put("bomWorkId", id);
            List<PdBomWorkAmount> amounts = pdBomWorkAmountProvider.findByMap(params);
            if (amounts != null && !amounts.isEmpty()) {
                return amounts.get(0).getId();
            }
        }
        return "0";
    }

    /**
     * 查询生产bom用量父id
     *
     * @param id
     * @param materialsVersionId
     * @return
     * @throws DubboProviderException
     */
    private String getProductParentId(String id, String materialsVersionId) throws DubboProviderException {
        if (materialsVersionId != null && !materialsVersionId.isEmpty()) {
            Map<String, Object> params = Maps.newHashMap();
            params.put("materialsVersionId", materialsVersionId);
            params.put("bomProduceId", id);
            List<PdBomProduceAmount> amounts = pdBomProduceAmountProvider.findByMap(params);
            if (amounts != null && !amounts.isEmpty()) {
                return amounts.get(0).getId();
            }
        }
        return "0";
    }

    @Override
    public List<Node> getMaterialTree(String bomId) {
        List<Node> nodes = buildTree(bomId, "0");
        return nodes;
    }

    @Override
    public List<Map<String, Object>> getMaterialAmount(String bomId, String code) throws DubboProviderException {
        List<Map<String, Object>> list = Lists.newArrayList();
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put("bomProduceId", bomId);
            if (code.equals("root")) {
                params.put("code", null);
            } else {
                params.put("code", code);
            }
            list = pdBomProduceAmountMapper.getMaterialAmount(params);
            if (list != null && !list.isEmpty()) {
                String typeKey = ConfigHelper.getValue("materialType.dic.type");
                List<DpDataDictionary> dpDataDictionaryList = this.dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
                for (Map<String, Object> map : list) {
                    for (DpDataDictionary dpDataDictionary : dpDataDictionaryList) {
                        if (null != map.get("type")) {
                            String type = map.get("type").toString();
                            if (type != null && type.equals(dpDataDictionary.getValuev())) {
                                map.put("type", dpDataDictionary.getCnName());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return list;
    }

    private List<Node> buildTree(String bomId, String parentId) {
        List<Node> nodes = Lists.newArrayList();

        Map<String, Object> params = Maps.newHashMap();
        params.put("bomProduceId", bomId);
        params.put("parentId", parentId);
        List<Map<String, String>> list = pdBomProduceAmountMapper.findBomMaterials(params);
        if (list != null && !list.isEmpty()) {
            list.stream().forEach(map -> {
                Node node = new Node();
                node.setId(map.get("code"));
                node.setName(map.get("code") + "|" + map.get("name"));
                node.setChildren(buildTree(bomId, map.get("id")));

                nodes.add(node);
            });
        }

        return nodes;
    }
}
