package com.mes.control.provider;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.groovy.GroovyUtil;
import com.mes.common.framework.rest.view.Page;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.DpBarcodeMapper;
import com.mes.control.mapper.DpBoxMapper;
import com.mes.control.mapper.DpBoxRuleMapper;
import com.mes.control.mapper.DpFunctionMapper;
import com.mes.dubbo.interprovider.control.IDpBoxRuleProvider;
import com.mes.entity.control.DpBarcode;
import com.mes.entity.control.DpBox;
import com.mes.entity.control.DpBoxRule;
import com.mes.entity.control.DpFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * 开发平台-包装箱管理
 * Created by dengyun.le on 2017/09/28.
 */
public class DpBoxRuleProviderImpl extends BaseProviderImpl<DpBoxRule> implements IDpBoxRuleProvider {
    private static Logger logger = LoggerFactory.getLogger(DpBoxRuleProviderImpl.class);

    @Autowired
    @Qualifier("dpBoxRuleMapper")
    private DpBoxRuleMapper dpBoxRuleMapper;
    @Autowired
    @Qualifier("dpBoxMapper")
    private DpBoxMapper dpBoxMapper;
    @Autowired
    @Qualifier("dpBarcodeMapper")
    private DpBarcodeMapper dpBarcodeMapper;
    @Autowired
    @Qualifier("dpFunctionMapper")
    private DpFunctionMapper dpFunctionMapper;

    @Override
    public DpBoxRuleMapper getBaseInterfaceMapper() {
        return dpBoxRuleMapper;
    }


    public List saveBox(String id, String number)throws DubboProviderException{
        List Ids =new ArrayList();
        int num =parseInt(number);
        Map map = new HashMap();

        DpBoxRule dpBoxRule = dpBoxRuleMapper.findById(id);
        int capacity = dpBoxRule.getCapacity();
        map.put("parems",dpBoxRule);
        if(dpBoxRule !=null) {
            String pdId = dpBoxRule.getPdId();
           // String barcodeTypeId = dpBoxRule.getBarcodeTypeId();
            String barcodeId = dpBoxRule.getBarcodeId();
           // String labelTypeId = dpBoxRule.getLabelTypeId();
            String labelId = dpBoxRule.getLabelId();
            DpBarcode dpBarcode = dpBarcodeMapper.findById(barcodeId);
            if(dpBarcode != null){
                String funtionId = dpBarcode.getFunctionId();
                DpFunction dpFunction = dpFunctionMapper.findById(funtionId);
                String script = dpFunction.getScript();
                String boxKey;
                String idd = null;
                for (int i=0;i<num;i++){
                    idd = IDGenerator.getID();
                    DpBox dpBox = new DpBox();
                    dpBox.setId(idd);
                    dpBox.setCapacity(Long.valueOf(capacity));
                    try {
                        boxKey = (String) GroovyUtil.evalScript(script,map);
                        dpBox.setBoxKey(boxKey);
                        dpBox.setDpBoxRuleId(id);
                        dpBox.setPdId(pdId);
                        dpBox.setIsForcedPack("0");
                        dpBox.setQuantity(0L);
                        dpBoxMapper.save(dpBox);
                        Ids.add(idd);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }


                }

            }

        }

        return Ids;
    }

    public Page findByPage(Page page, Map<String, Object> map) throws DubboProviderException {
        Page pageLoad = page;
        try {
            //pageLoad.setTotal(this.getBaseInterfaceMapper().getCount(map));
//            map.put("pageNum",page.getPageNum());
           // map.put("startRowNum", page.getStartRowNum());
           // map.put("pageSize", page.getPageSize());
//            map.put("endRowNum",page.getEndRowNum());
            pageLoad.setRows(this.getBaseInterfaceMapper().findByPage(map));
        } catch (Exception e) {
            log.error("DubboBaseInterfaceImpl findByPage ", e);
            throw new DubboProviderException(e.getMessage(), e);
        }
        return pageLoad;
    }
}
