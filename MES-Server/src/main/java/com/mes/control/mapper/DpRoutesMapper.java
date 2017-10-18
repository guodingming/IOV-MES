package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpRoutes;

import java.util.List;
import java.util.Map;

/**
 * 开发平台-工艺路径管理（Routes）
*/
public interface DpRoutesMapper extends BaseInterfaceMapper<DpRoutes> {
    /**
     * 根据开发工程id查询生产工序及工序基本信息
     *
     * @param projectId
     * @return
     */
    List<Map<String,Object>> getProcesses(String projectId);
}
