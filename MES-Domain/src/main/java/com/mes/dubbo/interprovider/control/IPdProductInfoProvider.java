package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdWorkOrder;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品明细（按工单移）
*/
public interface IPdProductInfoProvider extends DubboBaseInterface<PdProductInfo> {


    /**
     * 添加生产任务
     * @return
     * @throws DubboProviderException
     */
    public boolean addProductInfo(Map<String,Object> map) throws DubboProviderException;


    /**
     * 根据产品条码获取连板产品信息
     * @param number    产品条码
     * @param workOrder   当前工单
     * @return
     * @throws DubboProviderException
     */
    public List<PdProductInfo> getProduceInfoByNumber(String number, PdWorkOrder workOrder) throws DubboProviderException;

    /**
     * 查询指定条码是否做过指定工序
     *
     * @param number
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject checkPassProcess(String number, String produceProcessId) throws DubboProviderException;
}
