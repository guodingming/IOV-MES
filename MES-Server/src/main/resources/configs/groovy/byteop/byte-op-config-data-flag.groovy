package configs.groovy.byteop

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdBomWorkAmountProvider

/**
 * 配置数据标志擦除后状态
 * Created by xiuyou.xu on 2017/9/26.
 */
def removeFlag(content) {
    StringBuilder sb = new StringBuilder()
    if (content != null) {
        String[] a = content.split("\\.")
        for (String s : a) {
            if (s != null && !s.isEmpty()) {
                if (!s.isEmpty()) {
                    if (s.length() == 1) {
                        s = "0" + s;
                    }
                    if (s.length() > 2) {
                        s = s.substring(s.length() - 2)
                    }
                    sb.append(s)
                }
            }
        }
    }
    String s = sb.toString()
    if (s.length() > 3) {
        return "FF" + s.substring(s.length() - 4)
    }
    return ""
}


Map<String, Object> ret = Maps.newHashMap()

String bomWorkId = taskInfoItem.getTaskInfo().getMaterialId()
String erpCode = prodInfo.getContent()

IPdBomWorkAmountProvider pdBomWorkAmountProvider = (IPdBomWorkAmountProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkAmountProvider")
Map<String, Object> versions = pdBomWorkAmountProvider.getVersions(bomWorkId, erpCode)
if (versions != null && !versions.isEmpty()) {
    ret.put("pbstr_ByteContent", versions.get("outVersion"))
    ret.put("pbstr_TranByteContent", removeFlag(versions.get("outVersion")))
}
return ret