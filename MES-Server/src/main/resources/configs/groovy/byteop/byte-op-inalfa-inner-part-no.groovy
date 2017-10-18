package configs.groovy.byteop

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdBomAffiliatedProvider
import com.mes.dubbo.interprovider.control.IPdBomWorkProvider
import com.mes.entity.control.PdBomAffiliated
import com.mes.entity.control.PdBomWork

/**
 * Inalfa内部零件号
 * 先截取后7位的前5位，再转换为ASCII码
 *
 * Created by xiuyou.xu on 2017/9/5.
 */
Map<String, Object> ret = Maps.newHashMap()

String bomWorkId = taskInfoItem.getTaskInfo().getMaterialId()
IPdBomWorkProvider pdBomWorkProvider = (IPdBomWorkProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkProvider")
PdBomWork bomWork = pdBomWorkProvider.findById(bomWorkId)
if (bomWork != null) {
    String bomProduceId = bomWork.getBomProduceId()
    IPdBomAffiliatedProvider pdBomAffiliatedProvider = (IPdBomAffiliatedProvider) ServiceBeanContext.getInstance().getBean("pdBomAffiliatedProvider")
    // 产品零件号，为产品单项配置
    String clientNo = "pl_client_number"
    List<PdBomAffiliated> pdBomAffiliateds = pdBomAffiliatedProvider.findAffiliates(bomWork.getPdId(), clientNo, bomProduceId)
    if (pdBomAffiliateds != null && !pdBomAffiliateds.isEmpty()) {
        // 产品零件号
        String partNo = pdBomAffiliateds.get(0).getValue()
        int s = partNo.length()
        String r = partNo
        if (s > 6) {
            r = partNo.substring(s - 7, s - 2)
        }
        StringBuilder sb = new StringBuilder()
        char[] cs = r.toCharArray()
        for (char c : cs) {
            sb.append(Integer.toString((int) c, 16))
        }

        ret.put("pbstr_ByteContent", partNo)
        ret.put("pbstr_TranByteContent", sb.toString().toUpperCase())
    }
}

return ret