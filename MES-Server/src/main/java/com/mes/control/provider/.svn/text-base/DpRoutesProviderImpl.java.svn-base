package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.Exception.WorkFlowException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.function.FunctionConstants;
import com.mes.common.function.FunctionParameter;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.*;
import com.mes.control.utils.Dictionaries;
import com.mes.control.utils.ExtWildcardUtil;
import com.mes.control.utils.RouteBasePluginUtil;
import com.mes.control.utils.WorkFlowAdapter;
import com.mes.control.workflow.FunctionRoute;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.entity.control.*;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 开发平台-工艺路径管理（Routes）
 */
public class DpRoutesProviderImpl extends BaseProviderImpl<DpRoutes> implements IDpRoutesProvider {

    private static Logger log = Logger.getLogger(DpRoutesProviderImpl.class);
    @Autowired
    @Qualifier("dpRoutesMapper")
    private DpRoutesMapper dpRoutesMapper;

    @Autowired
    @Qualifier("dpProjectMapper")
    private DpProjectMapper dpProjectMapper;

    @Autowired
    @Qualifier("pdWorkOrderMapper")
    private PdWorkOrderMapper pdWorkOrderMapper;

    @Autowired
    @Qualifier("pdWorkOrderBatchMapper")
    private PdWorkOrderBatchMapper pdWorkOrderBatchMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("dpProductInfoLogMapper")
    private DpProductInfoLogMapper dpProductInfoLogMapper;

    @Autowired
    @Qualifier("dpProduceProcessMapper")
    private DpProduceProcessMapper dpProduceProcessMapper;

    @Autowired
    @Qualifier("ftyProcessMapper")
    private FtyProcessMapper ftyProcessMapper;

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

    @Autowired
    @Qualifier("dpRepairStationMapper")
    private DpRepairStationMapper dpRepairStationMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Autowired
    @Qualifier("dpProduceProcessDateMapper")
    private DpProduceProcessDateMapper dpProduceProcessDateMapper;

    @Autowired
    @Qualifier("dpBarcodeMapper")
    private DpBarcodeMapper dpBarcodeMapper;

    @Autowired
    @Qualifier("pdProductBarCodeMapper")
    private PdProductBarCodeMapper pdProductBarCodeMapper;

    @Override
    public DpRoutesMapper getBaseInterfaceMapper() {
        return dpRoutesMapper;
    }

    /**
     * 流程部署
     *
     * @param ids
     * @return
     * @throws DubboProviderException
     */
    @Override
    public boolean updateDeployWorkFlow(String ids) throws DubboProviderException {
        boolean flag = false;
        try {
            String[] idList = ids.split(",");
            for (String id : idList) {
                DpRoutes dpRoutes = dpRoutesMapper.findById(id);
                //部署流程
                String wfXml = dpRoutes.getWorkflowRunXml();
                String wfName = dpRoutes.getName();
                String wfCode = dpRoutes.getWfCode();
                String deployId = WorkFlowAdapter.getInstance().deployWorkFlow(wfXml, wfName, wfCode);
                if (StringUtils.isNotBlank(deployId)) {
                    dpRoutes.setDeployId(deployId);
                    //流程已经部署
                    dpRoutes.setStatus("1");
                    this.dpRoutesMapper.update(dpRoutes);
                    log.info("流程部署成功！");
                    flag = true;
                } else {
                    log.info("流程部署失败！");
                }
            }


        } catch (Exception e) {
            log.error("流程部署失败！", e);
        }
        return flag;
    }

