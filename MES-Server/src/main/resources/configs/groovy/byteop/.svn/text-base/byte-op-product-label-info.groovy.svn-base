package configs.groovy.byteop

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdBomWorkProvider
import com.mes.entity.control.PdBomWork
/**
 * 产品标签信息
 *
 * Created by xiuyou.xu on 2017/9/13.
 */
/**
 * A-Z转化为01-26
 * @param c
 * @return
 */
def getVersion(char c) {
    int i = ((int) c) - 64
    return i > 9 ? i + "" : "0" + i
}

/**
 * A转换为1，B转换为2
 * @param c
 */
def getLine(char c) {
    int i = ((int) c) - 64;
    return i + ""
}

/**
 * 获取当前是一年的第几天，前面加上年份最后一位
 */
def getDayOfYear() {
    Calendar calendar = Calendar.getInstance()
    String year = calendar.get(Calendar.YEAR) + ""
    String dayOfYear = calendar.get(Calendar.DAY_OF_YEAR) + ""
    int i = 3 - dayOfYear.length()
    if (i > 0) {
        for (int j = 0; j < i; j++) {
            dayOfYear = "0" + dayOfYear
        }
    }
    return year.charAt(year.length() - 1) + dayOfYear;
}

Map<String, Object> ret = Maps.newHashMap()

String bomWorkId = taskInfoItem.getTaskInfo().getMaterialId()
IPdBomWorkProvider pdBomWorkProvider = (IPdBomWorkProvider) ServiceBeanContext.getInstance().getBean("pdBomWorkProvider")
PdBomWork bomWork = pdBomWorkProvider.findById(bomWorkId)
//if (bomWork != null) {
//    String bomProduceId = bomWork.getBomProduceId()
//    IPdBomAffiliatedProvider pdBomAffiliatedProvider = (IPdBomAffiliatedProvider) ServiceBeanContext.getInstance().getBean("pdBomAffiliatedProvider")
//    // 产品零件号，为产品单项配置
//    String clientNo = "pl_client_number"
//    List<PdBomAffiliated> pdBomAffiliateds = pdBomAffiliatedProvider.findAffiliates(bomWork.getPdId(), clientNo, bomProduceId)
//    if (pdBomAffiliateds != null && !pdBomAffiliateds.isEmpty()) {
//        // 产品零件号
//        String partNo = pdBomAffiliateds.get(0).getValue()
//
//        StringBuilder sb = new StringBuilder()
////        sb.append(partNo.substring(4, 8))
//        sb.append(getVersion(partNo.charAt(8)))
//        // 6位批次
//        sb.append("")
//        // 4位流水
//        sb.append("")
//
//        ret.put("pbstr_ByteContent", prodInfo.getContent())
//        ret.put("pbstr_TranByteContent", sb.toString())
//    }
//}
ret.put("pbstr_ByteContent", prodInfo.getContent())
ret.put("pbstr_TranByteContent", "021143110018")

return ret