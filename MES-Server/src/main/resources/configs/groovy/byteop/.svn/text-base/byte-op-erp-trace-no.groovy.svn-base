package configs.groovy.byteop

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoProvider
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider
import com.mes.dubbo.interprovider.control.ISerialRuleProvider
import com.mes.entity.control.PdProductInfo
import com.mes.entity.control.PdProductInfoNumber
import com.mes.entity.control.PdWorkOrder

/**
 * ERP_TRACE_NO
 *
 * Created by xiuyou.xu on 2017/9/5.
 */
Map<String, Object> ret = Maps.newHashMap()

String s = "0" + taskInfoItem.getTaskInfo().getProductCode()
// 查询流水号。流水号构成较复杂，1）根据工单设置流水号；2）根据产品设置流水号；3）根据多个产品设置流水号；
// 查询流水号
IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider")
Map<String, Object> map = Maps.newHashMap()
map.put("number", barCode)
List<PdProductInfoNumber> numbers = pdProductInfoNumberProvider.findByMap(map)
if (numbers != null && !numbers.isEmpty()) {
    String no = null
    String infoId = numbers.get(0).getPdProductInfoId()
    map.clear()
    map.put("type", "erp_trace_no")
    map.put("pdProductInfoId", infoId)
    numbers = pdProductInfoNumberProvider.findByMap(map)
    if (numbers == null || numbers.isEmpty()) {
        IPdProductInfoProvider pdProductInfoProvider = (IPdProductInfoProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoProvider")
        PdProductInfo info = pdProductInfoProvider.findById(infoId)
        IPdWorkOrderProvider pdWorkOrderProvider = (IPdWorkOrderProvider) ServiceBeanContext.getInstance().getBean("pdWorkOrderProvider")
        PdWorkOrder order = pdWorkOrderProvider.findById(info.getWorkOrderId())
        ISerialRuleProvider serialRuleProvider = (ISerialRuleProvider) ServiceBeanContext.getInstance().getBean("serialRuleProvider")

        String serialNo = serialRuleProvider.updateSerial(order.getWorkOrderNum())
        if (serialNo != null) {
            // 将流水号转成16进制6位字符串
            serialNo = Integer.toString(Integer.parseInt(serialNo), 16)
            if (serialNo.length() < 6) {
                int n = 6 - serialNo.length()
                for (int i = 0; i < n; i++) {
                    serialNo = "0" + serialNo
                }
            } else if (serialNo.length() > 6) {
                serialNo = serialNo.substring(serialNo.length() - 6)
            }

            // 保存生成的erp追踪号
            no = s + serialNo
            PdProductInfoNumber pdProductInfoNumber = new PdProductInfoNumber()
            pdProductInfoNumber.setNumber(no)
            pdProductInfoNumber.setPdProductInfoId(infoId)
            pdProductInfoNumber.setType("erp_trace_no")
            pdProductInfoNumberProvider.save(pdProductInfoNumber)

            ret.put("pbstr_ByteContent", taskInfoItem.getTaskInfo().getProductCode())
            ret.put("pbstr_TranByteContent", no)
        }
    } else {
        no = numbers.get(0).getNumber()

        ret.put("pbstr_ByteContent", taskInfoItem.getTaskInfo().getProductCode())
        ret.put("pbstr_TranByteContent", no)
    }
}

return ret;