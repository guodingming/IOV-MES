package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.control.mapper.DpMaterialsInfoMapper;
import com.mes.control.mapper.DpMaterialsLoadMapper;
import com.mes.control.mapper.PdMapper;
import com.mes.dubbo.interprovider.control.IDpMaterialsLoadProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-上料管理-上料
 * Created by xiuyou.xu on 2017/09/21.
 */
public class DpMaterialsLoadProviderImpl extends BaseProviderImpl<DpMaterialsLoad> implements IDpMaterialsLoadProvider {
    private static Logger logger = LoggerFactory.getLogger(DpMaterialsLoadProviderImpl.class);

    @Autowired
    @Qualifier("dpMaterialsLoadMapper")
    private DpMaterialsLoadMapper dpMaterialsLoadMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Autowired
    @Qualifier("dpMaterialsInfoMapper")
    private DpMaterialsInfoMapper dpMaterialsInfoMapper;

    @Override
    public DpMaterialsLoadMapper getBaseInterfaceMapper() {
        return dpMaterialsLoadMapper;
    }

    @Override
    public JsonViewObject saveLoadMaterial(DpMaterialsLoad dpMaterialsLoad, PdWorkOrder pdWorkOrder, DpProduceProcess dpProduceProcess) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            Pd pd = this.pdMapper.findById(pdWorkOrder.getPdId());
            Map<String, Object> query = Maps.newHashMap();
            query.put("materialInfoId", dpMaterialsLoad.getMaterialInfoId());
            query.put("produceProcessId", dpProduceProcess.getId());
            query.put("workOrderId", pdWorkOrder.getId());
            List<DpMaterialsLoad> dpMaterialsLoadList = this.dpMaterialsLoadMapper.findByMap(query);
            if (dpMaterialsLoadList.isEmpty()) {
                DpMaterialsInfo dpMaterialsInfo = this.dpMaterialsInfoMapper.findById(dpMaterialsLoad.getMaterialInfoId());
                dpMaterialsLoad.setPdId(pd.getId());
                dpMaterialsLoad.setPdLineId(pd.getPdLineId());
                dpMaterialsLoad.setCode(dpMaterialsInfo.getCode());
                dpMaterialsLoad.setName(dpMaterialsInfo.getName());
                dpMaterialsLoad.setWorkOrderId(pdWorkOrder.getId());
                dpMaterialsLoad.setProduceProcessId(dpProduceProcess.getId());
                dpMaterialsLoad.setUnitNum(1L);
                dpMaterialsLoad.setRemainNum(dpMaterialsLoad.getLoadNum());
                super.save(dpMaterialsLoad);
            } else {
                DpMaterialsLoad materialsLoad = dpMaterialsLoadList.get(0);
                materialsLoad.setLoadNum(dpMaterialsLoad.getLoadNum());
                super.update(materialsLoad);
            }
            jsonView.successPack(true, "根据物料类型上料成功");
        }catch (Exception e){
            jsonView.failPack(false, "根据物料类型上料失败,服务器异常");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }
}
