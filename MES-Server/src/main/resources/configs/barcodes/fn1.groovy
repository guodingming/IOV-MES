package configs.barcodes

import com.mes.common.framework.spring.ServiceBeanContext
import com.mes.dubbo.interprovider.control.IDpBarcodeProvider

/**
 * 按表替换，查询mes_pd_base_replace_tb
 *
 * Created by xiuyou.xu on 2017/10/10.
 */
IDpBarcodeProvider dpBarcodeProvider = (IDpBarcodeProvider) ServiceBeanContext.getInstance().getBean("dpBarcodeProvider");
return dpBarcodeProvider.getBaseReplace(param, value)
