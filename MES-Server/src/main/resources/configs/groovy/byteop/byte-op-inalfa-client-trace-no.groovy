package configs.groovy.byteop

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.entity.control.PdProductInfoNumber

/**
 * Inalfa客户TRACE_NO
 *
 * Created by xiuyou.xu on 2017/9/13.
 */
Map<String, Object> ret = Maps.newHashMap()

Map<String, Object> map = Maps.newHashMap()
map.put("number", barCode)
IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider")
List<PdProductInfoNumber> pdProductInfoNumbers = pdProductInfoNumberProvider.findByMap(map)
if (pdProductInfoNumbers != null && !pdProductInfoNumbers.isEmpty()) {
    // TODO 跟踪号对应的type需要根据实际修改
    String type = "erp_trace_no"
    String productInfoId = pdProductInfoNumbers.get(0).getPdProductInfoId()
    map.clear()
    map.put("type", type)
    map.put("pdProductInfoId", productInfoId)
    pdProductInfoNumbers = pdProductInfoNumberProvider.findByMap(map)
    if (pdProductInfoNumbers != null && !pdProductInfoNumbers.isEmpty()) {
        String number = pdProductInfoNumbers.get(0).getNumber()
        if (number.length() > 5) {
            StringBuilder sb = new StringBuilder()
            sb.append("000000")
            sb.append(number.substring(number.length() - 6, number.length()))

            ret.put("pbstr_ByteContent", number)
            ret.put("pbstr_TranByteContent", sb.toString())
        }
    }
}

return ret