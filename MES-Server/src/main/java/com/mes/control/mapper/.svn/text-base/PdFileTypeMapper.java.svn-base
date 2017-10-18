package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdFileType;

import java.util.List;

/**
 * 文件分类管理
*/
public interface PdFileTypeMapper extends BaseInterfaceMapper<PdFileType> {

    /**
     * 查询文件类别树
     * @param type
     * @return
     */
    List<PdFileType> findByType(String type);

    public int countUsage(String fileTypeId);
}
