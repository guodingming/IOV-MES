package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.control.mapper.DpSampleInspectionDetailMapper;
import com.mes.control.mapper.DpSampleInspectionMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.dubbo.interprovider.control.IDpSampleInspectionDetailProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-抽检管理-抽检详细
 * Created by xiuyou.xu on 2017/09/12.
 */
public class DpSampleInspectionDetailProviderImpl extends BaseProviderImpl<DpSampleInspectionDetail> implements IDpSampleInspectionDetailProvider {
    private static Logger logger = LoggerFactory.getLogger(DpSampleInspectionDetailProviderImpl.class);

    @Autowired
    @Qualifier("dpSampleInspectionDetailMapper")
    private DpSampleInspectionDetailMapper dpSampleInspectionDetailMapper;

    @Autowired
    @Qualifier("pdProductInfoNumberMapper")
    private PdProductInfoNumberMapper pdProductInfoNumberMapper;

    @Autowired
    @Qualifier("pdProductInfoMapper")
    private PdProductInfoMapper pdProductInfoMapper;

    @Autowired
    @Qualifier("dpSampleInspectionMapper")
    private DpSampleInspectionMapper dpSampleInspectionMapper;

    @Override
    public DpSampleInspectionDetailMapper getBaseInterfaceMapper() {
        return dpSampleInspectionDetailMapper;
    }

    @Override
    public JsonViewObject getQCInfo(PdWorkOrder workOrder) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        Map<String, Object> result = Maps.newHashMap();
        try {
            Map<String, Object> query = Maps.newHashMap();
            query.put("workOrderId", workOrder.getId());
            List<DpSampleInspectionDetail> dpSampleInspectionDetailList = this.dpSampleInspectionDetailMapper.findByMap(query);
            List<DpSampleInspection> dpSampleInspectionList = this.dpSampleInspectionMapper.findByMap(query);
            if (!dpSampleInspectionList.isEmpty()) {
                DpSampleInspection dpSampleInspection = dpSampleInspectionList.get(0);
                query.put("status", "1");
                int qualifiedNum = this.dpSampleInspectionDetailMapper.getCount(query);
                query.put("status", "0");
                int unqualifiedNum = this.dpSampleInspectionDetailMapper.getCount(query);
                result.put("data", dpSampleInspectionDetailList);
                result.put("result", dpSampleInspection.getResult());
                result.put("sampleNum", dpSampleInspection.getSampleNum());
                result.put("id", dpSampleInspection.getId());
                result.put("inspectionNum", dpSampleInspection.getInspectionNum());
                result.put("qualifiedNum", qualifiedNum);
                result.put("unqualifiedNum", unqualifiedNum);
                jsonView.successPack(result, "查询抽检数据成功");
            } else {
                jsonView.successPack(result, "查询抽检数据成功");
            }

        }catch (Exception e){
            jsonView.failPack(result, "查询抽检数据失败,服务器异常");
            log.error("DpSampleInspectionDetailProviderImpl getQCInfo ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject saveQualifiedInfo(PdWorkOrder workOrder, String number) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(number);
            List<DpSampleInspection> sampleInspectionList = this.dpSampleInspectionMapper.findByWorkOrder(workOrder.getId());
            if (null != productInfoNumber && !sampleInspectionList.isEmpty()) {
                DpSampleInspection sampleInspection = sampleInspectionList.get(0);
                Long sampleNum = sampleInspection.getSampleNum();
                Long inspectedNum = sampleInspection.getInspectionNum();
                if (sampleNum == inspectedNum) {
                    jsonView.failPack(false, "保存检验结果失败, 抽检样本数量超出指定数量");
                } else {
                    DpSampleInspectionDetail exist = this.dpSampleInspectionDetailMapper.findByProductInfoId(productInfoNumber.getPdProductInfoId());
                    if (null != exist) {
                        jsonView.failPack("该产品已经检验");
                    } else {
                        PdProductInfo pdProductInfo = this.pdProductInfoMapper.findById(productInfoNumber.getPdProductInfoId());
                        DpSampleInspectionDetail sampleInspectionDetail = new DpSampleInspectionDetail();
                        sampleInspectionDetail.setWorkOrderId(workOrder.getId());
                        sampleInspectionDetail.setPdProductInfoId(pdProductInfo.getId());
                        sampleInspectionDetail.setPdId(pdProductInfo.getPdId());
                        sampleInspectionDetail.setPdLineId(pdProductInfo.getPdLineId());
                        sampleInspectionDetail.setStatus("1");
                        String id = super.save(sampleInspectionDetail);
                        sampleInspection.setInspectionNum(sampleInspection.getInspectionNum() + 1);
                        this.dpSampleInspectionMapper.update(sampleInspection);
                        jsonView.successPack(true, "保存检验结果成功");
                    }
                }
            } else {
                jsonView.failPack(true, "保存检验结果失败, 服务器异常");
            }
        }catch (Exception e){
            jsonView.failPack(true, "保存检验结果失败, 服务器异常");
            log.error("DpSampleInspectionDetailProviderImpl saveQualifiedInfo", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }

    @Override
    public JsonViewObject updateUnqualified(DpSampleInspectionDetail dpSampleInspectionDetail) throws DubboProviderException {
        JsonViewObject jsonView = new JsonViewObject();
        try {
            PdProductInfoNumber productInfoNumber = this.pdProductInfoNumberMapper.findByNumber(dpSampleInspectionDetail.getNumber());
            if (null != productInfoNumber) {
                DpSampleInspectionDetail sampleInspectionDetail = this.dpSampleInspectionDetailMapper.findByProductInfoId(productInfoNumber.getPdProductInfoId());
                if (null != sampleInspectionDetail) {
                    sampleInspectionDetail.setStatus("0");
                    sampleInspectionDetail.setDescription(dpSampleInspectionDetail.getDescription());
                    boolean flag = super.update(sampleInspectionDetail);
                    if (flag) {
                        jsonView.successPack(true, "保存检验结果成功");
                    } else {
                        jsonView.failPack(false, "保存检验结果失败, 服务器异常");
                    }
                } else {
                    jsonView.failPack(false, "保存检验结果失败, 该条码对应产品未装箱或不存在");
                }
            } else {
                jsonView.failPack(false, "保存检验结果失败, 请输入产品条码");
            }
        }catch (Exception e){
            jsonView.failPack(false, "保存检验结果失败, 服务器异常");
            log.error("DpSampleInspectionDetailProviderImpl updateUnqualified");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return jsonView;
    }
}
