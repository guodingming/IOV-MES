package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.FtyProductionLine;

public interface FtyProductionLineMapper extends BaseInterfaceMapper<FtyProductionLine> {

    int countUsage(String productionLineId);


}
