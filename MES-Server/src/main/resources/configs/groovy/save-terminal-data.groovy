package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.IDGenerator
import com.mes.control.device.TaskInfoItem
import com.mes.control.device.TestResultInfo
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.dubbo.interprovider.control.IPdWorkTestDetailTbProvider
import com.mes.dubbo.interprovider.control.IPdWorkTestDeviceTbProvider
import com.mes.dubbo.interprovider.control.IPdWorkTestMainTbProvider
import com.mes.entity.control.PdProductInfoNumber
import com.mes.entity.control.PdWorkTestDetailTb
import com.mes.entity.control.PdWorkTestDeviceTb
import com.mes.entity.control.PdWorkTestMainTb

/**
 * 终端测试工序产品数据保存
 *
 * Created by xiuyou.xu on 2017/9/1.
 */

JsonViewObject jsonViewObject = new JsonViewObject()

try {
    String xml1 = parameter.getRequestMap().get("taskInfo")
    String xml2 = parameter.getRequestMap().get("testResult")
    String barCode = parameter.getRequestMap().get("barCode")
    String userId = parameter.getRequestMap().get("userId")

    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml1)
    String deviceId = taskInfoItem.getTaskInfo().getMachineId()
    TestResultInfo resultInfo = JaxbUtil.unmarshal(TestResultInfo.class, xml2)
    String produceProcessId = taskInfoItem.getTaskInfo().getProcedureId()
    IPdWorkTestMainTbProvider pdWorkTestMainTbProvider = (IPdWorkTestMainTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestMainTbProvider")

    IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider")
    PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberProvider.findByNumber(barCode)

    PdWorkTestMainTb pdWorkTestMainTb = new PdWorkTestMainTb()
    String workProcedureId = IDGenerator.getID()
    // 每个产品每个工序记录的id
//    pdWorkTestMainTb.setWorkProcedureId(produceProcessId)
    pdWorkTestMainTb.setWorkProcedureId(workProcedureId)
    pdWorkTestMainTb.setProduceProcessId(produceProcessId)
    pdWorkTestMainTb.setProductInfoId(pdProductInfoNumber.getPdProductInfoId())
    pdWorkTestMainTb.setChannelNo(resultInfo.getChannel().getValue())
    pdWorkTestMainTb.setTestFlag(resultInfo.getResult().getValue())
    pdWorkTestMainTb.setOrder(pdWorkTestMainTbProvider.getOrder(produceProcessId, pdProductInfoNumber.getPdProductInfoId()))
    pdWorkTestMainTbProvider.save(pdWorkTestMainTb)

    List<TestResultInfo.ProductResultItem> productResultItems = resultInfo.getProductResultItems()
    if (productResultItems != null && !productResultItems.isEmpty()) {
        IPdWorkTestDetailTbProvider pdWorkTestDetailTbProvider = (IPdWorkTestDetailTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestDetailTbProvider")
        IPdWorkTestDeviceTbProvider pdWorkTestDeviceTbProvider = (IPdWorkTestDeviceTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestDeviceTbProvider")
        productResultItems.each { productResultItem ->
            List<TestResultInfo.TestResult> testResults = productResultItem.getTestResults()
            if (testResults != null && !testResults.isEmpty()) {
                testResults.each { testResult ->
                    TestResultInfo.TestResultResult testResultResult = testResult.getResult()
                    PdWorkTestDetailTb pdWorkTestDetailTb = new PdWorkTestDetailTb()
                    pdWorkTestDetailTb.setWorkTestId(IDGenerator.getID())
                    pdWorkTestDetailTb.setWorkProcedureId(workProcedureId)
                    pdWorkTestDetailTb.setItemId(testResultResult.getTiId().getValue())
                    pdWorkTestDetailTb.setItemData(testResultResult.getPriData().getValue())
                    pdWorkTestDetailTb.setTestResult(testResultResult.getPriResult().getValue())
                    pdWorkTestDetailTbProvider.save(pdWorkTestDetailTb)

                    TestResultInfo.TestDeviceResults testDeviceResults = testResult.getTestDeviceResults()
                    if (testDeviceResults != null && testDeviceResults.getTestDeviceResults() != null && !testDeviceResults.getTestDeviceResults().isEmpty()) {
                        testDeviceResults.getTestDeviceResults().each { testDeviceResult ->
                            PdWorkTestDeviceTb pdWorkTestDeviceTb = new PdWorkTestDeviceTb()
//                            pdWorkTestDeviceTb.setWorkTestId(testDeviceResult.getTdpId().getValue())
                            pdWorkTestDeviceTb.setWorkTestId(IDGenerator.getID())
                            pdWorkTestDeviceTb.setDeviceId(deviceId)
                            pdWorkTestDeviceTb.setDeviceData(testDeviceResult.getTdrData().getValue())
                            pdWorkTestDeviceTb.setTestResult(testDeviceResult.getTdrResult().getValue())

                            pdWorkTestDeviceTbProvider.save(pdWorkTestDeviceTb)
                        }
                    }
                }
            }
        }
    }

    jsonViewObject.noErrorPack("保存成功")
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;