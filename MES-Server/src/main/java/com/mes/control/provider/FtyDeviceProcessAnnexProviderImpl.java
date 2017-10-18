package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.FtyDeviceProcessAnnexAssociationMapper;
import com.mes.control.mapper.FtyDeviceProcessAnnexMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessAnnexProvider;
import com.mes.entity.control.FtyDeviceProcessAnnex;
import com.mes.entity.control.FtyDeviceProcessAnnexAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FtyDeviceProcessAnnexProviderImpl extends BaseProviderImpl<FtyDeviceProcessAnnex> implements IFtyDeviceProcessAnnexProvider {
    @Autowired
    @Qualifier("ftyDeviceProcessAnnexMapper")
    private FtyDeviceProcessAnnexMapper ftyDeviceProcessAnnexMapper;

    @Autowired
    @Qualifier("ftyDeviceProcessAnnexAssociationMapper")
    private FtyDeviceProcessAnnexAssociationMapper ftyDeviceProcessAnnexAssociationMapper;

    @Override
    public FtyDeviceProcessAnnexMapper getBaseInterfaceMapper() {
        return ftyDeviceProcessAnnexMapper;
    }

    /**
     * @Author jinlong.zhu
     * @Date 2017/8/2 20:00
     * 保存设备-工序-附件及从表
     */
    @Override
    public boolean saveFtyDeviceProcessAnnex(FtyDeviceProcessAnnex ftyDeviceProcessAnnex) throws DubboProviderException {
        String ftyDeviceProcessAnnexId = null;
        boolean flag = true;
        int count = 0;
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("deviceId",ftyDeviceProcessAnnex.getDeviceId());
            map.put("deviceProcessId",ftyDeviceProcessAnnex.getDeviceProcessId());
            map.put("deviceAnnexId",ftyDeviceProcessAnnex.getDeviceAnnexId());
            List<FtyDeviceProcessAnnex> list = ftyDeviceProcessAnnexMapper.findByMap(map);
            if(list.size()<=0){
                ftyDeviceProcessAnnexId = IDGenerator.getID();
                if (null != ftyDeviceProcessAnnex) {
                    if (null == ftyDeviceProcessAnnex.getId()) {
                        ftyDeviceProcessAnnex.setId(ftyDeviceProcessAnnexId);
                    }
                    ftyDeviceProcessAnnex.setCreateDate(new Date());
                    this.ftyDeviceProcessAnnexMapper.save(ftyDeviceProcessAnnex);
                }
            }else {
                ftyDeviceProcessAnnexId = list.get(0).getId();
            }
            List<String> deviceAnnexInfoIds = ftyDeviceProcessAnnex.getDeviceAnnexInfoIds();
            if (null != deviceAnnexInfoIds) {
                //save mes_fty_device_process_annex_association
                for (String deviceAnnexInfoId : deviceAnnexInfoIds) {
                    Map map1 = new HashMap();
                    map1.put("deviceProcessAnnexId",ftyDeviceProcessAnnexId);
                    map1.put("deviceAnnexInfoId",deviceAnnexInfoId);
                    List<FtyDeviceProcessAnnexAssociation> list1 = ftyDeviceProcessAnnexAssociationMapper.findByMap(map1);
                    if(list1.size()<=0) {
                        FtyDeviceProcessAnnexAssociation ftyDeviceProcessAnnexAssociation = new FtyDeviceProcessAnnexAssociation();
                        ftyDeviceProcessAnnexAssociation.setId(IDGenerator.getID());
                        ftyDeviceProcessAnnexAssociation.setCreateDate(new Date());
                        ftyDeviceProcessAnnexAssociation.setDeviceProcessAnnexId(ftyDeviceProcessAnnexId);
                        ftyDeviceProcessAnnexAssociation.setDeviceAnnexInfoId(deviceAnnexInfoId);
                        this.ftyDeviceProcessAnnexAssociationMapper.save(ftyDeviceProcessAnnexAssociation);
                    }else {
                        count++;
                        log.error("请不要重复添加");
                    }
                }
                if(count>0){
                    flag = false;
                }
            }
        } catch (Exception e) {
            flag = false;
            log.error("FtyDeviceProcessAnnexProvider save is error :" + e.getMessage(), e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * @Author jinlong.zhu
     * @Date 2017/8/2 20:00
     * 保更新设备-工序-附件及从表
     */
    @Override
    public void updateFtyDeviceProcessAnnex(FtyDeviceProcessAnnex ftyDeviceProcessAnnex) throws DubboProviderException {
        try {
            if (null != ftyDeviceProcessAnnex) {
                this.ftyDeviceProcessAnnexMapper.update(ftyDeviceProcessAnnex);
            }
            List<String> deviceAnnexInfoIds = ftyDeviceProcessAnnex.getDeviceAnnexInfoIds();
            String deviceProcessAnnexId = ftyDeviceProcessAnnex.getId();
            //先查找，如果存在就删除；
            Map<String, Object> query = Maps.newHashMap();
            query.put("deviceProcessAnnexId", deviceProcessAnnexId);
            List<FtyDeviceProcessAnnexAssociation> ftyDeviceProcessAnnexAssociationList = this.ftyDeviceProcessAnnexAssociationMapper.findByMap(query);
            if (ftyDeviceProcessAnnexAssociationList != null && !ftyDeviceProcessAnnexAssociationList.isEmpty()) {
                for (FtyDeviceProcessAnnexAssociation ftyDeviceProcessAnnexAssociation1 : ftyDeviceProcessAnnexAssociationList) {
                    this.ftyDeviceProcessAnnexAssociationMapper.deleteById(ftyDeviceProcessAnnexAssociation1.getId());
                }
            }
            if (null != deviceAnnexInfoIds && null != deviceProcessAnnexId) {
                //save mes_fty_device_process_annex_association
                for (String deviceAnnexInfoId : deviceAnnexInfoIds) {
                    FtyDeviceProcessAnnexAssociation ftyDeviceProcessAnnexAssociation = new FtyDeviceProcessAnnexAssociation();
                    ftyDeviceProcessAnnexAssociation.setId(IDGenerator.getID());
                    ftyDeviceProcessAnnexAssociation.setDeviceProcessAnnexId(deviceProcessAnnexId);
                    ftyDeviceProcessAnnexAssociation.setDeviceAnnexInfoId(deviceAnnexInfoId);
                    this.ftyDeviceProcessAnnexAssociationMapper.save(ftyDeviceProcessAnnexAssociation);
                }
            }
        } catch (Exception e) {
            log.error("FtyDeviceProcessAnnexProvider save is error :" + e.getMessage(), e);
            throw new DubboProviderException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> getDeviceAnnexInfo(String deviceId, String annexTypeName, String produceProcessId) throws DubboProviderException {
        return ftyDeviceProcessAnnexMapper.getDeviceAnnexInfo(deviceId, annexTypeName, produceProcessId);
    }

    @Override
    public List<FtyDeviceProcessAnnex> findAnnexByDeviceProcessId(Map<String, Object> query) throws DubboProviderException {
        List<FtyDeviceProcessAnnex> deviceProcessAnnexList = Lists.newArrayList();
        try {
            deviceProcessAnnexList = this.ftyDeviceProcessAnnexMapper.findAnnexByDeviceProcessId(query);
        } catch (Exception e) {
            log.error("FtyDeviceProcessAnnexProvider findAnnexByDeviceProcessId is error");
            throw new DubboProviderException(e.getMessage(), e);
        }
        return deviceProcessAnnexList;
    }


}
