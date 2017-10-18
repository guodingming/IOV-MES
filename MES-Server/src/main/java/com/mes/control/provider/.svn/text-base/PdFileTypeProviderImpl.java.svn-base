package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdFileTypeMapper;
import com.mes.dubbo.interprovider.control.IPdFileTypeProvider;
import com.mes.entity.control.PdFileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * 文件分类管理
*/
public class PdFileTypeProviderImpl extends BaseProviderImpl<PdFileType> implements IPdFileTypeProvider {
	@Autowired
	@Qualifier("pdFileTypeMapper")
	private PdFileTypeMapper pdFileTypeMapper;

	@Override
	public PdFileTypeMapper getBaseInterfaceMapper() {
		return pdFileTypeMapper;
	}

	/**
	 * 查询文件类别树
	 * @param type
	 * @return
	 * @throws DubboProviderException
	 */
	@Override
	public List<PdFileType> findByType(String type)throws DubboProviderException{
		List<PdFileType>list = null;
		list = pdFileTypeMapper.findByType(type);
		if(list.size()>0) {
			return list;
		}else {
			log.error("该分类不存在，请检查传入的值！");
			return null;
		}

	}

	/**
	 * 分类删除验证
	 * @param id
	 * @return
	 * lednegyun--2017/10/10
	 * @throws DubboProviderException
	 */
	public boolean check(String id)throws DubboProviderException{
		int usage;
		boolean flag = true;
		usage = pdFileTypeMapper.countUsage(id);
		if(usage>0){
			flag = false;
		}
		return flag;

	}
}
