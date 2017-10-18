package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.PdSchedulingDeviceMapper;
import com.mes.dubbo.interprovider.control.IPdSchedulingDeviceProvider;
import com.mes.entity.control.PdSchedulingDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 产品管理--排班-设备
*/
public class PdSchedulingDeviceProviderImpl extends BaseProviderImpl<PdSchedulingDevice> implements IPdSchedulingDeviceProvider {
	@Autowired
	@Qualifier("pdSchedulingDeviceMapper")
	private PdSchedulingDeviceMapper pdSchedulingDeviceMapper;

	@Override
	public PdSchedulingDeviceMapper getBaseInterfaceMapper() {
		return pdSchedulingDeviceMapper;
	}

	@Override
	public void saveWorkstations(PdSchedulingDevice pdSchedulingDevice) {
		try{
			String workstationIds = pdSchedulingDevice.getWorkstationIds();
			if(!StringUtils.isBlank(workstationIds)){
				String[] workstationIdArray = workstationIds.split(",");
				for (String workstationId : workstationIdArray){
					PdSchedulingDevice p = new PdSchedulingDevice();
					p.setId(IDGenerator.getID());  //id
					p.setEnterpriseId(pdSchedulingDevice.getEnterpriseId());
					p.setSiteId(pdSchedulingDevice.getSiteId());
					p.setAreaId(pdSchedulingDevice.getAreaId());
					p.setProductionLineId(pdSchedulingDevice.getProductionLineId());
					p.setWorkCenterId(pdSchedulingDevice.getWorkCenterId());
					p.setWorkstationId(workstationId);
					p.setSchedulingId(pdSchedulingDevice.getSchedulingId());
					p.setCreateDate(new Date());
					pdSchedulingDeviceMapper.save(p);
				}
			}
		}catch (Exception e){
			log.error("PdSchedulingDeviceProviderImpl saveWorkstations is error :",e);
		}
	}

	@Override
	public List<PdSchedulingDevice> getRestWorkstation(Map<String, Object> map) {
		List<PdSchedulingDevice> pdSchedulingDeviceList = Lists.newArrayList();
		try{
			pdSchedulingDeviceList = pdSchedulingDeviceMapper.getRestWorkstation(map);
		}catch (Exception e){
			log.error("PdSchedulingDeviceProviderImpl getRestWorkstation is error :",e);
		}
		return pdSchedulingDeviceList;
	}
}
