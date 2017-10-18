package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.*;
import com.mes.dubbo.interprovider.control.IDpProjectProvider;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.dubbo.interprovider.control.IPdWorkOrderProvider;
import com.mes.entity.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.script.ScriptException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-工单管理
 */
public class PdWorkOrderProviderImpl extends BaseProviderImpl<PdWorkOrder> implements IPdWorkOrderProvider {
    @Autowired
    @Qualifier("pdWorkOrderMapper")
    private PdWorkOrderMapper pdWorkOrderMapper;

    @Autowired
    @Qualifier("ftyProcessMapper")
    private FtyProcessMapper ftyProcessMapper;

    @Autowired
    @Qualifier("ftyDeviceMapper")
    private FtyDeviceMapper ftyDeviceMapper;

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

    @Autowired
    @Qualifier("dpProjectProvider")
    private IDpProjectProvider dpProjectProvider;

    @Autowired
    @Qualifier("dpRoutesProvider")
    private IDpRoutesProvider dpRoutesProvider;

    @Autowired
    @Qualifier("pdWorkOrderBatchMapper")
    private PdWorkOrderBatchMapper pdWorkOrderBatchMapper;

    @Autowired
    @Qualifier("dpBarcodeMapper")
    private DpBarcodeMapper dpBarcodeMapper;

    @Autowired
    @Qualifier("dpRoutesMapper")
    private DpRoutesMapper dpRoutesMapper;

    @Autowired
    @Qualifier("pdProductionLineInfoMapper")
    private PdProductionLineInfoMapper pdProductionLineInfoMapper;

    @Override
    public PdWorkOrderMapper getBaseInterfaceMapper() {
        return pdWorkOrderMapper;
    }

