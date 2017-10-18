package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdOrder;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-产品订单管理
*/
public interface PdOrderMapper extends BaseInterfaceMapper<PdOrder> {
  /**
   * 根据产品Id分页查询订单列表统计条数
   * @param map
   * @return
   */
  public   int getCountByPdId(Map<String,Object>map);

  /**
   * 根据产品Id分页查询订单列表
   * @param map
   * @return
   */
  public   List<PdOrder> findByPdIdPage(Map<String,Object>map);
}
