package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.DpProduceProcess;
import com.mes.entity.control.DpSampleInspection;
import com.mes.entity.control.PdWorkOrder;

/**
* 产品管理-抽检管理
* Created by xiuyou.xu on 2017/09/12.
*/
public interface IDpSampleInspectionProvider extends DubboBaseInterface<DpSampleInspection> {

    /**
     * 保存活着跟新抽检信息
     *
     * @param num
     * @param workOrder
     * @return
     * @throws DubboProviderException
     */
    public boolean saveOrUpdate(int num, PdWorkOrder workOrder) throws DubboProviderException;

    /**
     * 抽检结束批量放行
     *
     * @param pdWorkOrder
     * @param userId
     * @param produceProcess
     * @return
     */
    public boolean passStation(PdWorkOrder pdWorkOrder, String userId, DpProduceProcess produceProcess) throws DubboProviderException;

}
