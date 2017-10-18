package com.mes.control.groovy

import com.mes.common.framework.rest.view.JsonViewObject
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.ErrorCodes
import com.mes.common.utils.IDGenerator
import com.mes.control.device.SoftwareInjectionResult2
import com.mes.control.device.TaskInfoItem
import com.mes.control.device.TestResultInfo
import com.mes.control.utils.JaxbUtil
import com.mes.dubbo.interprovider.control.IPdExecSoftinjectTbProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.dubbo.interprovider.control.IPdWorkTestDetailTbProvider
import com.mes.dubbo.interprovider.control.IPdWorkTestDeviceTbProvider
import com.mes.dubbo.interprovider.control.IPdWorkTestMainTbProvider
import com.mes.entity.control.PdExecSoftinjectTb
import com.mes.entity.control.PdProductInfoNumber
import com.mes.entity.control.PdWorkTestDetailTb
import com.mes.entity.control.PdWorkTestDeviceTb
import com.mes.entity.control.PdWorkTestMainTb

/**
 * 测试和软注结果同时保存
 *
 * Created by xiuyou.xu on 2017/9/1.
 */

JsonViewObject jsonViewObject = new JsonViewObject()

try {
    String xml1 = parameter.getRequestMap().get("taskInfo")
    String xml2 = parameter.getRequestMap().get("softwareInjectionResult")
    String xml3 = parameter.getRequestMap().get("testResult")
    String barCode = parameter.getRequestMap().get("barCode")
    String userId = parameter.getRequestMap().get("userId")

    IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider")
    PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberProvider.findByNumber(barCode)

    TaskInfoItem taskInfoItem = JaxbUtil.unmarshal(TaskInfoItem.class, xml1)
    String deviceId = taskInfoItem.getTaskInfo().getMachineId()
    TestResultInfo resultInfo = JaxbUtil.unmarshal(TestResultInfo.class, xml3)
    String produceProcessId = taskInfoItem.getTaskInfo().getProcedureId()
    IPdWorkTestMainTbProvider pdWorkTestMainTbProvider = (IPdWorkTestMainTbProvider) ServiceBeanContext.getInstance().getBean("pdWorkTestMainTbProvider")
    PdWorkTestMainTb pdWorkTestMainTb = new PdWorkTestMainTb()
    String workProcedureId = IDGenerator.getID()
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
                            pdWorkTestDeviceTb.setWorkTestId(testDeviceResult.getTdpId().getValue())
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
    SoftwareInjectionResult2 result = JaxbUtil.unmarshal(SoftwareInjectionResult2.class, xml2)
    IPdExecSoftinjectTbProvider pdExecSoftinjectTbProvider = (IPdExecSoftinjectTbProvider) ServiceBeanContext.getInstance().getBean("pdExecSoftinjectTbProvider")
    List<SoftwareInjectionResult2.ProdInfo> prodInfos = result.getProdInfos()
    if (prodInfos != null && !prodInfos.isEmpty()) {
        for (int i = 0; i < prodInfos.size(); i++) {
            SoftwareInjectionResult2.ProdInfo prodInfo = prodInfos.get(i)

            PdExecSoftinjectTb pdExecSoftinjectTb = new PdExecSoftinjectTb()
//            pdExecSoftinjectTb.setSerialId((i + 1) + "")
            pdExecSoftinjectTb.setSerialId(IDGenerator.getID())
            pdExecSoftinjectTb.setProductSerialId(barCode)
            pdExecSoftinjectTb.setAddr(prodInfo.getAddr())
            pdExecSoftinjectTb.setContent(prodInfo.getShowcontent())
            pdExecSoftinjectTb.setPreContent(prodInfo.getContent())

            pdExecSoftinjectTbProvider.save(pdExecSoftinjectTb)
        }
    }

    jsonViewObject.noErrorPack("保存成功")
} catch (Exception e) {
    e.printStackTrace()
    jsonViewObject.pack(ErrorCodes.EXCEPTION_OCCURRED, e.getMessage())
}

return jsonViewObject;