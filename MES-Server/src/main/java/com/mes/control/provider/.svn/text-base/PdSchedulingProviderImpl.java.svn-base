package com.mes.control.provider;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.*;
import com.mes.dubbo.interprovider.control.IPdSchedulingProvider;
import com.mes.entity.control.*;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 产品管理-排班-人员
*/
public class PdSchedulingProviderImpl extends BaseProviderImpl<PdScheduling> implements IPdSchedulingProvider {
	@Autowired
	@Qualifier("pdSchedulingMapper")
	private PdSchedulingMapper pdSchedulingMapper;

	@Autowired
	@Qualifier("pdSchedulingPersonnelMapper")
	private PdSchedulingPersonnelMapper pdSchedulingPersonnelMapper;

	@Autowired
	@Qualifier("pdSchedulingDeviceMapper")
	private PdSchedulingDeviceMapper pdSchedulingDeviceMapper;

	@Override
	public PdSchedulingMapper getBaseInterfaceMapper() {
		return pdSchedulingMapper;
	}

	@Override
	public void saveScheduling(PdScheduling pdScheduling) {
		try{
			//生成id
			String id = pdScheduling.getId();
			if (StringUtils.isBlank(id)) {
				id = IDGenerator.getID();
				pdScheduling.setId(id);
			}
			pdScheduling.setCreateDate(new Date());
			//保存到mes_pd_scheduling
			pdSchedulingMapper.save(pdScheduling);

			//保存人员信息到mes_pd_scheduling_personnel
			if(pdScheduling.getUserIds() !=null && !pdScheduling.getUserIds().isEmpty()){
				String[] userIdArray = pdScheduling.getUserIds().split(",");
				for(String userId : userIdArray){
					PdSchedulingPersonnel pdSchedulingPersonnel = new PdSchedulingPersonnel();
					pdSchedulingPersonnel.setId(IDGenerator.getID());  //id
					pdSchedulingPersonnel.setUserGroupId(pdScheduling.getUserGroupId()); //user_group_id
					pdSchedulingPersonnel.setSchedulingId(pdScheduling.getId());        //scheduling_id
					pdSchedulingPersonnel.setCreateDate(pdScheduling.getCreateDate()); //create_date
					pdSchedulingPersonnel.setUserId(userId);   //user_Id
					pdSchedulingPersonnelMapper.save(pdSchedulingPersonnel);
				}
			}

			//保存设备信息到mes_pd_scheduling_device
			if(pdScheduling.getWorkstationIds()!= null && !pdScheduling.getWorkstationIds().isEmpty()){
				String[] workstationIdArray = pdScheduling.getWorkstationIds().split(",");
				for(String workstationId : workstationIdArray){
					PdSchedulingDevice pdSchedulingDevice = new PdSchedulingDevice();
					pdSchedulingDevice.setId(IDGenerator.getID());       //id
					pdSchedulingDevice.setSchedulingId(pdScheduling.getId());   //scheduling_id
					pdSchedulingDevice.setEnterpriseId(pdScheduling.getEnterpriseId());  //enterprise_id
					pdSchedulingDevice.setSiteId(pdScheduling.getSiteId());  //site_id
					pdSchedulingDevice.setAreaId(pdScheduling.getAreaId());  //area_id
					pdSchedulingDevice.setProductionLineId(pdScheduling.getProductionLineId());  //production_line_id
					pdSchedulingDevice.setWorkCenterId(pdScheduling.getWorkCenterId()); //work_center_id
					pdSchedulingDevice.setCreateDate(pdScheduling.getCreateDate());  //create_date
					pdSchedulingDevice.setWorkstationId(workstationId);   //workstation_id

					pdSchedulingDeviceMapper.save(pdSchedulingDevice);
				}
			}
		}catch (Exception e){
			log.error("PdSchedulingProciderImpl saveScheduling is error :",e);
		}
	}


	public void deleteScheduling(String ids){
		try{
			if(!StringUtils.isBlank(ids)){
				String[] idArray = ids.split(",");
				for(String id : idArray){
					//先删除相关的人员和设备信息
					Map<String,Object> map = Maps.newHashMap();
					map.put("schedulingId",id);
					List<PdSchedulingPersonnel> pdSchedulingPersonnelList = pdSchedulingPersonnelMapper.findByMap(map);
					for (PdSchedulingPersonnel pdSchedulingPersonnel: pdSchedulingPersonnelList ) {
						pdSchedulingPersonnelMapper.deleteById(pdSchedulingPersonnel.getId());
					}
					List<PdSchedulingDevice> pdSchedulingDeviceList = pdSchedulingDeviceMapper.findByMap(map);
					for (PdSchedulingDevice pdSchedulingDevice : pdSchedulingDeviceList){
						pdSchedulingDeviceMapper.deleteById(pdSchedulingDevice.getId());
					}
					//删除主表mes_pd_scheduling中数据
					this.getBaseInterfaceMapper().deleteById(id);
				}
			}
		}catch (Exception e){
			log.error("PdSchedulingProciderImpl deleteScheduling is error :",e);
		}
	}

