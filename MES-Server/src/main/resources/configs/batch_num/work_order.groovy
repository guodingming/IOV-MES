package configs.batch_num

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.common.utils.IDGenerator
import com.mes.dubbo.interprovider.control.IPdProvider
import com.mes.entity.control.Pd;

String ret = "";

String pdId = workOrder.getPdId();
IPdProvider pdProvider = (IPdProvider) ServiceBeanContext.getInstance().getBean("pdProvider");
Pd pd = pdProvider.findById(pdId);
if (pd != null) {
    ret = pd.getCode() + "-" + IDGenerator.getID();
}
return ret;