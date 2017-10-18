package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.PdScheduling;

import java.util.Map;

/**
 * 产品管理-排班-人员
*/
public interface IPdSchedulingProvider extends DubboBaseInterface<PdScheduling> {

    void saveScheduling(PdScheduling pdScheduling);

    void deleteScheduling(String ids);

    Page getSchedulingPage(Page page) ;
}
