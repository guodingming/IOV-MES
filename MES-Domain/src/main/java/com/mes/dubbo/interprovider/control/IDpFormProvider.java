package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.DpForm;

import java.util.List;

/**
 * 开发平台-表单
*/
public interface IDpFormProvider extends DubboBaseInterface<DpForm> {

    /**
     * 根据产品Id查询以表单类型分类的表单列表
     * @param pdId
     * @return
     */
    List<Node> getFormTypedTree(String pdId);

    /**
     * 克隆表单
     * @param dpForm
     * @return
     */
    public boolean cloneForm(DpForm dpForm);

}
