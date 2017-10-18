package configs.barcodes

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IPdBomAffiliatedProvider
import com.mes.entity.control.PdBomAffiliated

/**
 * 通配函数，获取产品配置中对应的配置值
 * Created by xiuyou.xu on 2017/10/11.
 */

IPdBomAffiliatedProvider pdBomAffiliatedProvider = (IPdBomAffiliatedProvider) ServiceBeanContext.getInstance().getBean("pdBomAffiliatedProvider")
// _wc_param为通配符中的参数，即英文配置名称
List<PdBomAffiliated> pdBomAffiliateds = pdBomAffiliatedProvider.findAffiliates(pdId, _wc_param, bomProduceId)
if (pdBomAffiliateds != null && !pdBomAffiliateds.isEmpty()) {
    return pdBomAffiliateds.get(0).getValue();
}
return "";