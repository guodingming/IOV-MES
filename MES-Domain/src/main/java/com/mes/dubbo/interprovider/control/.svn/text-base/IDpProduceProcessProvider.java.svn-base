package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceProcess;

import java.util.List;
import java.util.Map;

/**
 * 产品管理--产品生产工序
*/
public interface IDpProduceProcessProvider extends DubboBaseInterface<DpProduceProcess> {
    /**
     * 添加生产工序
     *
     * @param process
     * @return
     */
    String saveProduceProcess(DpProduceProcess process) throws DubboProviderException;
    /**
     * 生产工序配置
     *
     * @param process
     * @return
     */
    boolean updateConfig(DpProduceProcess process) throws DubboProviderException;

    /**
     * 批量新增生产工序
     *
     * @param process
     * @return
     */
    boolean saveDpProduceProcess(DpProduceProcess process) throws DubboProviderException;

    /**
     * 生产工序上移下移排序
     * @param maxSortId 排序靠前的工序ID
     * @param minSortId 排序靠后的工序ID
     * @return
     * @throws DubboProviderException
     */
    boolean updateSort(String maxSortId, String minSortId) throws DubboProviderException;

    /**
     * 根据产品id查询生产工序id及工序名称列表
     *
     * @param pdId
     * @param isAuto
     * @return
     */
    List<Map<String, Object>> getProduceProcesses(String pdId, String isAuto);
}
