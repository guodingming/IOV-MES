package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.PdProductInfo;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品生产工序记录
*/
public interface IDpProductInfoLogProvider extends DubboBaseInterface<DpProductInfoLog> {

    public int getInt(String produceProcessId,String isSuccess)throws DubboProviderException;


    /**
     * 根据条码查询已经做过的工序及执行结果
     * @param number
     * @return
     * @throws DubboProviderException
     */
    public List<DpProductInfoLog> getProduceProcessInfo(String number) throws DubboProviderException;

    /**
     * 根据产品信息和工序查询生产记录
     *
     * @param productInfoList
     * @param session
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getProductInfoLog(List<PdProductInfo> productInfoList, Map<String, Object> session) throws DubboProviderException;

    /**
     * 根据产品信息和生产工序获取工序执行结果信息
     *
     * @param productInfoList
     * @param dpProduceProcess
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getProductInfoLog(List<PdProductInfo> productInfoList, DpProduceProcess dpProduceProcess) throws DubboProviderException;

}
