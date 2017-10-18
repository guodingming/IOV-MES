package configs.barcodes

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IFtyProductionLineProvider
import com.mes.entity.control.FtyProductionLine

/**
 * 物理线别
 * Created by xiuyou.xu on 2017/9/29.
 */
// 目前无法查询物理线别
IFtyProductionLineProvider ftyProductionLineProvider = (IFtyProductionLineProvider) ServiceBeanContext.getInstance().getBean("ftyProductionLineProvider");
FtyProductionLine ftyProductionLine = ftyProductionLineProvider.findById(productionLineId);
if(ftyProductionLine!=null) {
    return ftyProductionLine.getCode();
}
return ""