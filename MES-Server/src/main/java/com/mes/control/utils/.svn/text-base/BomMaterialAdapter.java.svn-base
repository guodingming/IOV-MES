package com.mes.control.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.PackageUtil;
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider;
import com.mes.dubbo.interprovider.control.IDpFunctionProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

import static com.mes.control.utils.Dictionaries.DpFunctionTypes.TYPE_GROOVY;
import static com.mes.control.utils.Dictionaries.DpFunctionTypes.TYPE_JAVA;

/**
 * bom文件解析适配器，默认解析CD4天窗600160001生产bom，其他格式bom需要调用相应的解析脚本
 *
 * Created by xiuyou.xu on 2017/7/21.
 */
public class BomMaterialAdapter implements IBomFileHandler {
    private static Logger logger = LoggerFactory.getLogger(BomMaterialAdapter.class);

    private static BomMaterialAdapter instance;

    private BomMaterialAdapter() {
    }

    public static BomMaterialAdapter getInstance() {
        if (instance == null) {
            synchronized (BomMaterialAdapter.class) {
                if (instance == null) {
                    instance = new BomMaterialAdapter();
                }
            }
        }
        return instance;
    }

    /**
     * bom文件内容处理
     *
     * @param bomId 生产bom记录id
     * @param fnId  解析bom内容的函数id，可能为空
     * @param rows  bom文件内容
     * @return
     */
    public List<PdBomMaterialAmount> handleBom(String bomId, String fnId, List<Map<String, Object>> rows) {
        // 查询bom是否关联了脚本
        if (fnId == null || fnId.isEmpty()) {
            logger.debug("使用默认方式解析bom内容");
            return handle(bomId, rows);
        } else {
            // TODO groovy脚本中的函数需要满足指定的声明格式，即：def handle(bomId, rows)，其返回值必须为List<PdBomMaterialAmount>
            // TODO 根据脚本类型使用不同的方式处理，脚本可能为groovy或jar包
            IDpFunctionProvider dpFunctionProvider = (IDpFunctionProvider) ServiceBeanContext.getInstance().getBean("dpFunctionProvider");
            try {
                DpFunction fn = dpFunctionProvider.findById(fnId);
                logger.debug("使用函数{}解析bom内容", fn.getName());
                if (TYPE_GROOVY.equalsIgnoreCase(fn.getType())) {
                    String script = fn.getScript();
                    return (List<PdBomMaterialAmount>) GroovyUtil.invokeFnInScript(script, "handle", GroovyUtil.buildMap(), bomId, rows);
                }
                if (TYPE_JAVA.equalsIgnoreCase(fn.getType()) && fn.getJarName() != null && fn.getJarName().toLowerCase().endsWith(".jar")) {
                    String path = ConfigHelper.getValue("shared.fs.dir") + fn.getFilePath();
                    List<String> list = Lists.newArrayList();
                    list.add(path);
                    Class clazz = PackageUtil.getImpl(list, "com.mes.control.utils.IBomFileHandler");
                    try {
                        IBomFileHandler handler = (IBomFileHandler) clazz.newInstance();
                        return handler.handle(bomId, rows);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } catch (DubboProviderException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 默认实现600160001的bom文件解析
     *
     * @param bomId 生产bom id
     * @param rows 已转化为List<Map>的bom文件数据（List每个元素为bom文件的一行）
     * @return
     */
    public List<PdBomMaterialAmount> handle(String bomId, List<Map<String, Object>> rows) {
        List<PdBomMaterialAmount> amounts = Lists.newArrayList();
        if (rows != null && !rows.isEmpty()) {
            // 物料类型字典
            IDpDataDictionaryProvider dpDataDictionaryProvider = (IDpDataDictionaryProvider) ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider");
            String typeKey = ConfigHelper.getValue("materialType.dic.type");
            List<DpDataDictionary> dpDataDictionaryList = Lists.newArrayList();
            try {
                dpDataDictionaryList = dpDataDictionaryProvider.findDictionaryByTypeKey(typeKey);
            } catch (DubboProviderException e) {
                e.printStackTrace();
            }
            List<DpDataDictionary> finalDpDataDictionaryList = dpDataDictionaryList;
            // 需要过滤掉表头
            rows.subList(5, rows.size()).forEach(row -> {
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
                            code = ((long) Double.parseDouble(code)) + "";
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    materials.setCode(code);
                    // 物料版本，都带前缀V，小于17位的一般内外部版本相同
                    Object vo = row.get("column2");
                    if (vo != null && vo.toString().trim().length() > 1) {
                        String v = vo.toString().trim().substring(1);
                        String iv = v;
                        String ov = v;
                        // V01.00.01.01.00.01，前6位客户版本，后6位内部版本
                        if (v.length() == 17) {
                            iv = v.substring(9);
                            ov = v.substring(0, 8);
                        }
                        materials.setInVersion(iv);
                        materials.setOutVersion(ov);
                    }
                    String name = row.get("column5") != null ? row.get("column5").toString() : "";
                    if (name.contains("|")) {
                        name = name.substring(0, name.indexOf("|"));
                    }
                    materials.setName(name);
                    // 物料类别名称
                    String tn = row.get("column3").toString().trim();
                    // 半成品(PCBA)版本号V1701，为内部版本号，外部版本号为V1700，即内部版本号最后一位改为0得到外部版本
                    if ("半成品(PCBA)".equals(tn)) {
                        if (materials.getInVersion() != null && !materials.getInVersion().isEmpty()) {
                            String iv = materials.getInVersion();
                            materials.setOutVersion(iv.substring(0, iv.length() - 1) + "0");
                        }
                    }
                    for (DpDataDictionary dpDataDictionary : finalDpDataDictionaryList) {
                        if (tn.equals(dpDataDictionary.getCnName())) {
                            materials.setType(dpDataDictionary.getValuev());
                        }
                    }
//                    materials.setType(materialTypes.get(tn));

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
            });
        }

        return amounts;
    }
}
