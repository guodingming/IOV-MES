package com.mes.control.mapper;

import com.mes.common.framework.mapper.BaseInterfaceMapper;
import com.mes.entity.control.PdProductBarCode;

/**
 * 产品管理-产品条码
 * Created by xiuyou.xu on 2017/09/28.
 */
public interface PdProductBarCodeMapper extends BaseInterfaceMapper<PdProductBarCode> {

    /**
     * 产品ID
     *
     * @param pdId
     */
    public void deleteAll(String pdId);

}
