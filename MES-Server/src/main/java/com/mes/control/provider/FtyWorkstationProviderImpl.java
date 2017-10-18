package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.FtyWorkstationDeviceMapper;
import com.mes.control.mapper.FtyWorkstationMapper;
import com.mes.dubbo.interprovider.control.IFtyWorkstationProvider;
import com.mes.entity.control.FtyWorkstation;
import com.mes.entity.control.FtyWorkstationDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.List;
import java.util.Map;

public class FtyWorkstationProviderImpl extends BaseProviderImpl<FtyWorkstation> implements IFtyWorkstationProvider {
	@Autowired
	@Qualifier("ftyWorkstationMapper")
	private FtyWorkstationMapper ftyWorkstationMapper;

	@Autowired
	@Qualifier("ftyWorkstationDeviceMapper")
	private FtyWorkstationDeviceMapper ftyWorkstationDeviceMapper;

	@Override
	public FtyWorkstationMapper getBaseInterfaceMapper() {
		return ftyWorkstationMapper;
	}
    /**
     * @Author jinlong.zhu
     * @Date 2017/8/1 16:12
     * 新建工作站及设备-工作站信息
     */
	@Override
	public void saveWorkStationAndDevicesInfo(FtyWorkstation ftyWorkstation){
		try{
			//保存工作站信息
			String workStationId = ftyWorkstation.getId();
			if(null == workStationId ||workStationId.isEmpty()){
				workStationId = IDGenerator.getID();
				ftyWorkstation.setId(workStationId);
			}
			this.ftyWorkstationMapper.save(ftyWorkstation);
			//保存设备-工作站信息
			String deviceIds  = ftyWorkstation.getDeviceIds();
			if (!StringUtils.isBlank(deviceIds)) {
				String[] idArray = deviceIds.split(",");
				for (String id : idArray) {
					FtyWorkstationDevice ftyWorkstationDevice = new FtyWorkstationDevice();
					ftyWorkstationDevice.setWorkstationId(workStationId);
					ftyWorkstationDevice.setDeviceId(id);
					ftyWorkstationDevice.setId(IDGenerator.getID());
					this.ftyWorkstationDeviceMapper.save(ftyWorkstationDevice);
				}
			}
		} catch (Exception e) {
			log.error("FtyWorkStationProvider save is error :" + e.getMessage(), e);
		}
	}
   /**
    * @Author jinlong.zhu
    * @Date 2017/8/1 16:12
    * 更新工作站及设备-工作站信息
    */
	@Override
	public void updateWorkStationAndDevicesInfo(FtyWorkstation ftyWorkstation){
		try{
			//更新工作站信息
			this.ftyWorkstationMapper.update(ftyWorkstation);
			String workStationId = ftyWorkstation.getId();
			//更新设备-工作站信息
			Map<String,Object> query = Maps.newHashMap();
			query.put("workstationId", workStationId);
			List<FtyWorkstationDevice> ftyWorkstationDevices = this.ftyWorkstationDeviceMapper.findByMap(query);
			ftyWorkstationDevices.forEach(ftyWorkstationDevice->{
				this.ftyWorkstationDeviceMapper.deleteById(ftyWorkstationDevice.getId());
			});
			String deviceIds  = ftyWorkstation.getDeviceIds();
			if (!StringUtils.isBlank(deviceIds)) {
				String[] idArray = deviceIds.split(",");
				for (String id : idArray) {
					FtyWorkstationDevice ftyWorkstationDevice = new FtyWorkstationDevice();
					ftyWorkstationDevice.setWorkstationId(workStationId);
					ftyWorkstationDevice.setDeviceId(id);
					ftyWorkstationDevice.setId(IDGenerator.getID());
					this.ftyWorkstationDeviceMapper.save(ftyWorkstationDevice);
				}
			}
		} catch (Exception e) {
			log.error("FtyWorkStationProvider save is error :" + e.getMessage(), e);
		}
	}
}
