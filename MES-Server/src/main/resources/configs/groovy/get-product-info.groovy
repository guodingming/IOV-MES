package com.mes.control.groovy

import com.google.common.collect.Maps
import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.function.BaseCall
import com.mes.common.function.FunctionParameter
import com.mes.common.utils.ErrorCodes
import com.mes.dubbo.interprovider.control.IDpProduceProcessProvider
import com.mes.dubbo.interprovider.control.IFtyProcessProvider
import com.mes.dubbo.interprovider.control.IPdLineProvider
import com.mes.dubbo.interprovider.control.IPdProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.entity.control.*

/**
 * 获取产品线、产品、生产工序信息
 *
 * Created by xiuyou.xu on 2017/8/29.
 */

JsonViewObject jsonViewObject = new JsonViewObject();

def buildProduct(StringBuilder sb, PdLine line) {
    IPdProvider pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider")
    Map<String, Object> map = Maps.newHashMap()
    map.put("pdLineId", line.getId())
    List<Pd> pds = pdProvider.findByMap(map)
    if (pds != null && !pds.isEmpty()) {
        pds.stream().each { pd ->
            sb.append("<proudct>").append("<proudct_name>").append(pd.getName()).append("</proudct_name>")
            buildWorkOrder(sb, pd)
            sb.append("</proudct>")
        }
    }
}

def buildWorkOrder(StringBuilder sb, Pd pd) {
    IPdWorkOrderProvider pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider")
    Map<String, Object> map = Maps.newHashMap()
    map.put("pdId", pd.getId())
    List<PdWorkOrder> pdWorkOrders = pdWorkOrderProvider.findByMap(map)
    if (pdWorkOrders != null && !pdWorkOrders.isEmpty()) {
        pdWorkOrders.stream().each { pdWorkOrder ->
            sb.append("<work_order>").append("<order>").append(pdWorkOrder.getWorkOrderNum()).append("</order>")
            buildProcedure(sb, pdWorkOrder)
            sb.append("</work_order>")
        }
    }
}

def buildProcedure(StringBuilder sb, PdWorkOrder pdWorkOrder) {
    IFtyProcessProvider ftyProcessProvider = (IFtyProcessProvider) ServiceBeanContext.getInstance().getBean("ftyProcessProvider")
    IDpProduceProcessProvider dpProduceProcessProvider = (IDpProduceProcessProvider) ServiceBeanContext.getInstance().getBean("dpProduceProcessProvider")
    Map<String, Object> map = Maps.newHashMap()
    map.put("projectId", pdWorkOrder.getProjectId())
    List<DpProduceProcess> dpProduceProcesses = dpProduceProcessProvider.findByMap(map)
    if (dpProduceProcesses != null && !dpProduceProcesses.isEmpty()) {
        dpProduceProcesses.stream().each { dpProduceProcess ->
            FtyProcess ftyProcess = ftyProcessProvider.findById(dpProduceProcess.getProcessId())
            sb.append("<procedure>").append("<procedure_name>").append(ftyProcess.getName()).append("</procedure_name>")
                    .append("<procedure_id>").append(dpProduceProcess.getId()).append("</procedure_id>").append("</procedure>")
        }
    }
}

def service = [
        actionCall: { FunctionParameter parameter ->
//            String areaId = parameter.getRequestMap().get("areaId");
            IPdLineProvider pdLineProvider = (IPdLineProvider) ServiceBeanContext.getInstance().getBean("pdLineProvider")
//            Map<String, Object> map = Maps.newHashMap()
//            map.put("areaId", areaId)
//            List<PdLine> pdLines = pdLineProvider.findByMap(map)
            List<PdLine> pdLines = pdLineProvider.findAll()
            if (pdLines != null && !pdLines.isEmpty()) {
                StringBuilder sb = new StringBuilder()
                sb.append("<item>")
                pdLines.stream().each { line ->
                    sb.append("<product_line>").append("<line_name>").append(line.getName()).append("</line_name>")
                    buildProduct(sb, line)
                    sb.append("</product_line>")
                }
                sb.append("</item>")

                Map<String, Object> res = Maps.newHashMap()
                res.put("content", sb.toString())
                parameter.setResponseMap(res)
            }
            return parameter
        }] as BaseCall

try {
    param = service.actionCall(parameter)
    if (param.getResponseMap() == null || param.getResponseMap().isEmpty()) {
        jsonViewObject.pack(ErrorCodes.NO_RELATION_TABLES, "")
    } else {
        jsonViewObject.noErrorPack(param.getResponseMap().get("content"))
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;