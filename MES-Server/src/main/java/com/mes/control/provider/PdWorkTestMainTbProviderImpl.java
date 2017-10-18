package com.mes.control.provider;

import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.control.mapper.PdWorkTestMainTbMapper;
import com.mes.dubbo.interprovider.control.IPdWorkTestMainTbProvider;
import com.mes.entity.control.PdWorkTestMainTb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * 终端测试结果
 * Created by xiuyou.xu on 2017/09/01.
 */
public class PdWorkTestMainTbProviderImpl extends BaseProviderImpl<PdWorkTestMainTb> implements IPdWorkTestMainTbProvider {
    private static Logger logger = LoggerFactory.getLogger(PdWorkTestMainTbProviderImpl.class);

    @Autowired
    @Qualifier("pdWorkTestMainTbMapper")
    private PdWorkTestMainTbMapper pdWorkTestMainTbMapper;

    @Override
    public PdWorkTestMainTbMapper getBaseInterfaceMapper() {
        return pdWorkTestMainTbMapper;
    }

    @Override
    public long getOrder(String produceProcessId, String productInfoId) throws DubboProviderException {
        try {
            Map<String, Object> map = Maps.newHashMap();
            map.put("produceProcessId", produceProcessId);
            map.put("productInfoId", productInfoId);

            return super.countByCondition(map) + 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DubboProviderException(e);
        }
    }
}
