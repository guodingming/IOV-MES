package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.DpMaterialsAssemble;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.PdWorkOrder;

import java.util.List;
import java.util.Map;

/**
* 开发平台-上料管理-组装
* Created by xiuyou.xu on 2017/09/13.
*/
public interface IDpMaterialsAssembleProvider extends DubboBaseInterface<DpMaterialsAssemble> {


    /**
     * 组装
     *
     * @param number
     * @param materialIds
     * @param session
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject updateOperation(String number, String materialIds, Map<String, Object> session, boolean isRework) throws DubboProviderException;

    /**
     * 查询组装信息
     *
     * @param productInfoId
     * @param produceProcess
     * @param workOrder
     * @return
     * @throws DubboProviderException
     */
    public List<DpMaterialsAssemble> findMaterialsAssemble(String productInfoId, DpProduceProcess produceProcess, PdWorkOrder workOrder) throws DubboProviderException;


    /**
     * 重工
     *
     * @param number
     * @param materialIds
     * @param session
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject updateRepeat(String number, String materialIds, Map<String, Object> session) throws DubboProviderException;

    /**
     * 检查是否已经组装
     *
     * @param number
     * @param session
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject checkIsAssemble(String number, Map<String, Object> session) throws DubboProviderException;

    /**
     * 获取当前工单当前工序所上物料
     *
     * @param workOrder
     * @param produceProcess
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getMaterialsInfo(PdWorkOrder workOrder, DpProduceProcess produceProcess) throws DubboProviderException;
}