	@Override
	public Page getSchedulingPage(Page page){
		Page pageResult = page;
		String jsonStr = JSON.toJSONString(page);
		try{
			Map<String, Object> mapBean = Maps.newHashMap();
			if (page != null) {
				if (page.getCondition() != null && Map.class.isInstance(page.getCondition())) {
					mapBean = (Map) page.getCondition();
				}
			}
			pageResult.setTotal(pdSchedulingMapper.getCount(mapBean));
			mapBean.put("startRowNum", page.getStartRowNum());
			mapBean.put("pageSize", page.getPageSize());
			List<PdScheduling> pdSchedulingList = this.pdSchedulingMapper.findByPage(mapBean);
			pdSchedulingList.forEach(pdScheduling -> {
				Map<String,Object> map = Maps.newHashMap();
				map.put("schedulingId",pdScheduling.getId());
				//查询人员列表
				List<PdSchedulingPersonnel> pdSchedulingPersonnelList = pdSchedulingPersonnelMapper.findByMap(map);
				List<String> userIdList = Lists.newArrayList();
				List<String> userNameList = Lists.newArrayList();
				String  userGroupId = "";
				String groupName = "";
				if(pdSchedulingPersonnelList != null){
					for(PdSchedulingPersonnel pdSchedulingPersonnel : pdSchedulingPersonnelList) {
						if(pdSchedulingPersonnel.getUserId()!=null && !pdSchedulingPersonnel.getUserId().isEmpty()){userIdList.add(pdSchedulingPersonnel.getUserId());}
						if (pdSchedulingPersonnel.getUserName() !=null && !pdSchedulingPersonnel.getUserName().isEmpty()){userNameList.add(pdSchedulingPersonnel.getUserName());}
						userGroupId = pdSchedulingPersonnel.getUserGroupId();
						groupName = pdSchedulingPersonnel.getGroupName();
					}
				}
				pdScheduling.setUserGroupId(userGroupId);
				pdScheduling.setGroupName(groupName);
				pdScheduling.setUserIds(Joiner.on(",").join(userIdList));
				pdScheduling.setUserNames(Joiner.on(",").join(userNameList));

				//查询workstations
				List<PdSchedulingDevice> pdSchedulingDeviceList = pdSchedulingDeviceMapper.findByMap(map);
				List<String> workstationIdList = Lists.newArrayList();
				List<String> workstationNameList = Lists.newArrayList();
				Map<String,String> map1 = Maps.newHashMap();
				if(pdSchedulingDeviceList != null){
					for(PdSchedulingDevice pdSchedulingDevice : pdSchedulingDeviceList){
						if(pdSchedulingDevice.getWorkstationId()!=null && !pdSchedulingDevice.getWorkstationId().isEmpty()){
						workstationIdList.add(pdSchedulingDevice.getWorkstationId());}
						if (pdSchedulingDevice.getWorkstationName()!=null && !pdSchedulingDevice.getWorkstationName().isEmpty()){
						workstationNameList.add(pdSchedulingDevice.getWorkstationName());}
						map1.put("enterpriseId",pdSchedulingDevice.getEnterpriseId());
						map1.put("enterpriseName",pdSchedulingDevice.getEnterpriseName());
						map1.put("siteId",pdSchedulingDevice.getSiteId());
						map1.put("siteName",pdSchedulingDevice.getSiteName());
						map1.put("areaId",pdSchedulingDevice.getAreaId());
						map1.put("areaName",pdSchedulingDevice.getAreaName());
						map1.put("productionLineId",pdSchedulingDevice.getProductionLineId());
						map1.put("productionLineName",pdSchedulingDevice.getProductionLineName());
						map1.put("workCenterId",pdSchedulingDevice.getWorkCenterId());
						map1.put("workCenterName",pdSchedulingDevice.getWorkCenterName());
					}
				}
				pdScheduling.setEnterpriseId(map1.get("enterpriseId"));
				pdScheduling.setEnterpriseName(map1.get("enterpriseName"));
				pdScheduling.setSiteId(map1.get("siteId"));
				pdScheduling.setSiteName(map1.get("siteName"));
				pdScheduling.setAreaId(map1.get("areaId"));
				pdScheduling.setAreaName(map1.get("areaName"));
				pdScheduling.setProductionLineId(map1.get("productionLineId"));
				pdScheduling.setProductionLineName(map1.get("productionLineName"));
				pdScheduling.setWorkCenterId(map1.get("workCenterId"));
				pdScheduling.setWorkCenterName(map1.get("workCenterName"));
				pdScheduling.setWorkstationIds(Joiner.on(",").join(workstationIdList));
				pdScheduling.setWorkstationNames(Joiner.on(",").join(workstationNameList));
			});
			pageResult.setRows(pdSchedulingList);

		}catch (Exception e){
			log.error("PdSchedulingProviderImpl getSchedulingPage is error :",e);
		}
		return pageResult;
	}


}
