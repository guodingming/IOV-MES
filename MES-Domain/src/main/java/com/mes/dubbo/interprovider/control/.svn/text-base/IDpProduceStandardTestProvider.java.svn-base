package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceStandardTest;

import java.util.List;
import java.util.Map;

/**
* 开发平台-产品测试标准
* Created by xiuyou.xu on 2017/7/4.
*/
public interface IDpProduceStandardTestProvider extends DubboBaseInterface<DpProduceStandardTest> {

    /**
     * 导入测试标准，文件为xls，两个sheet，第一个为测试顺序，第二个为测试标准
     *
     * @param path
     * @param produceProcessId
     * @return
     */
    boolean saveImport(String path, String produceProcessId);

    List<Map<String, Object>> getDownload(String produceProcessId);
}
