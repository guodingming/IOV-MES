package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpRepairStation;

import java.util.List;

/**
 * 开发平台-产品维修站
 * Created by xiuyou.xu on 2017/08/25.
 */
public interface DpRepairStationMapper extends BaseInterfaceMapper<DpRepairStation> {

    public List<DpRepairStation> findByProductInfoId(String pdProductInfoId) ;

}
