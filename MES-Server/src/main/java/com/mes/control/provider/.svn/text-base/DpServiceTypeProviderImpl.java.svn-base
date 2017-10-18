package com.mes.control.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Node;
import com.mes.control.mapper.DpServiceMapper;
import com.mes.control.mapper.DpServiceTypeMapper;
import com.mes.dubbo.interprovider.control.IDpServiceTypeProvider;
import com.mes.entity.control.DpService;
import com.mes.entity.control.DpServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发平台-服务分类
*/
public class DpServiceTypeProviderImpl extends BaseProviderImpl<DpServiceType> implements IDpServiceTypeProvider {
	@Autowired
	@Qualifier("dpServiceTypeMapper")
	private DpServiceTypeMapper dpServiceTypeMapper;

	@Autowired
	@Qualifier("dpServiceMapper")
	private DpServiceMapper dpServiceMapper;

	@Override
	public DpServiceTypeMapper getBaseInterfaceMapper() {
		return dpServiceTypeMapper;
	}

	@Override
	public List<Node>findServiceTreeByServiceId(){

		List<Node> resultNode = Lists.newArrayList();
		List<DpServiceType> dpServiceTypeList = dpServiceTypeMapper.findAll();
		if(null != dpServiceTypeList && !dpServiceTypeList.isEmpty()){

			dpServiceTypeList.forEach(dpServiceTypes ->{
				Node node = new Node();
				node.setId(dpServiceTypes.getId());
				node.setName(dpServiceTypes.getName());
				resultNode.add(node);
				List<Node> children = Lists.newArrayList();
				Map<String ,Object>queryServiceMap = Maps.newHashMap();
				queryServiceMap.put("serviceTypeId",dpServiceTypes.getId());
				List<DpService>dpServiceList = dpServiceMapper.findByMap(queryServiceMap);
				if(null != dpServiceList && !dpServiceList.isEmpty()){
					dpServiceList.forEach(dpService -> {
						Node childNode = new Node();
						childNode.setParentId(dpService.getId());
						childNode.setName(dpService.getName());
						childNode.setId(dpService.getId());
						childNode.setDescription(dpService.getDescription());
						childNode.setLeaf(true);
						children.add(childNode);
					});
				   node.setChildren(children);
				}
			} );
		}
		return resultNode;
	}

	/**
	 * 验证分类下是否有数据
	 * @param id
	 * @return
	 * ledengyun--2017/09/22
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		List usage;
		Map map = new HashMap();
		boolean flag = true;
		map.put("serviceTypeId",id);
		usage = dpServiceMapper.findByMap(map);
		if(usage.size()>0) {
			flag = false;
		}
		return flag;
	}
}
