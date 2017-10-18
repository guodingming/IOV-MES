package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdLine;

/**
 * 产品管理-产品线
*/
public interface PdLineMapper extends BaseInterfaceMapper<PdLine> {

    int countUsage(String pdLineId);
}
