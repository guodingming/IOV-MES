package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.control.mapper.*;
import com.mes.dubbo.interprovider.control.IDpProduceProcessAnnexProvider;
import com.mes.entity.control.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-生产工序-工装配置信息
 * Created by xiuyou.xu on 2017/09/22.
 */
public class DpProduceProcessAnnexProviderImpl extends BaseProviderImpl<DpProduceProcessAnnex> implements IDpProduceProcessAnnexProvider {
    private static Logger logger = LoggerFactory.getLogger(DpProduceProcessAnnexProviderImpl.class);

    @Autowired
    @Qualifier("dpProduceProcessAnnexMapper")
    private DpProduceProcessAnnexMapper dpProduceProcessAnnexMapper;

    @Autowired
    @Qualifier("ftyDeviceProcessMapper")
    private FtyDeviceProcessMapper ftyDeviceProcessMapper;

    @Autowired
    @Qualifier("ftyDeviceProcessAnnexMapper")
    private FtyDeviceProcessAnnexMapper ftyDeviceProcessAnnexMapper;

    @Autowired
    @Qualifier("ftyDeviceAnnexMapper")
    private FtyDeviceAnnexMapper ftyDeviceAnnexMapper;

    @Autowired
    @Qualifier("ftyDeviceProcessAnnexAssociationMapper")
    private FtyDeviceProcessAnnexAssociationMapper ftyDeviceProcessAnnexAssociationMapper;

    @Autowired
    @Qualifier("ftyDeviceAnnexInfoMapper")
    private FtyDeviceAnnexInfoMapper ftyDeviceAnnexInfoMapper;

    @Autowired
    @Qualifier("dpProduceProcessMapper")
    private DpProduceProcessMapper dpProduceProcessMapper;

    @Override
    public DpProduceProcessAnnexMapper getBaseInterfaceMapper() {
        return dpProduceProcessAnnexMapper;
    }

    @Override
    public String save(DpProduceProcessAnnex entity) throws DubboProviderException {
        FtyDeviceProcessAnnexAssociation ftyDeviceProcessAnnexAssociation = this.ftyDeviceProcessAnnexAssociationMapper.findById(entity.getDeviceProcessAnnexAssociationId());
        FtyDeviceAnnexInfo ftyDeviceAnnexInfo = this.ftyDeviceAnnexInfoMapper.findById(ftyDeviceProcessAnnexAssociation.getDeviceAnnexInfoId());
        Map<String, Object> query = Maps.newHashMap();
        query.put("deviceAnnexInfoId", entity.getDeviceAnnexInfoId());
        query.put("deviceProcessAnnexAssociationId", entity.getDeviceProcessAnnexAssociationId());
        query.put("deviceAnnexInfoId", ftyDeviceAnnexInfo.getId());
        query.put("produceProcessId", entity.getProduceProcessId());
        List<DpProduceProcessAnnex> dpProduceProcessAnnexList = this.findByMap(query);
        if (dpProduceProcessAnnexList.isEmpty()) {
            entity.setName(ftyDeviceAnnexInfo.getName());
            entity.setNumber(ftyDeviceAnnexInfo.getNumber());
            entity.setDeviceAnnexInfoId(ftyDeviceAnnexInfo.getId());
            return super.save(entity);
        } else {
            return "exist";
        }

    }

    @Override
    public List<Node> processDeviceAnnexInfo(String produceProcessId) throws DubboProviderException {
        List<Node> nodeList = Lists.newArrayList();
        try {
            DpProduceProcess produceProcess = this.dpProduceProcessMapper.findById(produceProcessId);
            Map<String, Object> query = Maps.newHashMap();
            query.put("processId", produceProcess.getProcessId());
            //1.根据工序查询设备信息
            List<FtyDeviceProcess> ftyDeviceProcessList = this.ftyDeviceProcessMapper.findByMap(query);
            for (FtyDeviceProcess ftyDeviceProcess : ftyDeviceProcessList) {
                Node deviceProcess = new Node();
                deviceProcess.setName(ftyDeviceProcess.getDeviceName());
                deviceProcess.setId(ftyDeviceProcess.getId());
                deviceProcess.setData(ftyDeviceProcess);
                //2.根据工序设备信息查询附件分类信息
                query.clear();
                query.put("deviceProcessId", ftyDeviceProcess.getId());
                List<Node> deviceProcessChilds = Lists.newArrayList();
//                List<FtyDeviceProcessAnnex> ftyDeviceProcessAnnexList = this.ftyDeviceProcessAnnexMapper.findAnnexByDeviceProcessId(query);
                List<FtyDeviceProcessAnnex> annexTypeList = this.ftyDeviceProcessAnnexMapper.findAnnexTypeByDeviceProcessId(query);
                for (FtyDeviceProcessAnnex ftyDeviceProcessAnnex : annexTypeList) {
                    FtyDeviceAnnex ftyDeviceAnnex = this.ftyDeviceAnnexMapper.findById(ftyDeviceProcessAnnex.getDeviceAnnexId());
                    Node deviceAnnex = new Node();
                    deviceAnnex.setName(ftyDeviceAnnex.getName());
                    deviceAnnex.setData(ftyDeviceAnnex);
                    deviceAnnex.setId(ftyDeviceAnnex.getId());
                    List<Node> deviceAnnexChilds = Lists.newArrayList();
                    //3.根据设备工序信息和附件分类信息查询附件信息
                    query.clear();
                    query.put("deviceProcessAnnexId", ftyDeviceProcessAnnex.getId());
                    List<FtyDeviceProcessAnnexAssociation> ftyDeviceProcessAnnexAssociationList = this.ftyDeviceProcessAnnexAssociationMapper.findByMap(query);
                    for (FtyDeviceProcessAnnexAssociation ftyDeviceProcessAnnexAssociation : ftyDeviceProcessAnnexAssociationList) {
                        FtyDeviceAnnexInfo ftyDeviceAnnexInfo = this.ftyDeviceAnnexInfoMapper.findById(ftyDeviceProcessAnnexAssociation.getDeviceAnnexInfoId());
                        Node deviceAnnexInfo = new Node();
                        deviceAnnexInfo.setName(ftyDeviceAnnexInfo.getName());
                        deviceAnnexInfo.setId(ftyDeviceProcessAnnexAssociation.getId());
                        deviceAnnexInfo.setData(ftyDeviceProcessAnnexAssociation);
                        deviceAnnexChilds.add(deviceAnnexInfo);
                    }
                    deviceAnnex.setChildren(deviceAnnexChilds);
                    deviceProcessChilds.add(deviceAnnex);
                }
                deviceProcess.setChildren(deviceProcessChilds);
                nodeList.add(deviceProcess);
            }
        } catch (Exception e) {
            throw new DubboProviderException(e.getMessage(), e);
        }
        return nodeList;
    }
}
