package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.control.mapper.*;
import com.mes.dubbo.consumer.ControlConsumer;
import com.mes.dubbo.interprovider.control.IFtyEnterpriseProvider;
import com.mes.entity.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

public class FtyEnterpriseProviderImpl extends BaseProviderImpl<FtyEnterprise> implements IFtyEnterpriseProvider {
    @Autowired
    @Qualifier("ftyEnterpriseMapper")
    private FtyEnterpriseMapper ftyEnterpriseMapper;

    @Autowired
    @Qualifier("ftySiteInfoMapper")
    private FtySiteInfoMapper ftySiteInfoMapper;

    @Autowired
    @Qualifier("ftyAreaMapper")
    private FtyAreaMapper ftyAreaMapper;

    @Autowired
    @Qualifier("ftyProductionLineMapper")
    private FtyProductionLineMapper ftyProductionLineMapper;

    @Autowired
    @Qualifier("pdMapper")
    private PdMapper pdMapper;

    @Override
    public FtyEnterpriseMapper getBaseInterfaceMapper() {
        return ftyEnterpriseMapper;
    }

    /**
     * 企业-工厂-车间，树数据查询
     *
     * @return
     */
    public List<Node> getTree() {
        List<Node> nodes = Lists.newArrayList();
        List<FtyEnterprise> list = null;
        list = ftyEnterpriseMapper.findAll();
        if (list != null && !list.isEmpty()) {
            list.stream().forEach(ftyEnterprise -> {
                Node node = new Node();
                node.setId(ftyEnterprise.getId());
                node.setName(ftyEnterprise.getCompany());
                List<Node> nnode = ControlConsumer.getFtySiteInfoProvider().getSiteAreaTree(ftyEnterprise.getId());
                node.setChildren(nnode);
                nodes.add(node);

            });

        }
        return nodes;
    }

    @Override
    public List<Node> getDashboardTree() throws DubboProviderException {
        List<Node> enterprises = Lists.newArrayList();
        List<FtyEnterprise> allEnterprises = ftyEnterpriseMapper.findAll();
        if (allEnterprises != null && !allEnterprises.isEmpty()) {
            allEnterprises.forEach(ftyEnterprise -> {
                Node node = new Node();
                node.setId(ftyEnterprise.getId());
                node.setName(ftyEnterprise.getCompany());
                node.setData(ftyEnterprise);
                buildSiteInfo(ftyEnterprise, node);

                enterprises.add(node);
            });
        }

        return enterprises;
    }

    /**
     * 分类删除验证
     * @param id
     * @return
     * lednegyun--2017/10/10
     * @throws DubboProviderException
     */
    public boolean check(String id)throws DubboProviderException{

        int usage;
        boolean flag = true;
        usage = ftyEnterpriseMapper.countUsage(id);
        if(usage>0){
            flag = false;
        }
        return flag;

    }

    private void buildSiteInfo(FtyEnterprise ftyEnterprise, Node enterprise) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("enterpriseId", ftyEnterprise.getId());
        List<FtySiteInfo> ftySiteInfos = ftySiteInfoMapper.findByMap(params);
        List<Node> children = Lists.newArrayList();
        if (ftySiteInfos != null && !ftySiteInfos.isEmpty()) {
            ftySiteInfos.forEach(ftySiteInfo -> {
                Node node = new Node();
                node.setId(ftySiteInfo.getId());
                node.setName(ftySiteInfo.getName());
                node.setData(ftySiteInfo);
                buildArea(ftySiteInfo, node);

                children.add(node);
            });
        }

        enterprise.setChildren(children);
    }

    private void buildArea(FtySiteInfo ftySiteInfo, Node siteInfo) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("siteInfoId", ftySiteInfo.getId());
        List<FtyArea> ftyAreas = ftyAreaMapper.findByMap(params);
        List<Node> children = Lists.newArrayList();
        if (ftyAreas != null && !ftyAreas.isEmpty()) {
            ftyAreas.forEach(ftyArea -> {
                Node node = new Node();
                node.setId(ftyArea.getId());
                node.setName(ftyArea.getName());
                node.setData(ftyArea);
                buildProductionLine(ftyArea, node);

                children.add(node);
            });
        }

        siteInfo.setChildren(children);
    }

    private void buildProductionLine(FtyArea ftyArea, Node area) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("areaId", ftyArea.getId());
        List<FtyProductionLine> ftyProductionLines = ftyProductionLineMapper.findByMap(params);
        List<Node> children = Lists.newArrayList();
        if (ftyProductionLines != null && !ftyProductionLines.isEmpty()) {
            ftyProductionLines.forEach(ftyProductionLine -> {
                Node node = new Node();
                node.setId(ftyProductionLine.getId());
                node.setName(ftyProductionLine.getName());
                node.setData(ftyProductionLine);
//                buildProduction(ftyProductionLine, node);

                children.add(node);
            });
        }

        area.setChildren(children);
    }

    private void buildProduction(FtyProductionLine ftyProductionLine, Node productionLine) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("pdLineId", ftyProductionLine.getId());
        List<Pd> pds = pdMapper.findByMap(params);
        List<Node> children = Lists.newArrayList();
        if (pds != null && !pds.isEmpty()) {
            pds.forEach(pd -> {
                Node node = new Node();
                node.setId(pd.getId());
                node.setName(pd.getName());
                node.setData(pd);
//                buildProduction(pd, node);

                children.add(node);
            });
        }

        productionLine.setChildren(children);
    }
}
