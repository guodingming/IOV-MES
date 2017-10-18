package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.rest.view.Page;
import com.mes.control.mapper.PdBomProduceRulesMapper;
import com.mes.dubbo.interprovider.control.IPdBomProduceRulesProvider;
import com.mes.entity.control.PdBomProduceRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * 产品管理-生产BOM校验规则
 */
public class PdBomProduceRulesProviderImpl extends BaseProviderImpl<PdBomProduceRules> implements IPdBomProduceRulesProvider {
    @Autowired
    @Qualifier("pdBomProduceRulesMapper")
    private PdBomProduceRulesMapper pdBomProduceRulesMapper;

    @Override
    public PdBomProduceRulesMapper getBaseInterfaceMapper() {
        return pdBomProduceRulesMapper;
    }

    @Override
    public Page getPageByPd(Page page) throws DubboProviderException {
        Map<String, Object> params = Maps.newHashMap();
        if (page != null && page.getCondition() != null) {
            if (Map.class.isInstance(page.getCondition())) {
                params = (Map<String, Object>) page.getCondition();
            }
        }

        try {
            page.setTotal(this.getBaseInterfaceMapper().getCountByPd(params));
            params.put("startRowNum", page.getStartRowNum());
            params.put("pageSize", page.getPageSize());
            page.setRows(this.getBaseInterfaceMapper().getPageBypd(params));
        } catch (Exception e) {
            log.error("PdBomProduceRulesProviderImpl getPageByPd ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return page;
    }
}
