package com.mes.control.groovy

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.mes.common.framework.config.ConfigHelper
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IDpDataDictionaryProvider
import com.mes.dubbo.interprovider.control.IDpProduceChipProvider
import com.mes.entity.control.DpDataDictionary

/**
 * 获取芯片操作列表XML
 * Created by xiuyou.xu on 2017/8/30.
 */

def getValue(dic, cnName) {
    for (DpDataDictionary dataDictionary : dic) {
        if (dataDictionary.cnName.equals(cnName)) {
            return dataDictionary.valuev
        }
    }
    return ""
}

JsonViewObject jsonViewObject = new JsonViewObject();

try {
    String xml = parameter.getRequestMap().get("taskInfo");
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
    String produceProcessId = taskInfoItem.getTaskInfo().getProcedureId()
    String taskMode = taskInfoItem.getTaskInfo().getTaskMode()
    IDpProduceChipProvider dpProduceChipProvider = (IDpProduceChipProvider) ServiceBeanContext.getInstance().getBean("dpProduceChipProvider")
    List<Map<String, Object>> resultData = dpProduceChipProvider.getDownload(produceProcessId)
    IDpDataDictionaryProvider dpDataDictionaryProvider = ServiceBeanContext.getInstance().getBean("dpDataDictionaryProvider");
    String task_mode_key = ConfigHelper.getValue("taskMode.dic.type");
    List<DpDataDictionary> taskModeDic = dpDataDictionaryProvider.findDictionaryByTypeKey(task_mode_key);
    String operate_code_key = ConfigHelper.getValue("operateCode.dic.type");
    List<DpDataDictionary> operateCodeDic = dpDataDictionaryProvider.findDictionaryByTypeKey(operate_code_key);
    String source_code_key = ConfigHelper.getValue("source.dic.type");
    List<DpDataDictionary> sourceCodeDic = dpDataDictionaryProvider.findDictionaryByTypeKey(source_code_key);
    String store_type_key = ConfigHelper.getValue("store.dic.type");
    List<DpDataDictionary> storeTypeDic = dpDataDictionaryProvider.findDictionaryByTypeKey(store_type_key);
    String programmer_type_key = ConfigHelper.getValue("programmer.dic.type");
    List<DpDataDictionary> programmerTypeDic = dpDataDictionaryProvider.findDictionaryByTypeKey(programmer_type_key);
    if (resultData != null && resultData.size() > 1) {
//        Map<String, Map<String, String>> dic = ChipOpDictionaryUtil.reverseIndex();
        List<Map<String, Object>> rows = Lists.newArrayList();
        String taskModeType = ConfigHelper.getValue("taskMode.type");
        if (taskModeType != null && taskModeType.equals(taskMode.toString())) {
            for (int i = 1; i < resultData.size(); i++) {
                Map<String, Object> row = resultData.get(i)
                if (row.get("column10").equals("调试模式")) {
                    rows.add(row)
                }
            }
        } else {
            for (int i = 1; i < resultData.size(); i++) {
                Map<String, Object> row = resultData.get(i)
                if (row.get("column10").equals("正常模式")) {
                    rows.add(row)
                }
            }
        }
        StringBuilder sb = new StringBuilder()
        sb.append("<NewDataSet>")
        for (int i = 0; i < rows.size(); i++) {
            Map<String, Object> row = rows.get(i)
            sb.append("<item>")
            sb.append("<serial_id>").append(row.get("column1")).append("</serial_id>")
            sb.append("<addr>").append(row.get("column2")).append("</addr>")
            sb.append("<byte_num>").append(row.get("column3")).append("</byte_num>")
            sb.append("<chip_sequence>").append(row.get("column8")).append("</chip_sequence>")
            sb.append("<oper_describe>").append(row.get("column12")).append("</oper_describe>")
            // 需要转换
            sb.append("<content>").append(row.get("column5")).append("</content>")
            // 需要转换
            sb.append("<oper_code>").append(getValue(operateCodeDic, row.get("column7"))).append("</oper_code>")
            // 需要转换
            sb.append("<programmer_type>").append(getValue(programmerTypeDic, row.get("column9"))).append("</programmer_type>")
            // 需要转换
            sb.append("<source_type>").append(getValue(sourceCodeDic, row.get("column4"))).append("</source_type>")
            sb.append("<source_describe>").append(row.get("column12")).append("</source_describe>")
            sb.append("<delay_time>").append(row.get("column11")).append("</delay_time>")
            // 需要转换
            sb.append("<store_type>").append(getValue(storeTypeDic, row.get("column6"))).append("</store_type>")
            // 需要转换
            sb.append("<model>").append(row.get("column10")).append("</model>")
            sb.append("<procedure_id>").append(produceProcessId).append("</procedure_id>")

            sb.append("</item>")
        }
        sb.append("</NewDataSet>")

        jsonViewObject.noErrorPack(sb.toString())
    } else {
        if (resultData == null) {
            jsonViewObject.pack(ErrorCodes.NO_CHIP_OPS, "")
        } else if (resultData.size() == 1) {
            jsonViewObject.pack(ErrorCodes.EMPTY_CHIP_OPS, "")
        }
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;