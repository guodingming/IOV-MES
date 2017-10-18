package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.PdProductInfoNumber;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品明细-产品编码
*/
public interface IPdProductInfoNumberProvider extends DubboBaseInterface<PdProductInfoNumber> {

    public PdProductInfoNumber findByNumber(String number)throws DubboProviderException;

    public  List<DpProductInfoLog> getProductInfo(String number, String produceProcessId) throws DubboProviderException;

    public Map<String, Object> getPCBAInfo(String number)throws DubboProviderException;

}
