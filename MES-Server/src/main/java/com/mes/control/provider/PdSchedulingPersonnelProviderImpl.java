package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.PdSchedulingPersonnelMapper;
import com.mes.dubbo.interprovider.control.IPdSchedulingPersonnelProvider;
import com.mes.entity.control.PdSchedulingPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 排班管理-班次人员
*/
public class PdSchedulingPersonnelProviderImpl extends BaseProviderImpl<PdSchedulingPersonnel> implements IPdSchedulingPersonnelProvider {
	@Autowired
	@Qualifier("pdSchedulingPersonnelMapper")
	private PdSchedulingPersonnelMapper pdSchedulingPersonnelMapper;

	@Override
	public PdSchedulingPersonnelMapper getBaseInterfaceMapper() {
		return pdSchedulingPersonnelMapper;
	}

	@Override
	public void savePersonnels(PdSchedulingPersonnel pdSchedulingPersonnel) {
		try{
			String userIds = pdSchedulingPersonnel.getUserIds();
			if (!StringUtils.isBlank(userIds)){
				String[] userIdArray = userIds.split(",");
				for (String userId : userIdArray){
					PdSchedulingPersonnel p = new PdSchedulingPersonnel();
					p.setId(IDGenerator.getID());  //id
					p.setUserId(userId);   //user_id
					p.setUserGroupId(pdSchedulingPersonnel.getUserGroupId()); //user_group_id
					p.setSchedulingId(pdSchedulingPersonnel.getSchedulingId()); //scheduling_id
					p.setCreateDate(new Date()); //create_date
					pdSchedulingPersonnelMapper.save(p);
				}
			}

		}catch (Exception e){
			log.error("PdSchedulingPersonnelProviderImpl savePersonnels is error ;" ,e);
		}

	}

	@Override
	public List<PdSchedulingPersonnel> getRestUser(Map<String, Object> map) {
		List<PdSchedulingPersonnel> pdSchedulingPersonnelList = Lists.newArrayList();
		try{
			pdSchedulingPersonnelList = pdSchedulingPersonnelMapper.getRestUser(map);
		}catch (Exception e){
			log.error("PdSchedulingPersonnelProviderImpl getRestUser is error :",e);
		}
		return pdSchedulingPersonnelList;
	}
}
