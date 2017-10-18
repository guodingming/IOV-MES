package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.FtyDevice;
import com.mes.entity.control.FtyProcess;
import com.mes.entity.control.PdWorkOrder;
import com.mes.entity.control.User;

import java.util.List;

/**
 * 产品管理-工单管理
 */
public interface IPdWorkOrderProvider extends DubboBaseInterface<PdWorkOrder> {
    /**
     * 修改工单状态，启动或停止
     *
     * @param ids
     * @param s
     * @return
     */
    boolean updateStatus(String ids, String s) throws DubboProviderException;

    /**
     * 根据产品id查询工序列表
     *
     * @param pdId
     * @return
     */
    List<FtyProcess> getProcesses(String pdId) throws DubboProviderException;

    /**
     * 根据工单id查询对应的设备列表
     *
     * @param workOrderId
     * @return
     */
    List<FtyDevice> getDevices(String workOrderId);

    /**
     * 根据工单id查询对应的人员列表
     *
     * @param workOrderId
     * @return
     */
    List<User> getUsers(String workOrderId);

    public PdWorkOrder findByWorkOrderNum(String workOrderNum)throws DubboProviderException;

    /**
     * 保存生产线信息并启动工单
     *
     * @param workOrderId
     * @param productLineId
     * @param shiftId
     * @return
     * @throws DubboProviderException
     */
    public boolean saveProductLineStart(String workOrderId, String productLineId, String shiftId) throws DubboProviderException;

    public boolean check(String id)throws DubboProviderException;

}
