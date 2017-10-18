package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.control.mapper.DpProductInfoLogMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.dubbo.interprovider.control.IDpProductInfoLogProvider;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdProductInfoNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品生产工序记录
 */
public class DpProductInfoLogProviderImpl extends BaseProviderImpl<DpProductInfoLog> implements IDpProductInfoLogProvider {
    @Autowired
    @Qualifier("dpProductInfoLogMapper")
    private DpProductInfoLogMapper dpProductInfoLogMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Override
    public DpProductInfoLogMapper getBaseInterfaceMapper() {
        return dpProductInfoLogMapper;
    }

    public int getInt(String produceProcessId, String isSuccess) throws DubboProviderException {
        Map map = new HashMap();
        map.put("produceProcessId", produceProcessId);
        if (isSuccess != null && !isSuccess.equals("")) {
            map.put("isSuccess", isSuccess);
        }
        int a = dpProductInfoLogMapper.getCount(map);
        return a;
    }

    @Override
    public List<DpProductInfoLog> getProduceProcessInfo(String number) throws DubboProviderException {
        List<DpProductInfoLog> dpProductInfoLogList = Lists.newArrayList();
        try {
            PdProductInfoNumber pdProductInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            if (pdProductInfoNumber != null) {
                dpProductInfoLogList = this.dpProductInfoLogMapper.findProcessLastResultInfo(pdProductInfoNumber.getPdProductInfoId());
            }
        } catch (Exception e) {
            log.error("根据产品条码查询工序结果失败!");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return dpProductInfoLogList;
    }

    @Override
    public JsonViewObject getProductInfoLog(List<PdProductInfo> productInfoList, Map<String, Object> session) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        List<DpProductInfoLog> result = Lists.newArrayList();
        try {
            DpProduceProcess produceProcess = (DpProduceProcess) session.get("produceProcess");
            for (PdProductInfo pdProductInfo : productInfoList) {
                List<DpProductInfoLog> productInfoLogList = this.dpProductInfoLogMapper.findProcessLastResultInfo(pdProductInfo.getId());
                for (DpProductInfoLog productInfoLog : productInfoLogList) {
                    if (productInfoLog.getProduceProcessId().equalsIgnoreCase(produceProcess.getId())) {
                        result.add(productInfoLog);
                    }
                }
            }
            jsonView.successPack(result, "获取产品工序操作数据成功");
        } catch (Exception e) {
            jsonView.failPack(result, "获取产品工序操作数据失败,服务器异常");
            log.error("获取产品工序操作数据失败");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject getProductInfoLog(List<PdProductInfo> productInfoList, DpProduceProcess dpProduceProcess) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        List<DpProductInfoLog> result = Lists.newArrayList();
        try {
            //获取正常生产产品当前工序日志
            List<DpProductInfoLog> dpProductInfoLogList = Lists.newArrayList();
            for (PdProductInfo pdProductInfo : productInfoList) {
                List<DpProductInfoLog> productInfoLogList = this.dpProductInfoLogMapper.findProcessLastResultInfo(pdProductInfo.getId());
                for (DpProductInfoLog productInfoLog : productInfoLogList) {
                    if (productInfoLog.getProduceProcessId().equalsIgnoreCase(dpProduceProcess.getId())) {
                        dpProductInfoLogList.add(productInfoLog);
                    }
                }
            }
            if (dpProductInfoLogList.isEmpty()) {
                jsonView.successPack(result, "获取产品工序操作数据成功");
            } else {
                //获取异常产品当前工序日志（异常指产品未在当前站）
                for (PdProductInfo pdProductInfo : productInfoList) {
                    boolean flag = true;
                    DpProductInfoLog dpProductInfoLog = null;
                    for (DpProductInfoLog productInfoLog : dpProductInfoLogList) {
                        if (pdProductInfo.getId().equals(productInfoLog.getPdProductInfoId())) {
                            dpProductInfoLog = productInfoLog;
                            flag = false;
                        }
                    }
                    if (flag) {
                        dpProductInfoLog = this.dpProductInfoLogMapper.findProductRecentInfo(pdProductInfo.getId());
                        PdProductInfo productInfo = this.pdProductInfoMapper.findById(pdProductInfo.getId());
                        if (productInfo.getStatus().equals(PdProductInfo.Status.STATUS_NO_PRODUCTION)) {
                            dpProductInfoLog.setIsSuccess(DpProductInfoLog.Status.NO_PRODUCTION);
                        }
                        if (productInfo.getStatus().equals(PdProductInfo.Status.STATUS_ON_REPAIRSTATION)) {
                            dpProductInfoLog.setIsSuccess(DpProductInfoLog.Status.ON_REPAIRSTATION);
                        }
                        if (productInfo.getStatus().equals(PdProductInfo.Status.STATUS_IS_REPAIRED)) {
                            dpProductInfoLog.setIsSuccess(DpProductInfoLog.Status.WAIT_PRODUCTION);
                        }
                    }
                    result.add(dpProductInfoLog);
                }
                jsonView.successPack(result, "获取产品工序操作数据成功");
            }
        } catch (Exception e) {
            jsonView.failPack(result, "获取产品工序操作数据失败,服务器异常");
            log.error("获取产品工序操作数据失败");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }
}
