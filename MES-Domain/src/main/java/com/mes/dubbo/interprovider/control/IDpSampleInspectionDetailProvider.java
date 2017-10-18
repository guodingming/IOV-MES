package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.JsonViewObject;
import com.mes.entity.control.DpSampleInspectionDetail;
import com.mes.entity.control.PdWorkOrder;

/**
* 产品管理-抽检管理-抽检详细
* Created by xiuyou.xu on 2017/09/12.
*/
public interface IDpSampleInspectionDetailProvider extends DubboBaseInterface<DpSampleInspectionDetail> {

    /**
     * 获取抽检信息和数据
     *
     * @param workOrder 当前工单信息
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject getQCInfo(PdWorkOrder workOrder) throws DubboProviderException;

    /**
     * 保存良品抽检信息
     *
     * @param workOrder 当前工单信息
     * @param number    页面输入条码
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject saveQualifiedInfo(PdWorkOrder workOrder, String number) throws DubboProviderException;


    /**
     * 保存不良信息
     *
     * @param dpSampleInspectionDetail
     * @return
     * @throws DubboProviderException
     */
    public JsonViewObject updateUnqualified(DpSampleInspectionDetail dpSampleInspectionDetail) throws DubboProviderException;

}