    @Override
    public boolean updateStatus(String ids, String status) throws DubboProviderException {
        if (ids != null) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                PdWorkOrder order = new PdWorkOrder();
                order.setId(id);
                if (PdWorkOrder.PdWorkOrderStatus.STATUS_START.equalsIgnoreCase(status)) {
                    order.setRealStartTime(new Date());
                    //启动工单的时候部署工艺路径
                    Map<String, Object> query = Maps.newHashMap();
                    query.put("workOrderId", id);
                    List<DpRoutes> dpRoutesList = this.dpRoutesMapper.findByMap(query);
                    if (!dpRoutesList.isEmpty()) {
                        String routesIds = "";
                        for (DpRoutes dpRoutes : dpRoutesList) {
                            routesIds = routesIds + "," + dpRoutes.getId();
                        }
                        routesIds = routesIds.substring(1);
                        this.dpRoutesProvider.updateDeployWorkFlow(routesIds);
                    }
                }
                if (PdWorkOrder.PdWorkOrderStatus.STATUS_STOP.equalsIgnoreCase(status)) {
                    order.setRealEndTime(new Date());
                }
                order.setStatus(status);
                pdWorkOrderMapper.update(order);
            }
        }
        return true;
    }


    @Override
    public String save(PdWorkOrder pdWorkOrder) throws DubboProviderException {
        String id = "";
        try {
            //保存工单号
            String workOrderNum = this.createWorkOrderNum(pdWorkOrder);
            pdWorkOrder.setWorkOrderNum(workOrderNum);
            id = super.save(pdWorkOrder);
            DpProject dpProject = dpProjectProvider.findById(pdWorkOrder.getProjectId());
            DpRoutes dpRoutes = new DpRoutes();
            dpRoutes.setPdLineId(dpProject.getPdLineId());
            dpRoutes.setPdId(dpProject.getPdId());
            dpRoutes.setProjectId(dpProject.getId());
            String wfCode = "WF" + id;
            dpRoutes.setWfCode(wfCode);
            String workfowRunXml = dpProject.getWorkflowRunXml().replace(dpProject.getWfCode(), wfCode);
            dpRoutes.setWorkflowRunXml(workfowRunXml);
            dpRoutes.setWorkflowShowJson(dpProject.getWorkflowShowJson());
            dpRoutes.setStatus("0");
            dpRoutes.setDeployId("0");
            dpRoutes.setName(dpProject.getName());
            dpRoutes.setWorkOrderId(id);
            dpRoutesProvider.save(dpRoutes);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public boolean update(PdWorkOrder pdWorkOrder) throws DubboProviderException {
        boolean flag = false;
        try {
            //保存工单号
            String workOrderNum = null;
            workOrderNum = this.createWorkOrderNum(pdWorkOrder);
            pdWorkOrder.setWorkOrderNum(workOrderNum);
//            String batchNum = this.createBatchNum(pdWorkOrder);
            flag = super.update(pdWorkOrder);
//            PdWorkOrderBatch pdWorkOrderBatch = this.pdWorkOrderBatchMapper.findByWorkOrderId(pdWorkOrder.getId());
//            pdWorkOrderBatch.setBatchNum(batchNum);
//            this.pdWorkOrderBatchMapper.update(pdWorkOrderBatch);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据函数生产工单号
     *
     * @param pdWorkOrder
     * @return
     * @throws ScriptException
     */
    private String createWorkOrderNum(PdWorkOrder pdWorkOrder) throws ScriptException {
        String workOrderNum = "";
        DpBarcode dpBarcode = dpBarcodeMapper.findById(pdWorkOrder.getWorkOrderRulesId());
        if (dpBarcode != null) {
            DpFunction dpFunction = dpFunctionMapper.findById(dpBarcode.getFunctionId());
            if (dpFunction != null) {
//            FunctionParameter parameter = new FunctionParameter();
//            FunctionParameter rtnMsg = null;
//            rtnMsg = (FunctionParameter) GroovyUtil.evalScript(dpFunction.getScript(), parameter);
//            Map<String, Object> responseMap = rtnMsg.getResponseMap();
                Map<String, Object> map = Maps.newHashMap();
                map.put("workOrder", pdWorkOrder);
                workOrderNum = (String) GroovyUtil.evalScript(dpFunction.getScript(), map);
            }
        }

        return workOrderNum;
    }

    /**
     * 根据函数生产批次号
     *
     * @param pdWorkOrder
     * @return
     * @throws ScriptException
     */
    private String createBatchNum(PdWorkOrder pdWorkOrder) throws ScriptException {
        String batchNum = "";
        DpBarcode dpBarcode = dpBarcodeMapper.findById(pdWorkOrder.getBarcodeRulesId());
        if (dpBarcode != null) {
            DpFunction dpFunction = dpFunctionMapper.findById(dpBarcode.getFunctionId());
            if (dpFunction != null) {
//            FunctionParameter parameter = new FunctionParameter();
//            FunctionParameter rtnMsg = null;
//            rtnMsg = (FunctionParameter) GroovyUtil.evalScript(dpFunction.getScript(), parameter);
//            Map<String, Object> responseMap = rtnMsg.getResponseMap();
                Map<String, Object> map = Maps.newHashMap();
                map.put("workOrder", pdWorkOrder);
                batchNum = (String) GroovyUtil.evalScript(dpFunction.getScript(), map);
            }
        }
        return batchNum;
    }

    @Override
    public List<FtyProcess> getProcesses(String pdId) throws DubboProviderException {
        return ftyProcessMapper.getProcesses(pdId);
    }

    @Override
    public List<FtyDevice> getDevices(String workOrderId) {
        return ftyDeviceMapper.getDevicesByWorkOrder(workOrderId);
    }

    @Override
    public List<User> getUsers(String workOrderId) {
        return userMapper.getUsersByWorkOrder(workOrderId);
    }

    public PdWorkOrder findByWorkOrderNum(String workOrderNum) throws DubboProviderException {
        PdWorkOrder pdWorkOrder = pdWorkOrderMapper.findByWorkOrderNum(workOrderNum);
        if (pdWorkOrder != null) {
            return pdWorkOrder;
        } else {
            log.error("工单不存在，请重新配置");
            return null;
        }
    }

    @Override
    public boolean saveProductLineStart(String workOrderId, String productLineId, String shiftId) throws DubboProviderException {
        boolean flag = false;
        try {
            PdProductionLineInfo pdProductionLineInfo = pdProductionLineInfoMapper.findById(productLineId);
            String lineId = null;
            if (pdProductionLineInfo != null) {
                lineId = pdProductionLineInfo.getProductionLineId();
            }

            PdWorkOrder workOrder = this.pdWorkOrderMapper.findById(workOrderId);
            workOrder.setProductionLineId(lineId);
            workOrder.setShiftId(shiftId);
            super.update(workOrder);
            this.updateStatus(workOrderId, PdWorkOrder.PdWorkOrderStatus.STATUS_START);
            flag = true;

            //保存批次号信息
            String batchNum = this.createBatchNum(workOrder);
            PdWorkOrderBatch pdWorkOrderBatch = new PdWorkOrderBatch();
            pdWorkOrderBatch.setId(IDGenerator.getID());
            pdWorkOrderBatch.setWorkOrderId(workOrderId);
            pdWorkOrderBatch.setBatchNum(batchNum);
            pdWorkOrderBatch.setCreateDate(new Date());
            this.pdWorkOrderBatchMapper.save(pdWorkOrderBatch);
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    public boolean check(String id)throws DubboProviderException{
        boolean flag = false;
        PdWorkOrder pdWorkOrder = pdWorkOrderMapper.findById(id);
        String status = pdWorkOrder.getStatus();
        if(status.equals("1")){
            flag = true;
        }
       return flag;
    }
}
