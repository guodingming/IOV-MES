package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.IDGenerator;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.FtyDeviceProcessMapper;
import com.mes.dubbo.interprovider.control.IFtyDeviceProcessProvider;
import com.mes.entity.control.FtyDeviceProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

public class FtyDeviceProcessProviderImpl extends BaseProviderImpl<FtyDeviceProcess> implements IFtyDeviceProcessProvider {
	@Autowired
	@Qualifier("ftyDeviceProcessMapper")
	private FtyDeviceProcessMapper ftyDeviceProcessMapper;

	@Override
	public FtyDeviceProcessMapper getBaseInterfaceMapper() {
		return ftyDeviceProcessMapper;
	}


	/**
	 * 保存deviceId 、processIds
	 * @param ftyDeviceProcess
	 */
	@Override
	public void saveFtyDeviceProcessByIds(FtyDeviceProcess ftyDeviceProcess)throws DubboProviderException {
		try{
			String deviceId = ftyDeviceProcess.getDeviceId();
			List<String> processIds = ftyDeviceProcess.getProcessIds();
			if (null != processIds && null != deviceId) {

				Map<String,Object>query = Maps.newHashMap();
				query.put("deviceId",deviceId);
				List<FtyDeviceProcess> ftyDeviceProcessList = this.ftyDeviceProcessMapper.findByMap(query);
				for(String processId:processIds){
					boolean flag = false;
					for(FtyDeviceProcess ftyDeviceProcess1:ftyDeviceProcessList){
						if(processId.equalsIgnoreCase(ftyDeviceProcess1.getProcessId())){
							flag = true ;
						}
					}
					if (!flag) {
						FtyDeviceProcess ftyDevice = new FtyDeviceProcess();
						ftyDevice.setDeviceId(deviceId);
						ftyDevice.setProcessId(processId);
						ftyDevice.setId(IDGenerator.getID());
						this.ftyDeviceProcessMapper.save(ftyDevice);
					}
				}
				List<FtyDeviceProcess> ftyDeviceProcesses = this.ftyDeviceProcessMapper.findByMap(query);
				for(FtyDeviceProcess ftyDeviceProcess1:ftyDeviceProcesses){
					boolean flag = true;
					for(String processId:processIds){
						if(processId.equalsIgnoreCase(ftyDeviceProcess1.getProcessId())){
							flag = false ;
						}
					}
					if (flag) {
						this.ftyDeviceProcessMapper.deleteById(ftyDeviceProcess1.getId());
					}
				}
			}
		}catch(Exception e){
			log.error("FtyDeviceProcessProvider save is error :" + e.getMessage(), e);
			throw new DubboProviderException(e.getMessage(), e);
		}

	}
}
