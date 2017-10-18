package configs.barcodes

import com.google.common.collect.Maps
import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.control.utils.ExtWildcardUtil
import com.mes.dubbo.interprovider.control.IPdPreCodeWildcardTbProvider
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider
import com.mes.entity.control.PdPreCodeWildcardTb
import com.mes.entity.control.PdProductInfoNumber

/**
 * 通过条码类型取条码,当该类型当前产品版本的条码不存在时，根据条码配置生成
 * Created by xiuyou.xu on 2017/10/10.
 */
// 传入productInfoId和条码类型type，类型从通配符参数中获取
String type = _wc_param;
Map<String, Object> params = Maps.newHashMap();
params.put("pdProductInfoId", pdProductInfoId);
params.put("type", type);
IPdProductInfoNumberProvider pdProductInfoNumberProvider = (IPdProductInfoNumberProvider) ServiceBeanContext.getInstance().getBean("pdProductInfoNumberProvider");
List<PdProductInfoNumber> numbers = pdProductInfoNumberProvider.findByMap(params);
if (numbers != null && !numbers.isEmpty()) {
    return numbers.get(0).getNumber();
} else {
    // 获取条码配置字符串
    IPdPreCodeWildcardTbProvider pdPreCodeWildcardTbProvider = (IPdPreCodeWildcardTbProvider) ServiceBeanContext.getInstance().getBean("pdPreCodeWildcardTbProvider");
    PdPreCodeWildcardTb pdPreCodeWildcardTb = pdPreCodeWildcardTbProvider.findById(type);
    if (pdPreCodeWildcardTb != null) {
        String wildcard = pdPreCodeWildcardTb.getWildcard();
        String number = ExtWildcardUtil.replace(wildcard, binding.variables);
        PdProductInfoNumber pdProductInfoNumber = new PdProductInfoNumber();
        pdProductInfoNumber.setType(type);
        pdProductInfoNumber.setPdProductInfoId(pdProductInfoId);
        pdProductInfoNumber.setNumber(number);
        pdProductInfoNumberProvider.save(pdProductInfoNumber);
    } else {
        return "";
    }
}