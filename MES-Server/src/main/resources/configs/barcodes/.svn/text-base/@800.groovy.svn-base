package configs.barcodes

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.ISerialRuleProvider

/**
 * 4位流水号
 * Created by xiuyou.xu on 2017/10/10.
 */
ISerialRuleProvider serialRuleProvider = (ISerialRuleProvider) ServiceBeanContext.getInstance().getBean("serialRuleProvider")
String serialNo = serialRuleProvider.updateSerial(workOrderNum)
if (serialNo != null) {
    serialNo = "0000" + serialNo
    return serialNo.substring(serialNo.length() - 4)
}
return ""