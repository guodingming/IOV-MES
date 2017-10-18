package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.*;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-工艺路径管理（Routes）
 */
public interface IDpRoutesProvider extends DubboBaseInterface<DpRoutes> {


    /**
     * 流程部署
     *
     * @return
     * @throws DubboProviderException
     */
    public boolean updateDeployWorkFlow(String ids) throws DubboProviderException;

    /**
     * 取消流程部署
     *
     * @return
     * @throws DubboProviderException
     */
    public boolean updateUnDeployWorkFlow(String ids) throws DubboProviderException;


    /**
     * 投产
     *
     * @param SN          条码
     * @param num         连版数
     * @param pdId        产品ID
     * @param workOrderId 工单ID
     * @return
     * @throws DubboProviderException
     */
    public List<PdProductInfo> startWorkFlow(String SN, int num, String pdId, String workOrderId) throws DubboProviderException;


    /**
     * 根据流程实例ID获取任务
     *
     * @param processDefinitionId 流程定义ID
     * @param map
     * @return
     * @throws DubboProviderException
     */
    public List<PdProductInfo> getNodeTaskList(String processDefinitionId, String taskName, String taskDefinitionKey, Map<String, Object> map) throws DubboProviderException;


    /**
     * 获取待办任务
     * @param pdProductInfoId   生产产品ID
     * @return
     * @throws DubboProviderException
     */
    public DpProductInfoLog getTask(String pdProductInfoId) throws DubboProviderException;


    /**
     * 扫码之后校验
     *
     * @param pdProductInfoId
     * @param userId
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    public boolean preValidate(String pdProductInfoId, String userId, String produceProcessId) throws DubboProviderException;

    /**
     * 执行
     *
     * @param pdProductInfoId   产品ID
     * @param userId            用户ID
     * @param produceProcessId  生产工序ID
     * @param isSuccess         工序执行结果
     * @return
     * @throws DubboProviderException
     */
    public boolean completeTask(String pdProductInfoId, String userId, String produceProcessId,String isSuccess) throws DubboProviderException;

    /**
     * 将当前产品判定到维修站
     *
     * @param pdProductInfoId
     * @param userId
     * @param produceProcessId
     * @return
     * @throws DubboProviderException
     */
    public boolean completeTaskToRepairStation(String pdProductInfoId, String userId, String produceProcessId) throws DubboProviderException;

    /**
     * 从维修站转到指定工序
     *
     * @param repairStationId
     * @param userId
     * @param message
     * @param dpProduceProcess
     * @return
     * @throws DubboProviderException
     */
    public boolean completeTaskToProcess(String repairStationId, String userId, String message, DpProduceProcess dpProduceProcess) throws DubboProviderException;


    /**
     * 根据开发工程id查询工艺流程基础插件和工序插件
     *
     * @param projectId
     * @return
     */
    List<Node> getRouteProcesses(String projectId) throws DubboProviderException;

    /**
     * 查询产品指定工序执行是否成功
     *
     * @param productInfoId
     * @param produceProcessId
     * @return
     */
    String getProduceProcessStatus(String productInfoId, String produceProcessId) throws DubboProviderException;

    /**
     * 校验产品是否可以做当前工序
     *
     * @param pdProductInfoId
     * @param produceProcessId
     * @return
     */
    public boolean checkProductProcess(String pdProductInfoId, String produceProcessId) throws DubboProviderException;

    /**
     * 校验是否投产
     *
     * @param number
     * @param pdWorkOrder
     * @return
     */
    public JsonViewObject checkStartWorkFlow(String number, PdWorkOrder pdWorkOrder) throws DubboProviderException;
}
