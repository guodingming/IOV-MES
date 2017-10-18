package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceChip;

import java.util.List;
import java.util.Map;

/**
* 开发平台-产品芯片
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IDpProduceChipProvider extends DubboBaseInterface<DpProduceChip> {

    /**
     * 导入芯片操作列表，文件为xls
     *
     * @param path
     * @param produceProcessId
     * @return
     */
    boolean saveImport(String path, String produceProcessId);

    /**
     * 导出芯片操作列表
     *
     * @param produceProcessId
     * @return
     */
    List<Map<String,Object>> getDownload(String produceProcessId);
}
