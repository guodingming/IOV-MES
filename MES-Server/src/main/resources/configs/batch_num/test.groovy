package configs.batch_num

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IFtyProductionLineProvider
import com.mes.dubbo.interprovider.control.IPdProvider
import com.mes.dubbo.interprovider.control.IPdSchedulingTypeProvider
import com.mes.entity.control.FtyProductionLine
import com.mes.entity.control.Pd
import com.mes.entity.control.PdSchedulingType

import java.text.SimpleDateFormat
/**
 * 生成批次号（传入workOrder，工单信息）
 *
 * Created by xiuyou.xu on 2017/9/29.
 */
String ret = "";

String pdId = workOrder.getPdId();
IPdProvider pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider");
Pd pd = pdProvider.findById(pdId);
if (pd != null) {
    String erpCode = pd.getCode();
    ret = erpCode + "HR" + new SimpleDateFormat("yyMMdd").format(workOrder.getPlanStartTime());
    String productionLineId = workOrder.getProductionLineId();
    IFtyProductionLineProvider ftyProductionLineProvider = (IFtyProductionLineProvider) ServiceBeanContext.getInstance().getBean("ftyProductionLineProvider");
    FtyProductionLine ftyProductionLine = ftyProductionLineProvider.findById(productionLineId);
    if (ftyProductionLine != null) {
        ret += ftyProductionLine.getCode();
    }

    String shiftId = workOrder.getShiftId();
    IPdSchedulingTypeProvider pdSchedulingTypeProvider = (IPdSchedulingTypeProvider) ServiceBeanContext.getInstance().getBean("pdSchedulingTypeProvider");
    PdSchedulingType pdSchedulingType = pdSchedulingTypeProvider.findById(shiftId);
    if (pdSchedulingType != null) {
        ret += pdSchedulingType.getCode()
    }
}

return ret;