package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext

import com.mes.common.utils.ErrorCodes
import com.mes.control.device.TaskInfoItem
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IDpRoutesProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.entity.control.PdProductInfo
import com.mes.entity.control.PdProductInfoNumber
import com.mes.entity.control.PdWorkOrder

/**
 * Created by dengyun.le on 2017/9/4.
 */
JsonViewObject jsonViewObject = new JsonViewObject();

try {
    String xml = parameter.getRequestMap().get("taskInfo")
    String productCode = parameter.getRequestMap().get("productCode")
    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml)
    String produceProcessId = taskInfoItem.getTaskInfo().getProcedureId()
    String workOrderNum = taskInfoItem.getTaskInfo().billNo
    String work_order_id = null
    String work_order_id1 = null
    boolean flag = false;
    IPdWorkOrderProvider pdWorkOrderProvider = ServiceBeanContext.instance.getBean("pdWorkOrderProvider")
    PdWorkOrder pdWorkOrder = pdWorkOrderProvider.findByWorkOrderNum(workOrderNum)
    if (pdWorkOrder != null) {
        work_order_id = pdWorkOrder.getId()
    } else {
        work_order_id = null;
    }
    // 检查当前产品是否可以做当前工序
    boolean processCheck = false;
    IPdProductInfoNumberProvider pdProductInfoNumberProvider = ServiceBeanContext.instance.getBean("pdProductInfoNumberProvider")
    PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberProvider.findByNumber(productCode)
    if (pdProductInfoNumber != null) {
        IDpRoutesProvider dpRoutesProvider = (IDpRoutesProvider) ServiceBeanContext.getInstance().getBean("dpRoutesProvider")
        processCheck = dpRoutesProvider.checkProductProcess(pdProductInfoNumber.getPdProductInfoId(), produceProcessId)
        IPdProductInfoProvider pdProductInfoProvider = ServiceBeanContext.instance.getBean("pdProductInfoProvider")
        PdProductInfo pdProductInfo = pdProductInfoProvider.findById(pdProductInfoNumber.getPdProductInfoId())
        if (pdProductInfo != null) {
            work_order_id1 = pdProductInfo.getWorkOrderId();
        } else {
            work_order_id1 = null;
        }

    }

    if (work_order_id != null && work_order_id1 != null) {
        if (work_order_id1.equals(work_order_id)) {
            flag = true;
        }
    }


    if (flag && processCheck) {
        jsonViewObject.noErrorPack(true)
    } else if (!processCheck) {
        jsonViewObject.pack(ErrorCodes.CHECK_PROCESS_FAILED, "")
    } else if(!flag) {
        jsonViewObject.pack(ErrorCodes.CHECK_CODE, "")
    }
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject