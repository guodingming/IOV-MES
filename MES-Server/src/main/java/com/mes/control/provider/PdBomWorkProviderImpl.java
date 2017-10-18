package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.rest.view.Node;
import com.mes.control.mapper.PdBomWorkAmountMapper;
import com.mes.control.mapper.PdBomWorkMapper;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IPdBomWorkProvider;
import com.mes.entity.control.DpDataDictionary;
import com.mes.entity.control.PdBomWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-工单BOM管理
 */
public class PdBomWorkProviderImpl extends BaseProviderImpl<PdBomWork> implements IPdBomWorkProvider {
    @Autowired
    @Qualifier("pdBomWorkMapper")
    private PdBomWorkMapper pdBomWorkMapper;

    @Autowired
    @Qualifier("pdBomWorkAmountMapper")
    private PdBomWorkAmountMapper pdBomWorkAmountMapper;

    @Autowired
    @Qualifier("dpDataDictionaryProvider")
    private IDpDataDictionaryProvider dpDataDictionaryProvider;

    @Override
    public PdBomWorkMapper getBaseInterfaceMapper() {
        return pdBomWorkMapper;
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
            params.put("bomWorkId", bomId);
            if(!code.equals("root")){
                params.put("code", code);
            }


            list = pdBomWorkAmountMapper.getMaterialAmount(params);
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
        params.put("bomWorkId", bomId);
        params.put("parentId", parentId);
        List<Map<String, String>> list = pdBomWorkAmountMapper.findBomMaterials(params);
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
