package com.mes.groovy

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.mes.entity.control.PdBomMaterialAmount
import com.mes.entity.control.PdBomMaterialsVersion
import com.mes.entity.control.PdBomProduceAmount

/**
 * T-BOX生产bom解析
 *
 * Created by xiuyou.xu on 2017/9/29.
 */
def handle(bomId, rows) {
    List<PdBomMaterialAmount> amounts = Lists.newArrayList();
    if (rows != null && !rows.isEmpty()) {
        // 需要过滤掉表头
        rows.subList(1, rows.size()).stream().each { row ->
            PdBomMaterialAmount amount = new PdBomMaterialAmount();
            // 每行可能包含三个物料信息，即产品，组件物料和替代物料，每个在保存是需要先根据编码和版本进行判断
            PdBomMaterialsVersion product = new PdBomMaterialsVersion();
            String codeVersion = row.get("column0").toString();
            if (codeVersion.contains("-")) {
                String[] cv = codeVersion.split("\\-");
                product.setCode(cv[0]);
                product.setInVersion(cv[1]);
                product.setOutVersion(cv[1]);
            } else {
                product.setCode(codeVersion);
            }
            product.setName(row.get("column1").toString());
            Map<String, Object> productExpand = Maps.newHashMap();
            productExpand.put("client_info", row.get("column2"));
            productExpand.put("bom_item_no", row.get("column3"));
            product.setExpandMap(productExpand);
            amount.setProduct(product);

            // 组件物料
            PdBomMaterialsVersion materials = new PdBomMaterialsVersion();
            if (row.get("column4") != null && !row.get("column4").toString().trim().isEmpty()) {
                String[] cv = row.get("column4").toString().split("\\-");
                materials.setCode(cv[0]);
                materials.setInVersion(cv[1]);
                materials.setOutVersion(cv[1]);
            } else if (row.get("column10") != null && !row.get("column10").toString().trim().isEmpty()) {
                String[] cv = row.get("column10").toString().split("\\+");
                materials.setCode(cv[0]);
                materials.setInVersion(cv[1]);
                materials.setOutVersion(cv[1]);
                // 最后一个为物料名称
                materials.setName(cv[cv.length - 1]);
            }
            if (row.get("column6") != null && !row.get("column6").toString().trim().isEmpty()) {
                materials.setName(row.get("column6").toString());
            }
            Map<String, Object> materialsExpand = Maps.newHashMap();
            materialsExpand.put("description", row.get("column5") != null ? row.get("column5").toString() : "");
            materialsExpand.put("replacement_group", row.get("column7"));
            materialsExpand.put("unit", row.get("column9"));
            materialsExpand.put("design_point", row.get("column10"));
            materials.setExpandMap(materialsExpand);
            amount.setMaterials(materials);

            // 替代物料
            if (row.get("column11") != null && !row.get("column11").toString().trim().isEmpty()) {
                PdBomMaterialsVersion replacement = new PdBomMaterialsVersion();
                String[] cv = row.get("column11").toString().split("\\-");
                replacement.setCode(cv[0]);
                replacement.setInVersion(cv[1]);
                replacement.setOutVersion(cv[1]);

                if (row.get("column13") != null) {
                    replacement.setName(row.get("column13").toString());
                }
                Map<String, Object> replacementExpand = Maps.newHashMap();
                replacementExpand.put("description", row.get("column12") != null ? row.get("column12").toString() : "");
                replacement.setExpandMap(replacementExpand);

                amount.setReplacement(replacement);
            }

            // 物料用量
            PdBomProduceAmount pdBomProduceAmount = new PdBomProduceAmount();
            pdBomProduceAmount.setBomProduceId(bomId);
            pdBomProduceAmount.setAmountNum(row.get("column8") != null ? row.get("column8").toString() : "");
            amount.setAmount(pdBomProduceAmount);

            amounts.add(amount);
        };
    }

    return amounts;
}