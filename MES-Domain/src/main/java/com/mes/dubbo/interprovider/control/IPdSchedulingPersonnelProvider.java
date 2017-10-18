package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.entity.control.PdSchedulingPersonnel;

import java.util.List;
import java.util.Map;

/**
 * 排班管理-班次人员
*/
public interface IPdSchedulingPersonnelProvider extends DubboBaseInterface<PdSchedulingPersonnel> {

    void savePersonnels(PdSchedulingPersonnel pdSchedulingPersonnel);

    List<PdSchedulingPersonnel> getRestUser(Map<String,Object> map);
}
