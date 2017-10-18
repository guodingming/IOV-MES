package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceDemarcate;

import java.util.List;
import java.util.Map;

/**
* 开发平台-产品标定
* Created by xiuyou.xu on 2017/08/30.
*/
public interface IDpProduceDemarcateProvider extends DubboBaseInterface<DpProduceDemarcate> {

    /**
     * 导入产品标定列表，文件为xls
     *
     * @param path
     * @param produceProcessId
     * @return
     */
    boolean saveImport(String path, String produceProcessId);

    /**
     * 导出产品标定列表
     *
     * @param produceProcessId
     * @return
     */
    List<Map<String,Object>> getDownload(String produceProcessId);

}
