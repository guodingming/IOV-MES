package com.mes.groovy

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.mes.common.framework.config.ConfigHelper
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider
import com.mes.entity.control.DpDataDictionary
import com.mes.entity.control.PdBomMaterialAmount
import com.mes.entity.control.PdBomMaterialsVersion
import com.mes.entity.control.PdBomProduceAmount
/**
 * Created by xiuyou.xu on 2017/8/1.
 */
def handle(bomId, rows) {
    List<PdBomMaterialAmount> amounts = Lists.newArrayList();
    if (rows != null && !rows.isEmpty()) {
        // 物料类型字典
//        Map<String, Map<String, String>> dic = ChipOpDictionaryUtil.reverseIndex()
//        Map<String, String> materialTypes = dic.get("material_type")
        String typeKey = ConfigHelper.getValue("materialType.dic.type");
        IDpDataDictionaryProvider dpDataDictionaryProvider = (IDpDataDictionaryProvider) ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider")
        List<DpDataDictionary> dpDataDictionaryList = dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
        // 需要过滤掉表头
        rows.subList(5, rows.size()).each { row ->
            String code = row.get("column1") != null ? row.get("column1").toString() : "";
            if (code != null && !code.isEmpty()) {
                PdBomMaterialAmount amount = new PdBomMaterialAmount();
                // 每行可能包含三个物料信息，即产品，组件物料和替代物料，每个在保存是需要先根据编码和版本进行判断
//            PdBomMaterialsVersion product = new PdBomMaterialsVersion();
//            String codeVersion = row.get("column2").toString();
//            if (codeVersion.contains("-")) {
//                String[] cv = codeVersion.split("\\-");
//                product.setCode(cv[0]);
//                product.setInVersion(cv[1]);
//                product.setOutVersion(cv[1]);
//            } else {
//                product.setCode(codeVersion);
//            }
//            product.setName(row.get("column3").toString());
//            Map<String, Object> productExpand = Maps.newHashMap();
//            productExpand.put("client_info", row.get("column4"));
//            productExpand.put("bom_item_no", row.get("column5"));
//            product.setExpandMap(productExpand);
//            amount.setProduct(product);

                // 组件物料
                PdBomMaterialsVersion materials = new PdBomMaterialsVersion();
                if (code.contains(".")) {
                    try {
                        code = ((long) Double.parseDouble(code)) + ""
                    } catch (Exception e) {
                        e.printStackTrace()
                    }
                }
                materials.setCode(code)
                // 物料版本，都带前缀V，小于17位的一般内外部版本相同
                Object vo = row.get("column2");
                if (vo != null && vo.toString().trim().length() > 1) {
                    String v = vo.toString().trim().substring(1)
                    String iv = v;
                    String ov = v;
                    // V01.00.01.01.00.01，前6位客户版本，后6位内部版本
                    if (v.length() == 17) {
                        iv = v.substring(9)
                        ov = v.substring(0, 8)
                    }
                    materials.setInVersion(iv);
                    materials.setOutVersion(ov);
                }
                String name = row.get("column5") != null ? row.get("column5").toString() : "";
                if (name.contains("|")) {
                    name = name.substring(0, name.indexOf("|"))
                }
                materials.setName(name)
                // 物料类别名称
                String tn = row.get("column3").toString().trim()
                // 半成品(PCBA)版本号V1701，为内部版本号，外部版本号为V1700，即内部版本号最后一位改为0得到外部版本
                if ("半成品(PCBA)".equals(tn)) {
                    if (materials.getInVersion() != null && !materials.getInVersion().isEmpty()) {
                        String iv = materials.getInVersion()
                        materials.setOutVersion(iv.substring(0, iv.length() - 1) + "0")
                    }
                }
                for (DpDataDictionary dpDataDictionary : dpDataDictionaryList) {
                    if (dpDataDictionary.cnName.equals(tn)) {
                        materials.setType(dpDataDictionary.keyk)
                    }
                }
//                materials.setType(materialTypes.get(tn))

                Map<String, Object> materialsExpand = Maps.newHashMap();
                materialsExpand.put("description", row.get("column6") != null ? row.get("column6").toString() : "");
                materialsExpand.put("unit", row.get("column9") != null ? row.get("column9").toString() : "");
                materials.setExpandMap(materialsExpand);
                amount.setMaterials(materials);

                // 替代物料
//            if (row.get("column26") != null && !row.get("column26").toString().trim().isEmpty()) {
//                PdBomMaterialsVersion replacement = new PdBomMaterialsVersion();
//                String[] cv = row.get("column26").toString().split("\\-");
//                replacement.setCode(cv[0]);
//                replacement.setInVersion(cv[1]);
//                replacement.setOutVersion(cv[1]);
//
//                if (row.get("column28") != null) {
//                    replacement.setName(row.get("column28").toString());
//                }
//                Map<String, Object> replacementExpand = Maps.newHashMap();
//                replacementExpand.put("description", row.get("column27") != null ? row.get("column27").toString() : "");
//                replacement.setExpandMap(replacementExpand);
//
//                amount.setReplacement(replacement);
//            }

                // 物料用量
                PdBomProduceAmount pdBomProduceAmount = new PdBomProduceAmount();
                pdBomProduceAmount.setBomProduceId(bomId);
                pdBomProduceAmount.setAmountNum(row.get("column7") != null ? row.get("column7").toString() : "");
                pdBomProduceAmount.setAttritionRate(row.get("column8") != null ? row.get("column8").toString() : "");
                amount.setAmount(pdBomProduceAmount);

                amounts.add(amount);
            }
        }
    }

    return amounts;
}