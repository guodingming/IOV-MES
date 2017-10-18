package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.DpLabel;

import java.util.List;

/**
 * 开发平台-标签管理
*/
public interface DpLabelMapper extends BaseInterfaceMapper<DpLabel> {
    public List<DpLabel> findByTypeId(String typeId);

    /**
     * 根据产品和标签code查询
     */
    public DpLabel findByPdAndCode(String pdId, String code);
}
