package configs.barcodes

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdBomWorkAmountProvider

/**
 * 获取ERP编码对应的版本信息
 * Created by xiuyou.xu on 2017/10/10.
 */
IPdBomWorkAmountProvider pdBomWorkAmountProvider = (IPdBomWorkAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkAmountProvider")
// _wc_param为通配符中的参数，即ERP编码
Map<String, Object> versions = pdBomWorkAmountProvider.getVersions(bomWorkId, _wc_param)
if (versions != null && !versions.isEmpty()) {
    String inVersion = (String) versions.get("inVersion")
    String outVersion = (String) versions.get("outVersion")
    if (inVersion != null && !inVersion.isEmpty()) {
        return inVersion
    }
    if (outVersion != null && !outVersion.isEmpty()) {
        return outVersion
    }
}
return ""