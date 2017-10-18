package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.control.mapper.DpRepairStationMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.control.utils.WorkFlowAdapter;
import com.mes.dubbo.interprovider.control.IDpRepairStationProvider;
import com.mes.entity.control.DpRepairStation;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdProductInfoNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品维修站
 * Created by xiuyou.xu on 2017/08/25.
 */
public class DpRepairStationProviderImpl extends BaseProviderImpl<DpRepairStation> implements IDpRepairStationProvider {
    private static Logger logger = LoggerFactory.getLogger(DpRepairStationProviderImpl.class);

    @Autowired
    @Qualifier("dpRepairStationMapper")
    private DpRepairStationMapper dpRepairStationMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Override
    public DpRepairStationMapper getBaseInterfaceMapper() {
        return dpRepairStationMapper;
    }

    @Override
    public JsonViewObject getRepairStationInfoByNumber(String number) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            List<DpRepairStation> repairStationList = Lists.newArrayList();
            if (null != productInfoNumber) {
                repairStationList = this.dpRepairStationMapper.findByProductInfoId(productInfoNumber.getPdProductInfoId());
                if (repairStationList.isEmpty()) {
                    jsonView.failPack(repairStationList,"根据产品条码获取产品维修站信息失败");
                } else {
                    jsonView.successPack(repairStationList, "根据产品条码获取产品维修站信息成功");
                }
            } else {
                jsonView.failPack(repairStationList,"根据产品条码获取产品维修站信息失败");
            }
        } catch (Exception e) {
            jsonView.failPack(Lists.newArrayList(),"根据产品条码获取产品维修站信息失败");
            log.error("DpRepairStationProviderImpl getRepairStationInfoByNumber 根据产品条码获取产品维修站信息失败!");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject getRepairStationNextProcess(String pdProductInfoId) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        List<Map<String, Object>> result = Lists.newArrayList();
        try {
            PdProductInfo productInfo = this.pdProductInfoMapper.findById(pdProductInfoId);
            if (null != pdProductInfoId) {
               result = WorkFlowAdapter.getInstance().getRepairStationNextTaskInfo(productInfo.getInstanceId());
               jsonView.successPack(result, "获取维修站出口工序信息成功");
            } else {
                jsonView.failPack(result,"获取维修站出口工序信息失败,服务器异常");
            }
        } catch (Exception e) {
            jsonView.failPack(result,"获取维修站出口工序信息失败,服务器异常");
            log.error("DpRepairStationProviderImpl getRepairStationInfoByNumber 根据产品条码获取产品维修站信息失败!");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }
}
