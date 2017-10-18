package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.DpProjectMapper;
import com.mes.control.mapper.PdMapper;
import com.mes.control.mapper.PdProductionLineInfoMapper;
import com.mes.dubbo.interprovider.control.IPdProvider;
import com.mes.entity.control.DpProject;
import com.mes.entity.control.Pd;
import com.mes.entity.control.PdProductionLineInfo;
import com.mes.entity.control.PdproductionLineInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-产品
 */
public class PdProviderImpl extends BaseProviderImpl<Pd> implements IPdProvider {
    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;
    @Autowired
    @Qualifier("pdProductionLineInfoMapper")
    private PdProductionLineInfoMapper pdProductionLineInfoMapper;

    @Autowired
    @Qualifier("dpProjectMapper")
    private DpProjectMapper dpProjectMapper;

    @Override
    public PdMapper getBaseInterfaceMapper() {
        return pdMapper;
    }

    /**
     * 新建产品保存
     *
     * @param pdproductionLineInfoList
     * @return
     * @throws DubboProviderException lednegyun--2017/09/29
     */
    public String savePd(PdproductionLineInfoList pdproductionLineInfoList) throws DubboProviderException {
        String id = null;
        String idd = null;
        List pdProductionLineIds = pdproductionLineInfoList.getProductionLineIds();
        id = IDGenerator.getID();
        Pd pd = new Pd();
        pd.setId(id);
        pd.setCode(pdproductionLineInfoList.getCode());
        pd.setName(pdproductionLineInfoList.getName());
        pd.setPdLineId(pdproductionLineInfoList.getPdLineId());
        pd.setDescription(pdproductionLineInfoList.getDescription());
        pd.setCreateDate(new Date());
        pdMapper.save(pd);
        for (int i = 0; i < pdProductionLineIds.size(); i++) {
            PdProductionLineInfo pdProductionLineInfo = new PdProductionLineInfo();
            idd = IDGenerator.getID();
            pdProductionLineInfo.setPdId(id);
            pdProductionLineInfo.setId(idd);
            pdProductionLineInfo.setProductionLineId((String) pdProductionLineIds.get(i));
            pdProductionLineInfo.setCreateDate(new Date());
            pdProductionLineInfoMapper.save(pdProductionLineInfo);
        }
        return id;
    }

    @Override
    public boolean update(Pd entity) throws DubboProviderException {
        boolean flag = false;
        try {
            super.update(entity);
            List<String> productLineIds = entity.getProductionLineIds();
            Map<String, Object> query = Maps.newHashMap();
            query.put("pdId", entity.getId());
            List<PdProductionLineInfo> pdProductionLineInfoList = this.pdProductionLineInfoMapper.findByMap(query);
            for (PdProductionLineInfo pdProductionLineInfo : pdProductionLineInfoList) {
                this.pdProductionLineInfoMapper.deleteById(pdProductionLineInfo.getId());
            }
            if (!productLineIds.isEmpty()) {
                for (String productLineId : productLineIds) {
                    PdProductionLineInfo pdProductionLineInfo = new PdProductionLineInfo();
                    pdProductionLineInfo.setPdId(entity.getId());
                    pdProductionLineInfo.setProductionLineId(productLineId);
                    pdProductionLineInfo.setId(IDGenerator.getID());
                    pdProductionLineInfo.setCreateDate(new Date());
                    this.pdProductionLineInfoMapper.save(pdProductionLineInfo);
                }
            }
            flag = true;
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public List<Node> getProjectTree(String pdLineId) throws DubboProviderException {
        List<Node> result = Lists.newArrayList();
        try {
            List<Pd> pdList = this.pdMapper.findByPdLineId(pdLineId);
            for (Pd pd : pdList) {
                Node pdNode = new Node();
                pdNode.setData(pd);
                pdNode.setName(pd.getName());
                pdNode.setParentId("0");
                Map<String, Object> query = Maps.newHashMap();
                query.put("pdId", pd.getId());
                List<DpProject> dpProjectList = this.dpProjectMapper.findByMap(query);
                List<Node> children = Lists.newArrayList();
                for (DpProject project : dpProjectList) {
                    Node projectNode = new Node();
                    projectNode.setParentId(pd.getId());
                    projectNode.setName(project.getName());
                    projectNode.setId(project.getId());
                    projectNode.setLeaf(true);
                    children.add(projectNode);
                }
                pdNode.setChildren(children);
                result.add(pdNode);
            }
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return result;
    }
}
