package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpProductInfoLog;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-产品生产工序记录
*/
public interface DpProductInfoLogMapper extends BaseInterfaceMapper<DpProductInfoLog> {

    /**
     * 查询指定产品的每道工序执行的最新信息
     * @param pdProductInfoId
     * @return
     */
    public List<DpProductInfoLog> findProcessLastResultInfo(String pdProductInfoId);

    /**
     * 根据产品和生产工序信息查询指定工序最新执行结果
     *
     * @param query
     * @return
     */
    public DpProductInfoLog findProcessRecentResultInfo(Map<String, Object> query);

    /**
     * 查询指定产品最新的工序日志
     *
     * @param pdProductInfoId
     * @return
     */
    public DpProductInfoLog findProductRecentInfo(String pdProductInfoId);

}
