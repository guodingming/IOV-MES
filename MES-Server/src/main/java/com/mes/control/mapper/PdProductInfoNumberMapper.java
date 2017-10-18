package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdProductInfoNumber;

import java.util.List;

/**
 * 开发平台-产品明细-产品编码
*/
public interface PdProductInfoNumberMapper extends BaseInterfaceMapper<PdProductInfoNumber> {

    public PdProductInfoNumber findByNumber(String number);
}
