package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.DpSampleInspectionMapper;
import com.mes.control.mapper.PdMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.dubbo.interprovider.control.IDpRoutesProvider;
import com.mes.dubbo.interprovider.control.IDpSampleInspectionProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-抽检管理
 * Created by xiuyou.xu on 2017/09/12.
 */
public class DpSampleInspectionProviderImpl extends BaseProviderImpl<DpSampleInspection> implements IDpSampleInspectionProvider {
    private static Logger logger = LoggerFactory.getLogger(DpSampleInspectionProviderImpl.class);

    @Autowired
    @Qualifier("dpSampleInspectionMapper")
    private DpSampleInspectionMapper dpSampleInspectionMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Autowired
    @Qualifier("dpRoutesProvider")
    private IDpRoutesProvider dpRoutesProvider;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;


    @Override
    public DpSampleInspectionMapper getBaseInterfaceMapper() {
        return dpSampleInspectionMapper;
    }

    @Override
    public boolean saveOrUpdate(int num, PdWorkOrder workOrder) throws DubboProviderException {
        boolean flag = true;
        try {
            Pd pd = this.pdMapper.findById(workOrder.getPdId());
            if (null != pd) {
                DpSampleInspection sampleInspection = new DpSampleInspection();
                sampleInspection.setPdId(pd.getId());
                sampleInspection.setPdLineId(pd.getPdLineId());
                sampleInspection.setInspectionNum((long) 0);
                sampleInspection.setUnqualiedNum((long) 0);
                sampleInspection.setQualifiedNum((long) 0);
                sampleInspection.setSampleNum((long) num);
                sampleInspection.setResult("0");
                sampleInspection.setWorkOrderId(workOrder.getId());
                List<DpSampleInspection> sampleInspectionList = this.dpSampleInspectionMapper.findByWorkOrder(sampleInspection.getWorkOrderId());
                if (sampleInspectionList.isEmpty()) {
                    super.save(sampleInspection);
                } else {
                    DpSampleInspection dpSampleInspection = sampleInspectionList.get(0);
                    Long inspectionNum = sampleInspection.getInspectionNum();
                    Long sample = dpSampleInspection.getSampleNum();
                    if (sample < inspectionNum) {
                        flag = false;
                    } else {
                        dpSampleInspection.setSampleNum(sampleInspection.getSampleNum());
                        super.update(dpSampleInspection);
                    }
                }
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean passStation(PdWorkOrder pdWorkOrder, String userId, DpProduceProcess produceProcess) throws DubboProviderException {
        boolean flag = true;
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("workOrderId", pdWorkOrder.getId());
            List<PdProductInfo> productInfoList = this.pdProductInfoMapper.findByMap(query);
            if (!productInfoList.isEmpty()) {
                for (PdProductInfo pdProductInfo : productInfoList) {
                    this.dpRoutesProvider.completeTask(pdProductInfo.getId(), userId, produceProcess.getId(), "1");
                    pdProductInfo.setStatus(PdProductInfo.Status.STATUS_IS_COMPLETE);
                    this.pdProductInfoMapper.update(pdProductInfo);
                }
            }
        }catch (Exception e){
            flag = false;
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }
}
