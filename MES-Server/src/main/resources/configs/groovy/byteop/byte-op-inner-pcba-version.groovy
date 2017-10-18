package configs.groovy.byteop

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdBomWorkAmountProvider
/**
 * 主PCBA版本
 * Created by xiuyou.xu on 2017/9/26.
 */
def to_bcd(content) {
    String[] a = content.split("\\.")
    StringBuilder sb = new StringBuilder()
    for (String s : a) {
        if (s != null && !s.isEmpty()) {
            if (s.length() == 1) {
                sb.append("0").append(s)
            } else {
                sb.append(s.substring(s.length() - 2, s.length()))
            }
        }
    }

    return sb.toString()
}

String materialId = taskInfoItem.getTaskInfo().getMaterialId()
String erpCode = prodInfo.getContent()
IPdBomWorkAmountProvider pdBomWorkAmountProvider = (IPdBomWorkAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkAmountProvider")
Map<String, Object> versions = pdBomWorkAmountProvider.getVersions(materialId, erpCode)

Map<String, Object> ret = Maps.newHashMap()
if (versions != null && !versions.isEmpty()) {
    ret.put("pbstr_ByteContent", erpCode)
    ret.put("pbstr_TranByteContent", to_bcd(versions.get("inVersion")))
}
return ret