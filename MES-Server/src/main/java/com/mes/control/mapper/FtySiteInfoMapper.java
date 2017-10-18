package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.FtySiteInfo;

public interface FtySiteInfoMapper extends BaseInterfaceMapper<FtySiteInfo> {

    public int countUsage(String siteInfoId);
}
