package com.mes.dubbo.interprovider.control;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Node;
import com.mes.entity.control.PdBomWork;

import java.util.List;
import java.util.Map;

/**
 * 产品管理-工单BOM管理
*/
public interface IPdBomWorkProvider extends DubboBaseInterface<PdBomWork> {
    /**
     * 根据bom id查询bom物料清单树
     *
     * @param bomId
     * @return
     */
    List<Node> getMaterialTree(String bomId);

    /**
     * 查询bom下物料不同版本数量相关信息列表
     *
     * @param bomId
     * @param code
     * @return
     */
    List<Map<String, Object>> getMaterialAmount(String bomId, String code) throws DubboProviderException;
}
