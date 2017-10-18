package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpBoxProductInfo;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-包装箱-产品
 * Created by xiuyou.xu on 2017/7/4.
 */
public interface DpBoxProductInfoMapper extends BaseInterfaceMapper<DpBoxProductInfo> {

    public DpBoxProductInfo findByProIdAndBoxKey(String pdProductInfoId,String boxId);

    /**
     * 工作站分页显示获取总条数
     * @param map
     * @return
     */
    public Integer getProductBoxCount(Map<String, Object> map);

    /**
     * 工作站分页显示获取数据
     * @param map
     * @return
     */
    public List<DpBoxProductInfo> productBoxByPage(Map<String, Object> map);

    /**
     * g工作站拆并箱根据boxkey查询所有产品
     * @param map
     * @return
     */
    public List<DpBoxProductInfo> productBoxByAll(Map<String, Object> map);

}