    /**
     * 取消流程部署
     *
     * @param ids
     * @return
     * @throws DubboProviderException
     */
    @Override
    public boolean updateUnDeployWorkFlow(String ids) throws DubboProviderException {
        boolean flag = false;
        try {
            String[] idList = ids.split(",");
            for (String id : idList) {
                DpRoutes dpRoutes = dpRoutesMapper.findById(id);
                //流程取消部署
                WorkFlowAdapter.getInstance().unDeployWorkFlowByCode(dpRoutes.getWfCode());
                dpRoutes.setDeployId("0");
                dpRoutes.setStatus("0");
                this.dpRoutesMapper.update(dpRoutes);
            }
            log.info("取消流程部署成功！");
            flag = true;
        } catch (Exception e) {
            log.error("取消流程部署失败！", e);
        }
        return flag;
    }

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
    @Override
    public List<PdProductInfo> startWorkFlow(String SN, int num, String pdId, String workOrderId) throws DubboProviderException {
        List<PdProductInfo> result = Lists.newArrayList();
        try {
            if (!this.checkSNExist(SN, num)) {
                //流程code
                DpRoutes dpRoutes = this.getWfCode(workOrderId);
                if (num > 0) {
                    for (int i = 0; i < num; i++) {
//                        String sn = SN.substring(0, SN.length() - 2) + (Integer.valueOf(SN.substring(SN.length() - 2, SN.length())) + i) + "";
                        int index = Integer.valueOf(SN.substring(SN.length() - 2, SN.length())) + i;
                        String sn = SN.substring(0, SN.length() - 2) + (index > 9 ? index : "0" + index) + "";
                        String barcodeTypeId;
                        String barcode;
                        PdWorkOrder workOrder = this.pdWorkOrderMapper.findById(workOrderId);
                        //产品信息
                        PdProductInfo pdProductInfo = new PdProductInfo();
                        Pd pd = this.pdMapper.findById(pdId);
                        String id = IDGenerator.getID();
                        pdProductInfo.setId(id);
                        pdProductInfo.setPdNum(id);
                        pdProductInfo.setPdId(pdId);
                        pdProductInfo.setPdLineId(pd.getPdLineId());
                        pdProductInfo.setPdName(pd.getName());
                        pdProductInfo.setWorkOrderId(workOrderId);
                        pdProductInfo.setWorkOrderNum(workOrder.getWorkOrderNum());
                        //批次号
                        PdWorkOrderBatch pdWorkOrderBatch = pdWorkOrderBatchMapper.findByWorkOrderId(workOrderId);
                        String workOrderBatchNum = pdWorkOrderBatch.getBatchNum();
                        pdProductInfo.setWorkOrderBatchNum(workOrderBatchNum);
                        pdProductInfo.setSoftVersion(null);
                        pdProductInfo.setHardVersion(null);
                        Map<String, Object> map = Maps.newHashMap();
                        String instanceId = WorkFlowAdapter.getInstance().startWorkFlow(dpRoutes.getWfCode(), map);
                        pdProductInfo.setInstanceId(instanceId);
                        pdProductInfo.setPdLineId(dpRoutes.getPdLineId());
                        //0：未完成，正在生产；1：已完成
                        pdProductInfo.setStatus("0");
                        pdProductInfo.setCreateDate(new Date());
                        pdProductInfoMapper.save(pdProductInfo);
                        //产品条码
                        PdProductInfoNumber pdProductInfoNumber = new PdProductInfoNumber();
                        pdProductInfoNumber.setId(IDGenerator.getID());
                        pdProductInfoNumber.setPdProductInfoId(id);
                        pdProductInfoNumber.setType("SN");
                        pdProductInfoNumber.setNumber(sn + "");
                        pdProductInfoNumber.setCreateDate(new Date());
                        pdProductInfoNumberMapper.save(pdProductInfoNumber);
                        log.info("SN：【" + SN + "】,批次号：【" + workOrderBatchNum + "】，添加生产任务成功！");
                        result.add(pdProductInfo);

                        Map<String, Object> params = ExtWildcardUtil.getBarcodeGenInfo(workOrder, workOrderBatchNum, id);
                        map.clear();
                        map.put("pdId", pdId);
                        List<PdProductBarCode> pdProductBarCodes = pdProductBarCodeMapper.findByMap(map);
                        if (pdProductBarCodes != null && !pdProductBarCodes.isEmpty()) {
                            pdProductBarCodes.forEach(pdProductBarCode -> {
                                DpBarcode dpBarcode = dpBarcodeMapper.findById(pdProductBarCode.getBarCodeId());
                                if (dpBarcode != null) {
                                    String number = null;
                                    String generation = dpBarcode.getGeneration();
                                    // 根据指令生成
                                    if ("2".equalsIgnoreCase(generation)) {
                                        String wildcard = dpBarcode.getTemplateOrder();
                                        try {
                                            number = ExtWildcardUtil.replace(wildcard, params);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        // 根据函数生成
                                        DpFunction dpFunction = dpFunctionMapper.findById(dpBarcode.getFunctionId());
                                        if (dpFunction != null) {
                                            try {
                                                number = (String) GroovyUtil.evalScript(dpFunction.getScript(), params);
                                            } catch (ScriptException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }

                                    if (number != null) {
                                        // 保存条码
                                        PdProductInfoNumber productInfoNumber = new PdProductInfoNumber();
                                        productInfoNumber.setId(IDGenerator.getID());
                                        productInfoNumber.setNumber(number);
                                        productInfoNumber.setPdProductInfoId(id);
                                        productInfoNumber.setType(dpBarcode.getCode());
                                        productInfoNumber.setCreateDate(new Date());
                                        pdProductInfoNumberMapper.save(productInfoNumber);
                                    }
                                }
                            });
                        }
                    }

                }
            }

        } catch (Exception e) {
            log.error("添加生产任务失败！", e);
        }
        return result;
    }

    /**
     * 校验该SN是否已经投产
     *
     * @param sn  PCBA号
     * @param num 连板数
     * @return
     */
    private boolean checkSNExist(String sn, int num) {
        boolean flag = false;
        for (int i = 0; i < num; i++) {
            int index = Integer.valueOf(sn.substring(sn.length() - 2, sn.length())) + i;
            String number = sn.substring(0, sn.length() - 2) + (index > 9 ? index : "0" + index) + "";
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            if (productInfoNumber != null) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 获取当前需要生产的产品
     *
     * @param processDefinitionId 流程定义ID
     * @param taskName            工序名称
     * @param taskDefinitionKey   工序编码
     * @param map
     * @return
     * @throws DubboProviderException
     */
    @Override
    public List<PdProductInfo> getNodeTaskList(String processDefinitionId, String taskName, String taskDefinitionKey, Map<String, Object> map) throws DubboProviderException {
        List<PdProductInfo> listPdProductInfo = Lists.newArrayList();
        try {
            List<Task> list = WorkFlowAdapter.getInstance().getNodeTaskList(processDefinitionId, taskName, taskDefinitionKey);
            for (Task task : list) {
                //流程实例ID
                String processInstanceId = task.getProcessInstanceId();
                PdProductInfo pdProductInfo = getPdProductInfoByProcessInstanceId(processInstanceId);
                listPdProductInfo.add(pdProductInfo);
            }
        } catch (Exception e) {
            log.error("获取当前工序需要生产的产品失败！", e);
        }
        return listPdProductInfo;
    }

    /**
     * 获取待办任务
     *
     * @param pdProductInfoId 生产产品ID
     * @return
     * @throws DubboProviderException
     */
    @Override
    public DpProductInfoLog getTask(String pdProductInfoId) throws DubboProviderException {
        DpProductInfoLog productInfoLog = new DpProductInfoLog();
        try {
            PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(pdProductInfoId);
            //流程实例ID
            String instanceId = pdProductInfo.getInstanceId();
            Task task = WorkFlowAdapter.getInstance().findWorkFlowTaskByProcessInstanceId(instanceId);
            if (task != null) {

                //获取生产工序ID 流程XML   Assignee  存储是生产工序ID
                DpProduceProcess dpProduceProcess = this.dpProduceProcessMapper.findById(task.getAssignee());
                //工序 Id
                FtyProcess process = ftyProcessMapper.findById(dpProduceProcess.getProcessId());
                //生产工序
                productInfoLog.setProduceProcessId(dpProduceProcess.getId());
                productInfoLog.setProcessCode(process.getCode());
                productInfoLog.setProcessName(process.getName());
                //工单ID
                productInfoLog.setWorkOrderId(pdProductInfo.getWorkOrderId());
                productInfoLog.setTask(task);
            }
        } catch (WorkFlowException e) {
            log.error("获取待办任务失败！", e);
        }
        return productInfoLog;
    }

    @Override
    public boolean checkProductProcess(String pdProductInfoId, String produceProcessId) {
        boolean flag = false;
        try {
            DpProductInfoLog productInfoLog = new DpProductInfoLog();
            PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(pdProductInfoId);
            //流程实例ID
            String instanceId = pdProductInfo.getInstanceId();
            Task task = WorkFlowAdapter.getInstance().findWorkFlowTaskByProcessInstanceId(instanceId);
            if (task != null) {
                //获取生产工序ID 流程XML   Assignee  存储是生产工序ID
                DpProduceProcess dpProduceProcess = this.dpProduceProcessMapper.findById(task.getAssignee());
                if (dpProduceProcess.getId().equals(produceProcessId)) {
                    flag = true;
                }
            } else {
                log.info("该产品无正在进行的任务信息!");
            }
        } catch (WorkFlowException e) {
            log.error("校验产品当前工序失败！", e);
        }
        return flag;
    }

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    /**
     * 流程步骤调用，
     */
    private static class WorkflowCallable implements Callable<FunctionParameter> {
        private String jarPath;
        private FunctionParameter parameter;

        public WorkflowCallable(String jarPath, FunctionParameter parameter) {
            this.jarPath = jarPath;
            this.parameter = parameter;
        }

        @Override
        public FunctionParameter call() throws Exception {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            if (jarPath != null && !jarPath.isEmpty()) {
                URL[] urls = new URL[3];
                urls[0] = new File(ConfigHelper.getValue("shared.fs.dir") + jarPath).toURI().toURL();
                classLoader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
            }
            return FunctionRoute.onReceive(parameter, classLoader);
        }
    }


    @Override
    public boolean preValidate(String pdProductInfoId, String userId, String produceProcessId) throws DubboProviderException {
        try {
            DpProduceProcess dpProduceProcess = this.dpProduceProcessMapper.findById(produceProcessId);
            //检查是否校验上道工序 是则校验上道工序
            String isValidate = dpProduceProcess.getIsValidateLastProcess();
            if (StringUtils.isNotBlank(isValidate) && isValidate.equals("1")) {
                //校验上道工序是否成功
                boolean validateResult = this.lastProcessValidate(pdProductInfoId, dpProduceProcess);
                if (!validateResult) {
                    return false;
                }
            }
            //是否有自定义校验函数
            String isCustomValidate = dpProduceProcess.getIsCustomCheck();
            if (StringUtils.isNotBlank(isCustomValidate) && isCustomValidate.equals("1")) {
                //执行自定义校验函数 函数必须返回true false
                boolean validateFlag = this.customValidate(pdProductInfoId, userId, dpProduceProcess);
                if (!validateFlag) {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return true;
    }

    /**
     * 执行
     *
     * @param pdProductInfoId  产品ID
     * @param userId           用户ID
     * @param produceProcessId 生产工序ID
     * @return
     * @throws DubboProviderException
     */
    @Override
    public boolean completeTask(String pdProductInfoId, String userId, String produceProcessId, String isSuccess) throws DubboProviderException {
        boolean flag = false;
        try {
            //获取当前产品制定工序任务信息
            DpProductInfoLog dpProductInfoLog = this.getTask(pdProductInfoId);
            if (dpProductInfoLog != null) {
                //校验是否应该执行当前工序任务
                if (produceProcessId.equals(dpProductInfoLog.getProduceProcessId())) {
                    Task task = dpProductInfoLog.getTask();
                    //流程参数
                    Date startTime = new Date();
                    PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(pdProductInfoId);
                    DpProduceProcess dpProduceProcess = this.dpProduceProcessMapper.findById(produceProcessId);
                    String customFnId = dpProduceProcess.getCustomFnId();
                    //工序 Id
                    FtyProcess process = ftyProcessMapper.findById(dpProduceProcess.getProcessId());
                    //检查是否校验上道工序 是则校验上道工序
                    String isValidate = dpProduceProcess.getIsValidateLastProcess();
                    if (StringUtils.isNotBlank(isValidate) && isValidate.equals("1")) {
                        //执行时间校验
                        DpProduceProcessDate dpProduceProcessDate = this.dpProduceProcessDateMapper.findByProduceProcess(produceProcessId);
                        if (null != dpProduceProcessDate) {
                            boolean validateFlag = this.validateDate(pdProductInfoId, dpProduceProcessDate, dpProduceProcess);
                            if (!validateFlag) {
                                return false;
                            }
                        }
                    }
                    //是否有自定义校验函数
                    String isCustomValidate = dpProduceProcess.getIsCustomCheck();
                    if (StringUtils.isNotBlank(isCustomValidate) && isCustomValidate.equals("1")) {
                        //执行自定义校验函数 函数必须返回true false
                        boolean validateFlag = this.customValidate(pdProductInfoId, userId, dpProduceProcess);
                        if (!validateFlag) {
                            return false;
                        }
                    }
                    Map<String, Object> variables = WorkFlowAdapter.getInstance().getVariables(task.getId());
                    if (variables == null) {
                        variables = Maps.newHashMap();
                    }
                    if (customFnId != null && !customFnId.isEmpty()) {
                        DpFunction dpFunction = dpFunctionMapper.findById(customFnId);
                        //工序自定义函数执行
                        if (dpFunction != null) {
                            Map<String, Object> map = Maps.newHashMap();
                            map.put(FunctionConstants.parameter.PD_PRODUCTINFO_ID, pdProductInfoId);
                            map.put(FunctionConstants.parameter.USER_ID, userId);
                            map.put(FunctionConstants.parameter.PRODUCE_PROCESS_ID, produceProcessId);
                            map.put(FunctionConstants.parameter.CLASS, dpFunction.getClazz());   //当前生产工序配置的函数

                            FunctionParameter parameter = new FunctionParameter();
                            parameter.setRequestMap(map);
                            //成功:1  失败:0
                            parameter.setStatus(isSuccess);

                            FunctionParameter rtnMsg = null;

                            //Groovy类型函数执行
                            if (Dictionaries.DpFunctionTypes.TYPE_GROOVY.equals(dpFunction.getType())) {
                                rtnMsg = (FunctionParameter) GroovyUtil.evalScript(dpFunction.getScript(), parameter);
                            }
                            //Java类型函数执行
                            if (Dictionaries.DpFunctionTypes.TYPE_JAVA.equals(dpFunction.getType())) {
                                Future<FunctionParameter> future = pool.submit(new WorkflowCallable(dpFunction.getFilePath(), parameter));
                                rtnMsg = future.get();
                            }
                            //成功  失败
                            isSuccess = rtnMsg.getStatus();
                            Map<String, Object> responseMap = rtnMsg.getResponseMap();
                            //流程过站参数
                            String message = (String) responseMap.get("message");
                            if (StringUtils.isNotBlank(message)) {
                                variables.put("message", message);
                            }
                        } else {
                            //流程过站参数
                            if (StringUtils.isNotBlank(isSuccess) && "1".equalsIgnoreCase(isSuccess)) {
                                variables.put("message", "Y");
                            } else {
                                variables.put("message", "N");
                            }
                        }
                    } else {
                        //流程过站参数
                        if (StringUtils.isNotBlank(isSuccess) && "1".equalsIgnoreCase(isSuccess)) {
                            variables.put("message", "Y");
                        } else {
                            variables.put("message", "N");
                        }
                    }
                    //保存生产明细
                    this.saveDpProductInfoLog(pdProductInfo, produceProcessId, isSuccess, userId, startTime);
                    if ("0".equals(isSuccess)) {
                        //保存维修站
                        this.saveRepairStation(pdProductInfo, process, produceProcessId, userId);
                    } else {
                        pdProductInfo.setStatus("1");
                    }
                    this.pdProductInfoMapper.update(pdProductInfo);
                    WorkFlowAdapter.getInstance().completeTaskByTaskId(task, variables);
                    log.info("工序名称：【" + process.getName() + "】执行完成！");
                    log.info("工序名称：【" + process.getName() + "】->> 工序编码：【" + process.getCode() + "】-->> 状态：【成功】！");
                    flag = true;

                } else {
                    log.info("该产品未做到该工序");
                }
            }
        } catch (Exception e) {
            log.error("产品过站异常", e);
            throw new DubboProviderException(e);
        }
        return flag;
    }

    @Override
    public JsonViewObject checkStartWorkFlow(String number, PdWorkOrder workOrder) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            if (productInfoNumber != null) {
                PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(productInfoNumber.getPdProductInfoId());
                if (pdProductInfo != null && !pdProductInfo.getWorkOrderId().equals(workOrder.getId())) {
                    return jsonView.successPack(false, "条码对应物料不属于当前工单");
                }
                return jsonView.successPack(true, "条码对应物料已投产");
            }
            jsonView.failPack(true, "条码对应物料未投产,可以继续操作");
        } catch (Exception e) {
            jsonView.failPack(false, "服务器异常");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public boolean completeTaskToRepairStation(String pdProductInfoId, String userId, String produceProcessId) throws DubboProviderException {
        boolean flag = false;
        PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(pdProductInfoId);
        DpProduceProcess dpProduceProcess = this.dpProduceProcessMapper.findById(produceProcessId);
        FtyProcess process = ftyProcessMapper.findById(dpProduceProcess.getProcessId());
        try {
            Task task = WorkFlowAdapter.getInstance().findWorkFlowTaskByProcessInstanceId(pdProductInfo.getInstanceId());
            if (task != null) {
                Map<String, Object> variables = WorkFlowAdapter.getInstance().getVariables(task.getId());
                if (variables == null) {
                    variables = Maps.newHashMap();
                }
                variables.put("message", "N");
                //数据进入维修站
                this.saveRepairStation(pdProductInfo, process, produceProcessId, userId);
                WorkFlowAdapter.getInstance().completeTaskByTaskId(task, variables);
                flag = true;
                if (dpProduceProcess.getProcessCode().equals(ConfigHelper.getValue("first.process.code"))) {
                    //第一道工序不良 更改产品状态为未投产
                    pdProductInfo.setStatus(PdProductInfo.Status.STATUS_NO_PRODUCTION);
                } else {
                    //其他工序 更改当前产品状态为维修站
                    pdProductInfo.setStatus(PdProductInfo.Status.STATUS_ON_REPAIRSTATION);
                }
                this.pdProductInfoMapper.update(pdProductInfo);
            }
        } catch (Exception e) {
            log.error("", e);
            throw new DubboProviderException(e);
        }
        return flag;
    }

    @Override
    public boolean completeTaskToProcess(String repairStationId, String userId, String message, DpProduceProcess dpProduceProcess) throws DubboProviderException {
        boolean flag = false;
        DpRepairStation repairStation = this.dpRepairStationMapper.findById(repairStationId);
        PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(repairStation.getPdProductInfoId());
        try {
            Task task = WorkFlowAdapter.getInstance().findWorkFlowTaskByProcessInstanceId(pdProductInfo.getInstanceId());
            if (task != null) {
                Map<String, Object> variables = WorkFlowAdapter.getInstance().getVariables(task.getId());
                if (variables == null) {
                    variables = Maps.newHashMap();
                }
                variables.put("message", message);
                this.saveDpProductInfoLog(pdProductInfo, dpProduceProcess.getId(), "1", userId, new Date());
                repairStation.setStatus(DpRepairStation.Status.QUALIFIED);
                this.dpRepairStationMapper.update(repairStation);
                WorkFlowAdapter.getInstance().completeTaskByTaskId(task, variables);
                flag = true;
                // 更改当前产品状态为正在生产
                pdProductInfo.setStatus(PdProductInfo.Status.STATUS_IS_REPAIRED);
                this.pdProductInfoMapper.update(pdProductInfo);
            }
        } catch (Exception e) {
            log.error("", e);
            throw new DubboProviderException(e);
        }
        return flag;
    }

    @Override
    public List<Node> getRouteProcesses(String projectId) {
        List<Node> nodes = Lists.newArrayList();
        Node base = new Node();
        base.setName("基础插件");
        base.setIcon("");
        base.setChildren(getBaseChildren());
        nodes.add(base);

        Node process = new Node();
        process.setName("工序插件");
        process.setIcon("");
        process.setChildren(getProcessChildren(projectId));
        nodes.add(process);

        return nodes;
    }

    @Override
    public String getProduceProcessStatus(String productInfoId, String produceProcessId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("pdProductInfoId", productInfoId);
        map.put("produceProcessId", produceProcessId);
        List<DpProductInfoLog> infoLogs = dpProductInfoLogMapper.findByMap(map);
        if (infoLogs != null && !infoLogs.isEmpty()) {
            return infoLogs.get(0).getIsSuccess();
        }
        return "2";
    }

    private List<Node> getProcessChildren(String projectId) {
        List<Node> nodes = Lists.newArrayList();
        List<Map<String, Object>> processes = dpRoutesMapper.getProcesses(projectId);
        if (processes != null && !processes.isEmpty()) {
            processes.forEach(process -> {
                process.put("class", ConfigHelper.getValue("process.plugin.class"));

                Node node = new Node();
                node.setId((String) process.get("id"));
                node.setName((String) process.get("name"));
                node.setIcon(process.get("icon") == null ? "" : new String((byte[]) process.get("icon")));
                process.remove("icon");
                node.setData(process);

                nodes.add(node);
            });
        }

        return nodes;
    }

    private List<Node> getBaseChildren() {
        List<Node> nodes = Lists.newArrayList();
        RouteBasePluginUtil.BasePluginNodes pluginNodes = RouteBasePluginUtil.getBasePluginNodes();
        if (pluginNodes != null && pluginNodes.getNodes() != null && !pluginNodes.getNodes().isEmpty()) {
            pluginNodes.getNodes().stream().filter(basePluginNode -> basePluginNode.isShow()).forEach(basePluginNode -> {
                Node node = new Node();
                node.setId(basePluginNode.getId());
                node.setName(basePluginNode.getName());
                node.setIcon(basePluginNode.getIcon());

                nodes.add(node);
            });
        }

        return nodes;
    }

    /**
     * 获取流程code
     *
     * @param workOrderId
     * @return
     */
    public DpRoutes getWfCode(String workOrderId) {
        DpRoutes dpRoutes = null;
        Map<String, Object> map = Maps.newHashMap();
        map.put("workOrderId", workOrderId);
        List<DpRoutes> dpRoutesList = (List) dpRoutesMapper.findByMap(map);
        if (dpRoutesList.size() > 0 && dpRoutesList != null) {
            dpRoutes = dpRoutesList.get(0);
        }
        return dpRoutes;
    }

    /**
     * 根据流程实例ID获取任务
     *
     * @param processInstanceId
     * @return
     */
    public PdProductInfo getPdProductInfoByProcessInstanceId(String processInstanceId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("instanceId", processInstanceId);
        PdProductInfo pdProductInfo = null;
        List<PdProductInfo> list = this.pdProductInfoMapper.findByMap(map);
        if (list.size() > 0) {
            pdProductInfo = list.get(0);
        }
        return pdProductInfo;
    }


    /**
     * 开发平台-产品生产工序记录
     *
     * @param pdProductInfo    产品
     * @param userId           用户
     * @param isSuccess        是否成功（0|1）
     * @param startTime        开始生产时间
     * @param produceProcessId 生产工序ID
     * @return
     */
    public void saveDpProductInfoLog(PdProductInfo pdProductInfo, String produceProcessId,
                                     String isSuccess, String userId, Date startTime) {
        //生产工序
        DpProduceProcess dpProduceProcess = dpProduceProcessMapper.findById(produceProcessId);
        //工序
        FtyProcess process = ftyProcessMapper.findById(dpProduceProcess.getProcessId());
        //工序编码
        String processCode = process.getCode();
        //用户
        User user = userMapper.findById(userId);
        //用户名
        String userName = user.getName();
        DpProductInfoLog dpProductInfoLog = new DpProductInfoLog();
        dpProductInfoLog.setId(IDGenerator.getID());
        dpProductInfoLog.setPdProductInfoId(pdProductInfo.getId());
        dpProductInfoLog.setDpLineId(pdProductInfo.getPdLineId());
        dpProductInfoLog.setPdId(pdProductInfo.getPdId());
        dpProductInfoLog.setWorkOrderId(pdProductInfo.getWorkOrderId());
        dpProductInfoLog.setProcessCode(processCode);
        dpProductInfoLog.setProcessName(process.getName());
        dpProductInfoLog.setProduceProcessId(produceProcessId);
        dpProductInfoLog.setWorkstationDeviceId(null);
        dpProductInfoLog.setIsSuccess(isSuccess);
        dpProductInfoLog.setCreateDate(new Date());
        dpProductInfoLog.setStartTime(startTime);
        dpProductInfoLog.setEndTime(new Date());
        dpProductInfoLog.setWorkOrderNum(pdProductInfo.getWorkOrderNum());
        dpProductInfoLog.setWorkOrderBatchNum(pdProductInfo.getWorkOrderBatchNum());
        dpProductInfoLog.setUserId(userId);
        dpProductInfoLog.setUserName(userName);
        dpProductInfoLogMapper.save(dpProductInfoLog);
    }

    /**
     * 保存维修站信息
     *
     * @param pdProductInfo
     * @param process
     * @param produceProcessId
     * @param userId
     */
    private void saveRepairStation(PdProductInfo pdProductInfo, FtyProcess process, String produceProcessId, String userId) {
        DpRepairStation dpRepairStation = new DpRepairStation();
        dpRepairStation.setId(IDGenerator.getID());
        dpRepairStation.setDpLineId(pdProductInfo.getPdLineId());
        dpRepairStation.setPdId(pdProductInfo.getPdId());
        PdWorkOrder workOrder = this.pdWorkOrderMapper.findById(pdProductInfo.getWorkOrderId());
        PdWorkOrderBatch workOrderBatch = this.pdWorkOrderBatchMapper.findByWorkOrderId(workOrder.getId());
        dpRepairStation.setWorkOrderBatchNum(workOrderBatch.getBatchNum());
        dpRepairStation.setWorkOrderId(workOrder.getId());
        dpRepairStation.setWorkOrderNum(workOrder.getWorkOrderNum());
        dpRepairStation.setProduceProcessId(produceProcessId);
        dpRepairStation.setProcessCode(process.getCode());
        dpRepairStation.setPdProductInfoId(pdProductInfo.getId());
        dpRepairStation.setUserId(userId);
        User user = userMapper.findById(userId);
        dpRepairStation.setUserName(user != null ? user.getName() : "");
        dpRepairStation.setStatus("0");
        dpRepairStation.setCreateDate(new Date());
        pdProductInfo.setStatus("2");
        dpRepairStationMapper.save(dpRepairStation);
    }


    /**
     * 上道工序是否成功校验
     *
     * @param pdProductInfoId
     * @param dpProduceProcess
     * @return
     */
    private boolean lastProcessValidate(String pdProductInfoId, DpProduceProcess dpProduceProcess) {
        boolean flag = true;
        Map<String, Object> query = Maps.newHashMap();
        query.put("pdProductInfoId", pdProductInfoId);
        query.put("produceProcessId", dpProduceProcess.getLastProduceProcessId());
        DpProductInfoLog productInfoLog = this.dpProductInfoLogMapper.findProcessRecentResultInfo(query);
        if (productInfoLog == null) {
            log.info("上道工序未完成!");
            flag = false;
        } else {
            if (productInfoLog.getIsSuccess().equalsIgnoreCase("0")) {
                log.info("上道工序未成功!");
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 自动以校验函数执行
     *
     * @param pdProductInfoId
     * @param userId
     * @param dpProduceProcess
     * @return
     * @throws ScriptException
     */
    private boolean customValidate(String pdProductInfoId, String userId, DpProduceProcess dpProduceProcess) throws ScriptException {
        boolean flag = false;
        DpFunction function = this.dpFunctionMapper.findById(dpProduceProcess.getCustomCheckFnId());
        if (null != function) {
            Map<String, Object> map = Maps.newHashMap();
            map.put(FunctionConstants.parameter.PD_PRODUCTINFO_ID, pdProductInfoId);
            map.put(FunctionConstants.parameter.USER_ID, userId);
            map.put(FunctionConstants.parameter.PRODUCE_PROCESS_ID, dpProduceProcess.getId());
            FunctionParameter parameter = new FunctionParameter();
            parameter.setRequestMap(map);
            flag = (boolean) GroovyUtil.evalScript(function.getScript(), parameter);
        }
        return flag;
    }

    /**
     * 校验工序设置条件
     *
     * @param pdProductInfoId
     * @param dpProduceProcessDate
     * @param dpProduceProcess
     * @return
     * @throws ScriptException
     */
    private boolean validateDate(String pdProductInfoId, DpProduceProcessDate dpProduceProcessDate, DpProduceProcess dpProduceProcess) throws ScriptException {
        Map<String, Object> queryMap = Maps.newHashMap();
        queryMap.put("pdProductInfoId", pdProductInfoId);
        queryMap.put("produceProcessId", dpProduceProcess.getLastProduceProcessId());
        DpProductInfoLog lastProcessProductInfoLog = this.dpProductInfoLogMapper.findProcessRecentResultInfo(queryMap);
        Date startTime = lastProcessProductInfoLog.getEndTime();
        Date now = new Date();
        Long spendTime = now.getTime() - startTime.getTime();
        Long standard = this.getTime(dpProduceProcessDate);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("groovy");
        String experession = spendTime + dpProduceProcessDate.getExpression() + standard;
        return (Boolean) scriptEngine.eval(experession);
    }

    /**
     * 根据时间配置对象获取毫秒数
     *
     * @param dpProduceProcessDate
     * @return
     */
    private Long getTime(DpProduceProcessDate dpProduceProcessDate) {
        Long time = 0L;
        int data = Integer.valueOf(dpProduceProcessDate.getData());
        String unit = dpProduceProcessDate.getUnit();
        if (unit == "h") {
            time = data * 60 * 60 * 1000L;
        }
        if (unit == "m") {
            time = data * 60 * 1000L;
        }
        if (unit == "s") {
            time = data * 1000L;
        }
        return time;
    }


}
