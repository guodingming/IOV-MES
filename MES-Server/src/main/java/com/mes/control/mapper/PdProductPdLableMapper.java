package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdProductPdLable;

/**
 * 开发平台-产品明细-产品标签
 * Created by xiuyou.xu on 2017/09/27.
 */
public interface PdProductPdLableMapper extends BaseInterfaceMapper<PdProductPdLable> {

    /**
     * 根据产品明细ID查询已有产品标签数据
     *
     * @param pdProductInfoId
     * @return
     */
    public PdProductPdLable findByProductInfoId(String pdProductInfoId);

}
