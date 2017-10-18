package com.mes.dubbo.interprovider.control;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.dubbo.DubboBaseInterface;
import com.mes.common.framework.rest.view.Page;
import com.mes.entity.control.DpBoxRule;

import java.util.List;
import java.util.Map;

/**
* 开发平台-包装箱管理--包装箱生成规则
* Created by dengyun.le on 2017/09/28
*/
public interface IDpBoxRuleProvider extends DubboBaseInterface<DpBoxRule> {

    public List saveBox(String id,String number)throws DubboProviderException;

    public Page findByPage(Page page, Map<String, Object> map) throws DubboProviderException;

}
