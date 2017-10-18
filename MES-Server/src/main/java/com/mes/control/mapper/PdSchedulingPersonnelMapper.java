package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdSchedulingPersonnel;

import java.util.List;
import java.util.Map;

/**
 * 排班管理-班次人员
*/
public interface PdSchedulingPersonnelMapper extends BaseInterfaceMapper<PdSchedulingPersonnel> {

    List<PdSchedulingPersonnel> getRestUser(Map<String,Object> map);

}
