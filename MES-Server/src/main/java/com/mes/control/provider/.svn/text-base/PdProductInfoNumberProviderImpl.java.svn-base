package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;

import com.mes.control.mapper.DpProductInfoLogMapper;
import com.mes.control.mapper.PdProductInfoMapper;
import com.mes.control.mapper.PdProductInfoNumberMapper;
import com.mes.dubbo.interprovider.control.IPdProductInfoNumberProvider;
import com.mes.entity.control.DpProductInfoLog;
import com.mes.entity.control.PdProductInfo;
import com.mes.entity.control.PdProductInfoNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品明细-产品编码
*/
public class PdProductInfoNumberProviderImpl extends BaseProviderImpl<PdProductInfoNumber> implements IPdProductInfoNumberProvider {
	@Autowired
	@Qualifier("pdProductInfoNumberMapper")
	private PdProductInfoNumberMapper pdProductInfoNumberMapper;
	@Autowired
	@Qualifier("dpProductInfoLogMapper")
	private DpProductInfoLogMapper dpProductInfoLogMapper;
	@Autowired
	@Qualifier("pdProductInfoMapper")
	private PdProductInfoMapper pdProductInfoMapper;

	@Override
	public PdProductInfoNumberMapper getBaseInterfaceMapper() {
		return pdProductInfoNumberMapper;
	}

	public PdProductInfoNumber findByNumber(String number)throws DubboProviderException{
		PdProductInfoNumber pdProductInfoNumber =  pdProductInfoNumberMapper.findByNumber(number);
		return  pdProductInfoNumber;
	}

	/**
	 * 根据条码获取产品信息
	 * @param number
	 * @return
	 * ledengyun--2017/09/06
	 * @throws DubboProviderException
	 */
	public List<DpProductInfoLog> getProductInfo(String number,String produceProcessId) throws DubboProviderException{
		String pdProductInfoId = null;
		List dpProductInfoLog = null;
		PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberMapper.findByNumber(number);
		if(pdProductInfoNumber !=null){
			pdProductInfoId=pdProductInfoNumber.getPdProductInfoId();
		}
		Map map = new HashMap<>();
		map.put("pdProductInfoId",pdProductInfoId);
		map.put("produceProcessId",produceProcessId);
		dpProductInfoLog = dpProductInfoLogMapper.findByMap(map);
		return dpProductInfoLog;

	}

	/**
	 * 查询PCBA信息
	 *
	 * @param number
	 * @return
	 * @throws DubboProviderException
	 */
	public Map<String, Object> getPCBAInfo(String number)throws DubboProviderException{
		Map<String, Object> result = Maps.newHashMap();
		PdProductInfoNumber pdProductInfoNumber = pdProductInfoNumberMapper.findByNumber(number);
		if (null != pdProductInfoNumber) {
			String pdProductInfoId = pdProductInfoNumber.getPdProductInfoId();
			PdProductInfo pdProductInfo=pdProductInfoMapper.findById(pdProductInfoId);
			result.put("status",pdProductInfo.getStatus());
			result.put("pdProductInfoId", pdProductInfoId);
			Map<String, Object> query = Maps.newHashMap();
			query.put("pdProductInfoId",pdProductInfoNumber.getPdProductInfoId());
			query.put("type","SN");
			List<PdProductInfoNumber> list = pdProductInfoNumberMapper.findByMap(query);
			if (!list.isEmpty()) {
				String pdNum = list.get(0).getNumber();
				result.put("SN",pdNum);
			}
		}
		return result;
	}
}
