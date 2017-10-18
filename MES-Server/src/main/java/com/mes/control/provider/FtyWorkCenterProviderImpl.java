package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.control.mapper.FtyAreaMapper;
import com.mes.control.mapper.FtyProductionLineMapper;
import com.mes.control.mapper.FtyWorkCenterMapper;
import com.mes.control.mapper.FtyWorkstationMapper;
import com.mes.dubbo.interprovider.control.IFtyWorkCenterProvider;
import com.mes.entity.control.FtyProductionLine;
import com.mes.entity.control.FtyWorkCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.mes.entity.control.FtyArea;

import java.util.List;
import java.util.Map;

public class FtyWorkCenterProviderImpl extends BaseProviderImpl<FtyWorkCenter> implements IFtyWorkCenterProvider {
    @Autowired
    @Qualifier("ftyWorkCenterMapper")
    private FtyWorkCenterMapper ftyWorkCenterMapper;

    @Override
    public FtyWorkCenterMapper getBaseInterfaceMapper() {
        return ftyWorkCenterMapper;
    }


    @Autowired
    @Qualifier("ftyProductionLineMapper")
    private FtyProductionLineMapper ftyProductionLineMapper;

    @Autowired
    @Qualifier("ftyWorkstationMapper")
    private FtyWorkstationMapper ftyWorkstationMapper;

    @Autowired
    @Qualifier("ftyAreaMapper")
    private FtyAreaMapper ftyAreaMapper;

    /*
    * @Author jinlong.zhu
    * @Date 2017/7/19 13:35
    * 根据车间ID获取产线及其下属工作中心
    */
    @Override
    public List<Node> getAreaProductionLineTree(String areaId) {
        List<Node> resultListNode = Lists.newArrayList();
        try {
            if (areaId != null && !areaId.isEmpty()) {
                Map<String, Object> mapQueryLine = Maps.newHashMap();
                mapQueryLine.put("areaId", areaId);
                //获取车间下的产线及产线下属工作中心
                List<FtyProductionLine> ftyProductionLinesLists = ftyProductionLineMapper.findByMap(mapQueryLine);
                if (ftyProductionLinesLists != null && !ftyProductionLinesLists.isEmpty()) {
                    ftyProductionLinesLists.forEach(ftyProductionLine -> {
                        //获取产线下的工作中心
                        Map<String, Object> mapQueryWorkCenter = Maps.newHashMap();
                        mapQueryWorkCenter.put("productionLineId", ftyProductionLine.getId());
                        List<FtyWorkCenter> ftyWorkCenterList = ftyWorkCenterMapper.findByMap(mapQueryWorkCenter);
                        if (ftyWorkCenterList != null && ftyWorkCenterList.size() > 0) {
                            Node node = new Node();
                            node.setId(ftyProductionLine.getId());
                            node.setName(ftyProductionLine.getName());
                            node.setDescription(ftyProductionLine.getDescription());
                            resultListNode.add(node);
                            List<Node> children = Lists.newArrayList();
                            ftyWorkCenterList.forEach(ftyWorkCenter -> {
                                Node childNode = new Node();
                                childNode.setParentId(ftyProductionLine.getId());
                                childNode.setName(ftyWorkCenter.getName());
                                childNode.setId(ftyWorkCenter.getId());
                                childNode.setDescription(ftyWorkCenter.getDescription());
                                childNode.setLeaf(true);
                                children.add(childNode);
                            });
                            node.setChildren(children);
                        }


                    });
                }
            } else {
                List<FtyArea> ftyAreaList = ftyAreaMapper.findAll();
                if (ftyAreaList != null && !ftyAreaList.isEmpty()) {
                    ftyAreaList.forEach(ftyArea -> {
                        Map<String, Object> queryProductionLine = Maps.newHashMap();
                        queryProductionLine.put("areaId", ftyArea.getId());
                        //根据车间Id获取产线信息
                        List<FtyProductionLine> ftyProductionLineList = ftyProductionLineMapper.findByMap(queryProductionLine);
                        if (ftyProductionLineList != null && ftyProductionLineList.size() > 0) {
                            ftyProductionLineList.forEach(ftyProductionLine -> {
                                //获取产线下的工作中心
                                Map<String, Object> mapQueryWorkCenter = Maps.newHashMap();
                                mapQueryWorkCenter.put("productionLineId", ftyProductionLine.getId());
                                //根据产线ID获取工作中心
                                List<FtyWorkCenter> ftyWorkCenterList = ftyWorkCenterMapper.findByMap(mapQueryWorkCenter);
                                if (ftyWorkCenterList != null && ftyWorkCenterList.size() > 0) {
                                    Node node = new Node();
                                    node.setId(ftyProductionLine.getId());
                                    node.setName(ftyProductionLine.getName());
                                    node.setDescription(ftyProductionLine.getDescription());
                                    resultListNode.add(node);
                                    List<Node> children = Lists.newArrayList();
                                    ftyWorkCenterList.forEach(ftyWorkCenter -> {
                                        Node childNode = new Node();
                                        childNode.setParentId(ftyProductionLine.getId());
                                        childNode.setName(ftyWorkCenter.getName());
                                        childNode.setId(ftyWorkCenter.getId());
                                        childNode.setDescription(ftyWorkCenter.getDescription());
                                        childNode.setLeaf(true);
                                        children.add(childNode);
                                    });
                                    node.setChildren(children);
                                }
                            });
                        }
                    });
                }
            }
        } catch (Exception e) {
            log.error("SQL execute Failed :", e);
        }
        return resultListNode;
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
        usage = ftyWorkCenterMapper.countUsage(id);
        if(usage>0){
            flag = false;
        }
        return flag;
    }

}
