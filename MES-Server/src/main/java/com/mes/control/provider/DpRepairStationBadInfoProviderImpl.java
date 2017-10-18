package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.control.mapper.DpProductInfoLogMapper;
import com.mes.control.mapper.DpRepairStationBadInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.dubbo.interprovider.control.IDpRepairStationBadInfoProvider;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.DpRepairStationBadInfo;
import com.mes.entity.control.PdProductInfoNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品维修站-不良信息
 * Created by xiuyou.xu on 2017/08/25.
 */
public class DpRepairStationBadInfoProviderImpl extends BaseProviderImpl<DpRepairStationBadInfo> implements IDpRepairStationBadInfoProvider {
    private static Logger logger = LoggerFactory.getLogger(DpRepairStationBadInfoProviderImpl.class);

    @Autowired
    @Qualifier("dpRepairStationBadInfoMapper")
    private DpRepairStationBadInfoMapper dpRepairStationBadInfoMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("dpProductInfoLogMapper")
    private DpProductInfoLogMapper dpProductInfoLogMapper;

    @Override
    public DpRepairStationBadInfoMapper getBaseInterfaceMapper() {
        return dpRepairStationBadInfoMapper;
    }

    @Override
    public JsonViewObject getBadInfoByNumber(String number) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        List<DpRepairStationBadInfo> repairStationBadInfoList = Lists.newArrayList();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            if (null != productInfoNumber) {
                Map<String, Object> query = Maps.newHashMap();
                query.put("pdProductInfoId", productInfoNumber.getPdProductInfoId());
                repairStationBadInfoList = this.dpRepairStationBadInfoMapper.findByMap(query);
                jsonView.successPack(repairStationBadInfoList, "根据产品条码获取产品不良信息成功");
            } else {
                jsonView.failPack(repairStationBadInfoList, "根据产品条码获取产品不良信息成功,服务器异常");
            }
        } catch (Exception e) {
            jsonView.failPack(repairStationBadInfoList, "根据产品条码获取产品不良信息成功,服务器异常");
            log.error("DpRepairStationBadInfoProviderImpl getBadInfoByNumber 根据产品条码获取产品不良信息失败!");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject saveRepairInfo(DpRepairStationBadInfo dpRepairStationBadInfo, DpProduceProcess produceProcess) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        String id = super.save(dpRepairStationBadInfo);
        List<DpProductInfoLog> productInfoLogList = this.dpProductInfoLogMapper.findProcessLastResultInfo(dpRepairStationBadInfo.getPdProductInfoId());
        for (DpProductInfoLog productInfoLog : productInfoLogList) {
            if (productInfoLog.getProduceProcessId().equalsIgnoreCase(produceProcess.getId())){
                productInfoLog.setIsSuccess("0");
                this.dpProductInfoLogMapper.update(productInfoLog);
            }
        }
        jsonView.successPack(true, "保存不良记录成功");
        return jsonView;
    }
}
