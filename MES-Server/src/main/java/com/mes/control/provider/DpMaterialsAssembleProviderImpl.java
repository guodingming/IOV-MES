package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.*;
import com.mes.dubbo.interprovider.control.IDpMaterialsAssembleProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-上料管理-组装
 * Created by xiuyou.xu on 2017/09/13.
 */
public class DpMaterialsAssembleProviderImpl extends BaseProviderImpl<DpMaterialsAssemble> implements IDpMaterialsAssembleProvider {
    private static Logger logger = LoggerFactory.getLogger(DpMaterialsAssembleProviderImpl.class);

    @Autowired
    @Qualifier("dpMaterialsAssembleMapper")
    private DpMaterialsAssembleMapper dpMaterialsAssembleMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("dpMaterialsInfoMapper")
    private DpMaterialsInfoMapper dpMaterialsInfoMapper;

    @Autowired
    @Qualifier("dpMaterialsLoadMapper")
    private DpMaterialsLoadMapper dpMaterialsLoadMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Override
    public DpMaterialsAssembleMapper getBaseInterfaceMapper() {
        return dpMaterialsAssembleMapper;
    }

    @Override
    public JsonViewObject updateOperation(String number, String materialIds, Map<String, Object> session, boolean isRework) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        List<DpMaterialsAssemble> materialsAssembleList = Lists.newArrayList();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(productInfoNumber.getPdProductInfoId());
            PdWorkOrder workOrder = (PdWorkOrder) session.get("workOrder");
            DpProduceProcess produceProcess = (DpProduceProcess) session.get("produceProcess");
            materialsAssembleList = this.getAssembleInfo(pdProductInfo, produceProcess, workOrder);
            if (materialsAssembleList.isEmpty() || isRework) {
                if (StringUtils.isNotBlank(materialIds)) {
                    List<DpMaterialsLoad> dpMaterialsLoadList = Lists.newArrayList();
                    List<String> materialList = Arrays.asList(materialIds.split(","));
                    for (String id : materialList) {
                        DpMaterialsLoad materialsLoad = this.dpMaterialsLoadMapper.findById(id);
                        dpMaterialsLoadList.add(materialsLoad);
                    }
                    for (DpMaterialsLoad materialsLoad : dpMaterialsLoadList) {
                        this.assemble(pdProductInfo, materialsLoad, produceProcess);
                    }
                    jsonView.successPack(materialsAssembleList, "组装成功");
                } else {
                    jsonView.failPack(materialsAssembleList, "组装失败,请选择组装物料");
                }
            } else {
                //返回工作站是否重工
                jsonView.successPack("rework");
            }
        } catch (Exception e) {
            jsonView.failPack(materialsAssembleList, "组装失败,服务器异常");
            log.error("DpMaterialsAssembleProviderImpl operation", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public List<DpMaterialsAssemble> findMaterialsAssemble(String productInfoId, DpProduceProcess produceProcess, PdWorkOrder workOrder) throws DubboProviderException {
        List<DpMaterialsAssemble> materialsAssembleList = Lists.newArrayList();
        try {
            PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(productInfoId);
            materialsAssembleList = this.getAssembleInfo(pdProductInfo, produceProcess, workOrder);
        } catch (Exception e) {
            log.error("DpMaterialsAssembleProviderImpl operation", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return materialsAssembleList;
    }

    /**
     * 产品组装及物料信息同步
     *
     * @param productInfo
     * @param materialsLoad
     * @throws DubboProviderException
     */
    private void assemble(PdProductInfo productInfo, DpMaterialsLoad materialsLoad, DpProduceProcess produceProcess) throws DubboProviderException {
        DpMaterialsAssemble materialsAssemble = new DpMaterialsAssemble();
        materialsAssemble.setDpLineId(productInfo.getPdLineId());
        materialsAssemble.setPdId(productInfo.getPdId());
        materialsAssemble.setWorkOrderId(productInfo.getWorkOrderId());
        materialsAssemble.setPdProductInfoId(productInfo.getId());
        materialsAssemble.setMaterialType(materialsLoad.getType());
        materialsAssemble.setProduceProcessId(produceProcess.getId());
        materialsAssemble.setMaterialName(materialsLoad.getName());
        materialsAssemble.setMaterialCode(materialsLoad.getCode());
        if (materialsLoad.getType().equalsIgnoreCase(DpMaterialsInfo.Type.BATCH_MATERIAL)) {
            materialsAssemble.setDpMaterialsInfoId(materialsLoad.getId());
        } else {
            //TODO 非批次料组装处理
        }
        materialsLoad.setRemainNum(materialsLoad.getRemainNum() - materialsLoad.getUnitNum());
        this.dpMaterialsLoadMapper.update(materialsLoad);
        super.save(materialsAssemble);
    }

    /**
     * 获取当前产品已经组装的物料信息
     *
     * @param productInfo
     * @param produceProcess
     * @param workOrder
     * @return
     */
    private List<DpMaterialsAssemble> getAssembleInfo(PdProductInfo productInfo, DpProduceProcess produceProcess, PdWorkOrder workOrder) {
        List<DpMaterialsAssemble> materialsAssembleList = Lists.newArrayList();
        if (null != produceProcess
                && null != productInfo
                && null != workOrder) {
            Map<String, Object> query = Maps.newHashMap();
            query.put("workOrderId", workOrder.getId());
            query.put("produceProcessId", produceProcess.getId());
            query.put("pdProductInfoId", productInfo.getId());
            materialsAssembleList = this.dpMaterialsAssembleMapper.findByMap(query);
        }
        return materialsAssembleList;
    }

    @Override
    public JsonViewObject checkIsAssemble(String number, Map<String, Object> session) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            if (null != productInfoNumber) {
                PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(productInfoNumber.getPdProductInfoId());
                PdWorkOrder workOrder = (PdWorkOrder) session.get("workOrder");
                DpProduceProcess produceProcess = (DpProduceProcess) session.get("produceProcess");
                List<DpMaterialsAssemble> materialsAssembleList = this.getAssembleInfo(pdProductInfo, produceProcess, workOrder);
                if (materialsAssembleList.isEmpty()) {
                    jsonView.successPack(false, "未组装");
                } else {
                    jsonView.successPack(true, "已经组装");
                }
            } else {
                jsonView.failPack("请检查输入条码!");
            }

        } catch (Exception e) {
            jsonView.failPack("校验是否组装失败");
            log.error("DpMaterialsAssembleProviderImpl checkIsAssemble", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject updateRepeat(String number, String materialIds, Map<String, Object> session) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);

        } catch (Exception e) {
            jsonView.failPack("组装失败");
            log.error("DpMaterialsAssembleProviderImpl updateRepeat", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject getMaterialsInfo(PdWorkOrder workOrder, DpProduceProcess produceProcess) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        List<DpMaterialsLoad> materialsLoadList = Lists.newArrayList();
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("produceProcessId", produceProcess.getId());
            query.put("workOrderId", workOrder.getId());
            materialsLoadList = this.dpMaterialsLoadMapper.findByMap(query);
            jsonView.successPack(materialsLoadList, "获取当前工单当前工序所上物料成功");
        } catch (Exception e) {
            jsonView.failPack(materialsLoadList, "获取当前工单当前工序所上物料失败,服务器异常");
            log.error("DpMaterialsAssembleProviderImpl getMaterialsInfo", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }
}
