package com.mes.control.provider;

import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.utils.StringUtils;
import com.mes.control.mapper.DpProduceProcessDateMapper;
import com.mes.dubbo.interprovider.control.IDpProduceProcessDateProvider;
import com.mes.entity.control.DpProduceProcessDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 开发平台-生产工序配置-工序执行时间
 * Created by xiuyou.xu on 2017/08/30.
 */
public class DpProduceProcessDateProviderImpl extends BaseProviderImpl<DpProduceProcessDate> implements IDpProduceProcessDateProvider {
    private static Logger logger = LoggerFactory.getLogger(DpProduceProcessDateProviderImpl.class);

    @Autowired
    @Qualifier("dpProduceProcessDateMapper")
    private DpProduceProcessDateMapper dpProduceProcessDateMapper;

    @Override
    public DpProduceProcessDateMapper getBaseInterfaceMapper() {
        return dpProduceProcessDateMapper;
    }

    @Override
    public boolean updateConfigDateSet(DpProduceProcessDate produceProcessDate) throws DubboProviderException {
        boolean flag = true;
        try {
            String id = produceProcessDate.getId();
            if (StringUtils.isNotBlank(id)) {
                super.update(produceProcessDate);
            } else {
                super.save(produceProcessDate);
            }
        }catch (Exception e){
            flag = false;
            log.info("配置工序操作时间失败");
            throw new DubboProviderException(e.getMessage());
        }
        return flag;
    }
}
