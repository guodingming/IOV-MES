package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Page;
import com.mes.control.mapper.PdOrderMapper;
import com.mes.dubbo.interprovider.control.IPdOrderProvider;
import com.mes.entity.control.PdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * 产品管理-产品订单管理
*/
public class PdOrderProviderImpl extends BaseProviderImpl<PdOrder> implements IPdOrderProvider {
	@Autowired
	@Qualifier("pdOrderMapper")
	private PdOrderMapper pdOrderMapper;

	@Override
	public PdOrderMapper getBaseInterfaceMapper() {
		return pdOrderMapper;
	}

	/**
	 * 根据产品Id分页查询订单列表
	 * @param page
	 * @return
	 * @throws DubboProviderException
	 */
	@Override
	public Page findByPdId(Page page) throws DubboProviderException {
		Map<String, Object> params = Maps.newHashMap();
		if (page != null && page.getCondition() != null) {
			if (Map.class.isInstance(page.getCondition())) {
				params = (Map<String, Object>) page.getCondition();
			}
		}
		try {
		page.setTotal(this.getBaseInterfaceMapper().getCountByPdId(params));
		params.put("startRowNum", page.getStartRowNum());
		params.put("pageSize", page.getPageSize());
		page.setRows(this.getBaseInterfaceMapper().findByPdIdPage(params));
		} catch (Exception e) {

			log.error("PdOrderProviderImpl findByPdId ", e);
			throw new DubboProviderException(e.getMessage(), e);
		}
		return page;
	}
}
